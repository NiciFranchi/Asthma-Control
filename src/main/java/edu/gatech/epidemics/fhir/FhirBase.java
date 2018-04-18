package edu.gatech.epidemics.fhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.springframework.stereotype.Service;

/**
 * @author atalati
 */
public abstract class FhirBase {
    private String  baseUrl;
    private IGenericClient client = null;

    public FhirBase(String baseUrl) {
        this.baseUrl = baseUrl;
        FhirContext ctx = FhirContext.forDstu3();
        this.client = ctx.newRestfulGenericClient(baseUrl);;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public IGenericClient getClient() {
        return client;
    }

    public void setClient(IGenericClient client) {
        this.client = client;
    }
}
