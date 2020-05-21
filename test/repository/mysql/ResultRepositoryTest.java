package repository.mysql;

import entities.Result;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rob
 */
public class ResultRepositoryTest
{

	public ResultRepositoryTest()
	{
	}

	@BeforeClass
	public static void setUpClass()
	{
	}

	@Test
	public void testInsertAndDelete() throws Exception
	{
		//		System.out.println("insertResult");
//		Result result_2 = null;
//		int expResult = 0;
//		int result = ResultRepository.insertResult(result_2);
//		assertEquals(expResult, result);

//		System.out.println("deleteResultById");
//		int id = 0;
//		boolean expResult = false;
//		boolean result = ResultRepository.deleteResultById(id);
//		assertEquals(expResult, result);
		fail("The test case is a prototype.");
	}

	@Test
	public void testGetResultById() throws Exception
	{
		System.out.println("getResultById");
		int Id = 100;
		Result expResult = new Result(100, "Maths", "3rd class", "Easy", "4 + 4", "8", "5 3 7");
		Result result = ResultRepository.getResultById(Id);

		assertEquals(expResult.getCategory(), result.getCategory());
		assertEquals(expResult.getId(), result.getId());
		assertEquals(expResult.getCorrect_answer(), result.getCorrect_answer());
		assertEquals(expResult.getIncorrect_answers1(), result.getIncorrect_answers1());
	}

	@Test
	public void testGetResults() throws Exception
	{
		System.out.println("getResults");
		ArrayList<Result> result = ResultRepository.getResults();
		assertNotNull(result);
	}

	@Test
	public void testUpdateResult() throws SQLException
	{
		System.out.println("updateResult");

		int Id = 100;
		Result expResult = new Result(100, "Maths", "3rd class", "Easy", "4 + 4", "8", "5 3 9");
		Result result = ResultRepository.getResultById(Id);

		result.setIncorrect_answers1(expResult.getIncorrect_answers1());

		ResultRepository.updateResult(result);
		
		assertEquals(expResult.getIncorrect_answers1(), result.getIncorrect_answers1());

		fail("The test case is a prototype.");
	}

}
