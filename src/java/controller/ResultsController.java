/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Results;

public class ResultsController extends HttpServlet {

//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Results result = (Results) session.getAttribute("result");
        if (result == null) {
            result = new Results();
            session.setAttribute("result", result);
        }

        String menu = "home";
        menu = request.getParameter("menu");

        if (menu == null) {
            System.out.println("menu is null");
            menu = "home";
        }
        switch (menu) {

            case "Save":
                ProcessSave(request, session);
                gotoPage("/AdminControllPage.jsp", request, response);
                break;

            case "updateResults":
                gotoPage("/detailedResultsView.jsp", request, response);
                break;
            case "DeleteResults":
                String snid = request.getParameter("id");
                int nid = Integer.parseInt(snid);
                Results result2 = new Results();
                boolean worked = result2.deleteResult(nid);

                ArrayList<Results> allresults2 = new ArrayList<>();
                allresults2 = result2.getAllResults();

                session.setAttribute("allresults", allresults2);
                gotoPage("/manageResults.jsp", request, response);
                break;


            case "Update":
                ProcessUpdate(request, session, result);
                gotoPage("/manageResults.jsp", request, response);
                break;
            case "getResultsView":

                String resId = request.getParameter("id");
                int Id = Integer.parseInt(resId);
                System.out.println("id" + resId);

                Results s = new Results();
                s = s.getResultsDetails(Id);

                if (s != null) {

                    session.setAttribute("results", s);
                    System.out.println("sesion contents" + session.getAttribute("results"));
                    Results u = new Results();
                    System.out.println("get result details " + s.getId());
                    u = u.getResultsDetails(s.getId());
                    if (u != null) {
                        System.out.println("results" + u.getCategory());
                        session.setAttribute("results", u);
                    } else {
                        System.out.println("results details null");
                    }

                }
                gotoPage("/detailedResultsView.jsp", request, response);
                break;

            case "home":

                Results results = new Results();
                ArrayList<Results> allresults = new ArrayList<>();
                allresults = results.getAllResults();
                session.setAttribute("allresults", allresults);
                gotoPage("/manageResults.jsp", request, response);
                System.out.println("in switch");
                break;

            case "SaveResultDetails":
                boolean worked1 = ProcessResultsUpdate(request, result, session);
                gotoPage("/manageResults.jsp", request, response);
                break;
            default:
                gotoPage("/invalid.jsp", request, response);
                break;


        }
    }

    private void ProcessSave(HttpServletRequest request, HttpSession session) {

        String category = request.getParameter("category");
        String type = request.getParameter("type");
        String difficulty = request.getParameter("difficulty");
        String question = request.getParameter("question");
        String correct_answer = request.getParameter("correct_answer");
        String incorrect_answers1 = request.getParameter("incorrect_answers1");

//        
        System.out.println(category);
        Results res = new Results(category, type, difficulty, question, correct_answer, incorrect_answers1);
        res.saveToDatabase();

        session.setAttribute("result", res);

    }

    private void gotoPage(String url,
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
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

    public void ProcessUpdate(HttpServletRequest request, HttpSession session, Results result) {
        String category = request.getParameter("category");
        String type = request.getParameter("type");
        String difficulty = request.getParameter("difficulty");
        String question = request.getParameter("question");
        String correct_answer = request.getParameter("correct_answer");
        String incorrect_answers1 = request.getParameter("incorrect_answers1");

        System.out.println("category");
        Results res = new Results(result.getId(), category, type, difficulty, question, correct_answer, incorrect_answers1);

        res.updateResults();
        System.out.println("saving");
        session.setAttribute("res", res);
        System.out.println("ID " + result.getId());
        System.out.println("worked");

    }

    private void ProcessDelete(HttpServletRequest request, HttpSession session, Results result) {
        Results results = new Results(result.getId());
        results.delete(result.getId());
        session.setAttribute("results", results);

    }

    private boolean ProcessResultsUpdate(HttpServletRequest request, Results result, HttpSession session) {
        String category = request.getParameter("category");
        String type = request.getParameter("type");
        String difficulty = request.getParameter("difficulty");
        String question = request.getParameter("question");
        String correct_answer = request.getParameter("correct_answer");
        String incorrect_answers1 = request.getParameter("incorrect_answers1");

        int Id = result.getId();
        System.out.println("in process update");

        Results results = result.updateResultsDatabase(Id, category, type, difficulty, question, correct_answer, incorrect_answers1);
        // put it back in the sesssion
        System.out.println("after update");
        session.setAttribute("results", results);
        return true;
    }
}
