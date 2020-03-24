/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Uploads;
import model.User;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.*;

/**
 *
 * @author K00214105
 */
@WebServlet(name = "UploadController", urlPatterns = {"/UploadController"})
public class UploadController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        System.out.println("in process request");
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String menu = "home";
        List<FileItem> items = null;
        session = request.getSession();

        if (isMultipart) {
            System.out.println("multi request");
            //get list of item in request
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            System.out.println("part 1");
            try {

                items = upload.parseRequest(request);
                System.out.println("part 2");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("part 3");
            menu = getMultiRequest(items, "menu");

        } else {
            System.out.println("single request");
            menu = request.getParameter("menu");

        }

        System.out.println("p2");
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            session.setAttribute("user", user);
        }
        Uploads upload = (Uploads) session.getAttribute("uploads");
        if (upload == null) {
            upload = new Uploads();
            session.setAttribute("uploads", upload);
        }

       // menu = request.getParameter("menu");
        if (menu == null) {
            menu = "home";
        }
        System.out.println("upload controller");
        User current = new User();
        current = (User) session.getAttribute("user");

        System.out.println("p3");

        switch (menu) {

            case "home":
                System.out.println("upload controller switch home");
                Uploads uploads = new Uploads();
                ArrayList<Uploads> alluploads = new ArrayList<>();
                alluploads = uploads.getAllUploads();
                session.setAttribute("alluploads", alluploads);
                System.out.println("`size of upload" + alluploads.size());
                gotoPage("/userGallery.jsp", request, response);
                System.out.println(alluploads);
                break;

            case "Add Upload":
                System.out.println("In Switch add upload");
                gotoPage("/addProject.jsp", request, response);
                break;

            case "Save Upload":
                System.out.println("switch save upload");
                
                 //get request data
                String title = getMultiRequest(items, "title");
                System.out.println("title" + title);
                String desc = getMultiRequest(items, "description");

                String image = doFileUpload(items, response);
                System.out.println("image" + image);
                System.out.println("request data" + title + " " + desc + " " + image);
                //create notice
                Uploads u = new Uploads(image, title, desc, user.getUserid());
                u.saveToDatabase(); 
                Uploads uploads3 = new Uploads();
                ArrayList<Uploads> alluploads3 = new ArrayList<>();
                alluploads3 = uploads3.getUserUploads(current.getUserid());
                session.setAttribute("userUploads", alluploads3);
                gotoPage("/userGallery.jsp", request, response);
                break;

            case "Delete Upload":
                System.out.println("delete upload");
                System.out.println("Upload ID: " + request.getParameter("uploadId"));
                String snid = request.getParameter("uploadId");
                int nid = Integer.parseInt(snid);
                Uploads uploads2 = new Uploads();
                boolean worked = uploads2.deleteUpload(nid);
                ArrayList<Uploads> alluploads2 = new ArrayList<>();
                alluploads2 = uploads2.getUserUploads(current.getUserid());
                session.setAttribute("userUploads", alluploads2);
                gotoPage("/userGallery.jsp", request, response);
                break;

            case "Edit Upload":
                snid = request.getParameter("uploadId");
                nid = Integer.parseInt(snid);
                Uploads uu = new Uploads();
                Uploads uus = uu.getSelectedUpload(nid);
                session.setAttribute("selectedUpload", uus);
                gotoPage("/editProject.jsp", request, response);
                break;

            case "Save User Details":
                snid = request.getParameter("uploadId");
                nid = Integer.parseInt(snid);
                Uploads uploads4 = new Uploads();
                worked = ProcessUpdate(request, nid, session);
                ArrayList<Uploads> alluploads4 = new ArrayList<>();
                alluploads4 = uploads4.getUserUploads(current.getUserid());
                session.setAttribute("userUploads", alluploads4);
                gotoPage("/userGallery.jsp", request, response);
                break;

            case "getUserUploads":
                System.out.println("get user uploads");
                System.out.println("upload id" + current.getUserid());
                int uploadid = (current.getUserid());
                Uploads userUpload = new Uploads();
                ArrayList<Uploads> userUploads = new ArrayList<>();
                userUploads = userUpload.getUserUploads(uploadid);
                session.setAttribute("userUploads", userUploads);
                gotoPage("/userGallery.jsp", request, response);
                break;

            case "getUploadView":
                System.out.println("get upload view");
                String uploadids = request.getParameter("uploadID");
                uploadid = Integer.parseInt(uploadids);
                Uploads uploadsView = new Uploads();
                uploadsView = uploadsView.getUploadDetails(uploadid);
               
                if (uploadsView != null) {

                    session.setAttribute("drilldown", uploadsView);
                    //get user details for notcie
                    User userUploadView = new User();
                  
                    userUploadView = userUploadView.getUserDetails(userUploadView.getUserid());
                    if (userUploadView != null) {
                        System.out.println("notice user" + userUploadView.getUsername());
                        session.setAttribute("noticeUser", userUploadView);
                    } 
                }
                gotoPage("/detailedView.jsp", request, response);
                break;
        }
    }

    private void gotoPage(String url,
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    private String doFileUpload(List<FileItem> items,
            HttpServletResponse response) {

        String fileName = null;
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            //  List items = upload.parseRequest(request);
            Iterator iterator = items.iterator();
            while (iterator.hasNext()) {
                FileItem item = (FileItem) iterator.next();

                if (!item.isFormField()) {

                    fileName = item.getName();
                    System.out.println("file name " + fileName);
                    String root = getServletContext().getRealPath("/");
                    File path = new File(root + "/img");
                    if (!path.exists()) {
                        boolean status = path.mkdirs();
                    }

                    File uploadedFile = new File(path + "/" + fileName);
                    System.out.println(uploadedFile.getAbsolutePath());
                    
                    item.write(uploadedFile);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    private String getMultiRequest(List<FileItem> items, String fieldnameRequired) {
        System.out.println("in mult request form");
        String fname = null;

        for (FileItem uploadItem : items) {

            String fieldName = uploadItem.getFieldName();

            if (fieldnameRequired.equals(fieldName)) {
                System.out.println(uploadItem.getString());
                return uploadItem.getString();
            }

        }

        return fname;
    }
//User userid,

    private void ProcessSave(HttpServletRequest request, User localuser, HttpSession session) {
        String image = request.getParameter("image");
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        User user = (User) session.getAttribute("user");
        Uploads uploads = new Uploads(image, title, description, localuser.getUserid());
        System.out.println("process save id: " + localuser.getUserid());
        uploads = uploads.saveToDatabase();

        session.setAttribute("upload", uploads);
        //System.out.println("userid" + us.getUserid());
    }

    private boolean ProcessUpdate(HttpServletRequest request, int uploadId, HttpSession session) {
        System.out.println("process update method");
        String image = request.getParameter("image");
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Uploads uploads = new Uploads(uploadId, image, title, description);
        uploads = uploads.updateDateabase(uploadId, image, title, description);

        session.setAttribute("uploads", uploads);
        return true;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
