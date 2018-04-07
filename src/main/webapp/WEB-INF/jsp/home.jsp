<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:wrapper>

<jsp:attribute name="header">
</jsp:attribute>

<jsp:body>
    <div class="container unselectable" id = "questionsPage">
        <div id="topText" class="topTextContainer"></div>
        <div id="questions" class="questionsContainer"></div>
        <div class="row">
            <div class="col-xs-1">
                <div id="counter"></div>
            </div>
            <div class="col-xs-10">
                <nav>
                    <ul class="pager">
                        <li>
                            <button id="btPreviousQuestion" class="btn btn-default">Previous</button>
                        </li>
                        <li>
                            <button id="btNextQuestion" class="btn btn-default">Next</button>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="col-xs-1"></div>
        </div>
  </div>
  <div class = "container" id = "resultspage" hidden>
    <!-- HTML section for RESULTS page, which will eventually be moved to a new .jsp file
       hard coded for now, will adjust when API is availbale (returned calculated control levels + recomendation)
       as part of this, div id topText is left appearing for now -->
    <div class="py-2">
      <div class="container unselectable">
        <div class="row">
          <div class="col-md-6">
            <h2 id ="hImpairmentText" class="text-center"><b style="font-weight: bold;" >Impairment: </b>Well controlled</h2>
          </div>
          <div class="col-md-6">
            <h2 id = "hRiskText" class="text-center"><b style="font-weight: bold;">Risk:</b> Well controlled</h2>
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
            <ul id = "ulActionTreatment" class="" contenteditable="true" id="treatment_actions">
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
     <button id="btSubmitFHIR" class="btn btn-default">Save Action for Treatment</button>
   </div>
  </div>
    <script type="text/javascript">
        var answersDictionary;
        (function(){
            answersDictionary = {};
        })();
        $(document).ready(function () {
            // hardcoding some variables, these might come from API at some point
            var ageGroupId = 1;
            var patientId = 5;
            var ageGroupTxt = "0-4";
            var questionHtml = '';
            var url = '/api/questionnaire/' + ageGroupId.toString();
            var header = "<h2 class='text-center'>" + ageGroupTxt + " Years Old Asthma Control Assessment" + "</h2>";

            $('#topText').append(header);
            // paging
            var current = 1;
            var min = 1;
            var max = 1;
            // load data
            $.get(url, function (data) {
                // for paging
                max = data.length;
                $.each(data, function (key, val) {
                    questionHtml =
                        "<div id= 'question" + val.id + "' class='question'>" +
                        "<h3 class='questionText'>" + val.questionText + "</h3>" +
                        "<div class='list-group answer-choices'>";
                    for (var i = 0; i < val.answerChoices.length; i++) {
                        questionHtml += "<button type='button' id = 'answer" + val.id + "_" + i.toString() + "' class='list-group-item answer-choice' onClick=highlightAnswerChoice(this.id)>" + val.answerChoices[i].toString() + "</button>";
                    }
                    questionHtml += "</div>";
                    $('#questions').append(questionHtml);
                });
                questionHtml = '';
                // for paging
                $('.question').hide();
                $("#btPreviousQuestion").hide();
                $('#question1').show();
                $('#counter').text(current.toString() + '/' + max.toString());
            }).fail(function () {
                console.log('did not got json');
            });
            // pagination
            $("#btPreviousQuestion").click(function () {
                if (current - 1 < min) {
                    return;
                }
                var questionId = 'question' + current.toString();
                $('#' + questionId).hide();
                current--;
                questionId = 'question' + current.toString();
                $('#' + questionId).show();
                $('#counter').text(current.toString() + '/' + max.toString());
                if (current == min) {
                    $("#btPreviousQuestion").hide();
                }
                if (current == max - 1) {
                    $('#btNextQuestion').text('Next'); Automatic
                    $('#btNextQuestion').addClass('btn-default');
                    $('#btNextQuestion').removeClass('btn-primary');
                }
            });
            $("#btNextQuestion").click(function () {
                if ($('#btNextQuestion').text() == 'Submit'){
                    // disable the button while the answers are being submitted
                    // show success toastr on json success

                    var url = '/api/questionnaire/';
                    var answers = new Object();
                    answers.patientId = patientId;
                    answers.answers = '';
                    $.each(answersDictionary, function(k, v){
                        answers.answers += k.toString() + '_' + v.toString() + '|';
                    });
                    $.ajax({
                        type: 'POST',
                        headers:{
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        url: url,
                        data: JSON.stringify(answers),
                        dataType:'json',
                        success: function(){
                            toastr.success('Answers submitted');
                        },
                        error: function(xhr, status, err){
                            toastr.error('Couldn\'t sumbit.');
                            console.log(xhr);
                            console.log(status);
                            console.log(err);
                        }
                    });
                    // temporarily here, hide questions and show results (will actually go to new page)
                    $("#questionsPage").hide();
                    $("#resultspage").show();
                }
                if (current + 1 > max) {
                    return;
                }
                var questionId = 'question' + current.toString();
                $('#' + questionId).hide();
                current++;
                questionId = 'question' + current.toString();
                $('#' + questionId).show();
                if (current == max) {
                    $('#btNextQuestion').text('Submit');
                    $('#btNextQuestion').removeClass('btn-default');
                    $('#btNextQuestion').addClass('btn-primary');
                }
                else if (current == min + 1) {
                    $("#btPreviousQuestion").show();
                }
                $('#counter').text(current.toString() + '/' + max.toString());
            });
            // this code will move to RESULTS.jsp, call FHIR API to save there.
            $("#btSubmitFHIR").click(function () {
                // disable the button while the answers are being submitted
                // show success toastr on json success
               toastr.success('Action plan submitted to FHIR');
            });
        });
        // sometimes, jQuery might not recognize dynamically created DOM objects, after page load
        var highlightAnswerChoice = function(btnId){
            $('.answer-choices button').removeClass('active');
            $('#' + btnId).addClass('active');
            ans = (btnId.replace('answer','')).split('_');
            answersDictionary[ans[0]] = ans[1];
        };
    </script>
</jsp:body>
</t:wrapper>