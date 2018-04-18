package edu.gatech.epidemics.fhir;

import ca.uhn.fhir.rest.api.MethodOutcome;
import org.hl7.fhir.dstu3.model.QuestionnaireResponse;

import java.util.List;

/**
 * @author atalati
 */
public class Answers extends FhirBase {

    public Answers(String baseUrl) {
        super(baseUrl);
    }

    public String createQuestionnaireResponse(String questionnaireId, QuestionnaireResponse questionnaireResponse) {
        String questionnaireReferenceUrl = String.format("%s/Questionnaire/%d", getBaseUrl(), questionnaireId);
        questionnaireResponse.setStatus(QuestionnaireResponse.QuestionnaireResponseStatus.COMPLETED);

        questionnaireResponse
                .getQuestionnaire()
                .setReference(questionnaireReferenceUrl);

        MethodOutcome request = getClient().create()
                .resource(questionnaireResponse)
                .prettyPrint()
                .encodedJson()
                .execute();

        String questionnaireResponseId = request.getId().getIdPart();
        return questionnaireResponseId;
    }
}
