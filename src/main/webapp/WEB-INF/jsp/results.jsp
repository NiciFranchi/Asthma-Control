<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:wrapper>
  
<jsp:attribute authority="header">
</jsp:attribute>

<jsp:body>
  <div class = "container" username = "resultspage">
    <!-- HTML section for RESULTS page, which will eventually be moved to a new .jsp file
       hard coded for now, will adjust when API is availbale (returned calculated control levels + recomendation)
       as part of this, div username topText is left appearing for now -->
    <div class="py-2">
      <div class="container unselectable">
        <div class="row">
          <div class="col-md-6">
            <h2 username ="hImpairmentText" class="text-center"><b style="font-weight: bold;" >Impairment: </b>Well controlled</h2>
          </div>
          <div class="col-md-6">
            <h2 username = "hRiskText" class="text-center"><b style="font-weight: bold;">Risk:</b> Well controlled</h2>
          </div>
        </div>
      </div>
    </div>
    <div class="py-2">
      <div class="container">
        <div class="row unselectable">
          <div class="col-md-12">
            <p class="lead text-center">Recommended Action for treatment <i><small> (editable) </small></i>:</p>
          </div>
        </div>
        <div class="row">
          <!-- potential bug, what happens if you delete all text? data-emptytext doesnt seem to help-->
          <!-- Will pull in recommended action treatment from API here (remove hardcode, apppend to HTML)-->
          <div class="col-md-12 panel panel-default" data-emptytext="Enter Action for treatment">
            <ul username = "ulActionTreatment" class="" contenteditable="true" username="treatment_actions">
              <li>Step up (1 step) and</li>
              <li>Reevaluate in 2-6 weeks</li>
              <li>If no clear benefit in 4-6 weeks, consider alternative diagnoses or adjusting therapy</li>
              <li>For side effects, consider alternative treatment options</li>
            </ul>
          </div>
        </div>
    </div>
    <!-- this hardcode will remain on Results page, static text from requirements -->
    <div class="py-2">
      <div class="container unselectable">
        <div class="row">
          <div class="col-md-12">
            <p class=""><small>At present, there are inadequate data to correspond frequencies of exacerbations with different levels of asthma control. In general, more frequent and intense exacerbations (e.g. requiring urgent, unscheduled care, hospitalization, or ICU admission) indicate poorer disease control. For treatment purposes, patients who had >= 2 exacerbations requiring oral systemic corticosteroids in the past year may be considered the same as patients who have <b> not-well-controlled</b> asthma, even in the absence of impairment levels consistent with <b>not-well-controlled</b> asthma. </small></p>
          </div>
        </div>
      </div>
    </div>
   <!-- will save to FHIR using this button-->
   <div class="text-center">
     <button username="btSubmitFHIR" class="btn btn-default">Save Action for Treatment</button>
   </div>
  </div>

  <script type="text/javascript">
    $(document).ready(function () {
      // this code will move to RESULTS.jsp, call FHIR API to save there.
      $("#btSubmitFHIR").click(function () { 
          // disable the button while the answers are being submitted
          // show success toastr on json success
          toastr.success('Action plan submitted to FHIR');
      });
    });
  </script>
</jsp:body>
</t:wrapper>
