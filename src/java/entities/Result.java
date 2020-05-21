package entities;

/**
 *
 * @author Daly
 */
public class Result
{

	private int Id;
	private String category;
	private String type;
	private String difficulty;
	private String question;
	private String correct_answer;
	private String incorrect_answers1;

	public Result()
	{

	}
	public Result(String category, String type, String difficulty, String question, String correct_answer, String incorrect_answers1)
	{
		this.category = category;
		this.type = type;
		this.difficulty = difficulty;
		this.question = question;
		this.correct_answer = correct_answer;
		this.incorrect_answers1 = incorrect_answers1;
	}


	public Result(int Id, String category, String type, String difficulty, String question, String correct_answer, String incorrect_answers1)
	{
		this.Id = Id;
		this.category = category;
		this.type = type;
		this.difficulty = difficulty;
		this.question = question;
		this.correct_answer = correct_answer;
		this.incorrect_answers1 = incorrect_answers1;
	}

	public Result(int Id)
	{
		this.Id = Id;
	}

	public int getId()
	{
		return Id;
	}

	public void setId(int Id)
	{
		this.Id = Id;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getDifficulty()
	{
		return difficulty;
	}

	public void setDifficulty(String difficulty)
	{
		this.difficulty = difficulty;
	}

	public String getQuestion()
	{
		return question;
	}

	public void setQuestion(String question)
	{
		this.question = question;
	}

	public String getCorrect_answer()
	{
		return correct_answer;
	}

	public void setCorrect_answer(String correct_answer)
	{
		this.correct_answer = correct_answer;
	}

	public String getIncorrect_answers1()
	{
		return incorrect_answers1;
	}

	public void setIncorrect_answers1(String incorrect_answers1)
	{
		this.incorrect_answers1 = incorrect_answers1;
	}
}
