<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
  
<jsp:attribute name="header">   
</jsp:attribute>

<jsp:body>
        
            <div id="questions" class="questionsContainer">
                <form id="infantQ" action="">

                <h1>Astham Control Form for Infants</h1>

                <!-- One "tab" for each step in the form: -->
                <div class="tab">Q1:
                </div>

                <div class="tab">Q2:
                </div>

                <div class="tab">Q2:
                </div>

                <div class="tab">Q2:
                </div>

                <div class="tab">Q2:
                </div>

                <div style="overflow:auto;">
                  <div style="float:right;">
                    <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
                    <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
                  </div>
                </div>

                <!-- Circles which indicates the steps of the form: -->
                <div style="text-align:center;margin-top:40px;">
                  <span class="step"></span>
                  <span class="step"></span>
                  <span class="step"></span>
                  <span class="step"></span>
                </div>

                </form>
            </div>

            <script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
            <script type="text/javascript" src="../../static/js/bootstrap.min.js"></script>
            <script type="text/javascript">
                $(document).ready(function () {
                    var ageGroupId = 1;
                    var url = '/api/questionnaire/' + ageGroupId.toString();
                    var questionHtml = '';
                    $.getJSON(url, function (data) {
                        console.log('got json');
                        console.log(data);
                        $.each(data, function (key, val) {
                            questionHtml = 
                            "<div id='" + val.id + "'>" + 
                                "<h3 class='questionText'>" + val.questionText + "</h3>" + 
                                "<div class='list-group'>";
                            for(var i = 0; i< val.answerChoices.length; i++){
                                questionHtml += "<button type='button' class='list-group-item'>"+ val.answerChoices[i].toString() + "</button>";
                            }
                            questionHtml+="</div></div>";
                            $('#questions').append(questionHtml);
                        });
                        questionHtml = '';
                    }).fail(function () {
                        console.log('did not got json');
                    });

                });
            </script>
</jsp:body>
</t:wrapper>
 
