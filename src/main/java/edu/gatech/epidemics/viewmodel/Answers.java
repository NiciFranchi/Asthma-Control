package edu.gatech.epidemics.viewmodel;

import java.util.List;

/**
 * @author atalati
 * /api/user
 */
public class Answers
{
	private int patiendId;
	private List<String> answers;

	public Answers()
	{
	}

	public Answers(int patiendId, List<String> answers)
	{
		this.patiendId = patiendId;
		this.answers = answers;
	}
}
