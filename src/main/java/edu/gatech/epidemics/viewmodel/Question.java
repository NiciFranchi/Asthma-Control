package edu.gatech.epidemics.viewmodel;

import java.util.List;

/**
 * @author atalati
 * /api/user
 */
public class Question
{
	private int id;
	private String questionText;
	private String answer;
	private List<String> answerChoices;

	public Question()
	{
	}

	public Question(int id, String questionText, String answer, List<String> answerChoices)
	{
		this.id = id;
		this.questionText = questionText;
		this.answer = answer;
		this.answerChoices = answerChoices;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getQuestionText()
	{
		return questionText;
	}

	public void setQuestionText(String questionText)
	{
		this.questionText = questionText;
	}

	public String getAnswer()
	{
		return answer;
	}

	public void setAnswer(String answer)
	{
		this.answer = answer;
	}

	public List<String> getAnswerChoices()
	{
		return answerChoices;
	}

	public void setAnswerChoices(List<String> answerChoices)
	{
		this.answerChoices = answerChoices;
	}
}
