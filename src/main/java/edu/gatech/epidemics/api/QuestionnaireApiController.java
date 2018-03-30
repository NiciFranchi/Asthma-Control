package edu.gatech.epidemics.api;

import edu.gatech.epidemics.viewmodel.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author atalati
 * <p>
 * /api/user
 */
@RestController
public class QuestionnaireApiController
{
	@GetMapping(value = "/api/questionnaire/{id}")
	public List<Question> get(@PathVariable int id)
	{
		// infant, young, older
		Question infantQ1 = new Question(1, "First question for infant", "", Arrays.asList("q1 a1", "q1 a2"));
		Question infantQ2 = new Question(2, "Second question for infant", "", Arrays.asList("q2 a1", "q2 a2", "q2 a3"));
		Question infantQ3 = new Question(3, "Third question for infant", "", Arrays.asList("q3 a1", "q3 a2"));
		Question infantQ4 = new Question(4, "Fourth question for infant", "", Arrays.asList("q4 a1", "q4 a2", "q4 a3", "q4 a4"));

		Question youngQ1 = new Question(5, "First question for young", "", Arrays.asList("q1 a1", "q1 a2"));
		Question youngQ2 = new Question(6, "Second question for young", "", Arrays.asList("q2 a1", "q2 a2", "q2 a3"));
		Question youngQ3 = new Question(7, "Third question for young", "", Arrays.asList("q4 a1", "q4 a2", "q4 a3", "q4 a4"));

		Question olderQ1 = new Question(8, "First question for older", "", Arrays.asList("q1 a1", "q1 a2"));
		Question olderQ2 = new Question(9, "Second question for older", "", Arrays.asList("q2 a1", "q2 a2", "q2 a3"));
		Question olderQ3 = new Question(10, "Third question for older", "", Arrays.asList("q3 a1", "q3 a2"));
		Question olderQ4 = new Question(11, "Fourth question for older", "", Arrays.asList("q4 a1", "q4 a2", "q4 a3"));

		List<Question> questions = new ArrayList<Question>();

		if(id ==1)
		{
			questions.add(infantQ1);
			questions.add(infantQ2);
			questions.add(infantQ3);
			questions.add(infantQ4);
		}
		else if(id ==2)
		{
			questions.add(youngQ1);
			questions.add(youngQ2);
			questions.add(youngQ3);
		}
		else if(id ==3)
		{
			questions.add(olderQ1);
			questions.add(olderQ2);
			questions.add(olderQ3);
			questions.add(olderQ4);
		}
		else
		{
			questions = null;
		}
		return questions;
	}
}