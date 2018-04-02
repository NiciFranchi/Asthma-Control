<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:wrapper>
  
<jsp:attribute name="header">   
</jsp:attribute>

<jsp:body>
    <div class="container">
        <div id="topText" class="topTextContainer unselectable"></div>
        <div id="questions" class="questionsContainer unselectable"></div>
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
    <script type="text/javascript">
        $(document).ready(function () {

            // hardcoding some variables, these might come from API at some point
            var ageGroupId = 1;
            var ageGroupTxt = "0-4";
            var url = '/api/questionnaire/' + ageGroupId.toString();
            var questionHtml = '';
            var header = "<h2 class='text-center'>" + ageGroupTxt + " Years Old Asthma Control Assessment" + "</h2>";
            $('#topText').append(header);


            // paging
            var current = 1;
            var min = 1;
            var max = 1;

            // load data
            $.getJSON(url, function (data) {
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
                    toastr.success('Answers submitted');
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
        });

        // sometimes, jQuery might not recognize dynamically created DOM objects, after page load
        var highlightAnswerChoice = function(btnId){
            $('.answer-choices button').removeClass('active');
            $('#' + btnId).addClass('active');
        };
    </script>
</jsp:body>
</t:wrapper>
