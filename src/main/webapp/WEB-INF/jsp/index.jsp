<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="../../static/css/bootstrap_flatly.min.css" />
    <style type="text/css">
        .unselectable {
            -webkit-user-select: none;
            /* Safari */
            -moz-user-select: none;
            /* Firefox */
            -ms-user-select: none;
            /* IE10+/Edge */
            user-select: none;
            /* Standard */
        }

        .navbar-default {
            background-color: #eaaa00;
            border-color: #e5e5e5;
        }

        .navbar-default .navbar-brand {
            color: #545454;
        }

        .navbar-default .navbar-brand:hover,
        .navbar-default .navbar-brand:focus {
            color: #545454;
        }

        .navbar-default .navbar-text {
            color: #545454;
        }

        .navbar-default .navbar-nav>li>a {
            color: #545454;
        }

        .navbar-default .navbar-nav>li>a:hover,
        .navbar-default .navbar-nav>li>a:focus {
            color: #545454;
        }

        /* .navbar-default .navbar-nav>li>.dropdown-menu {
            background-color: #eaaa00;
        }

        .navbar-default .navbar-nav>li>.dropdown-menu>li>a {
            color: #545454;
        }

        .navbar-default .navbar-nav>li>.dropdown-menu>li>a:hover,
        .navbar-default .navbar-nav>li>.dropdown-menu>li>a:focus {
            color: #545454;
            background-color: #e5e5e5;
        }

        .navbar-default .navbar-nav>li>.dropdown-menu>li.divider {
            background-color: #e5e5e5;
        }

        .navbar-default .navbar-nav .open .dropdown-menu>.active>a,
        .navbar-default .navbar-nav .open .dropdown-menu>.active>a:hover,
        .navbar-default .navbar-nav .open .dropdown-menu>.active>a:focus {
            color: #545454;
            background-color: #e5e5e5;
        } */

        .navbar-default .navbar-nav>.active>a,
        .navbar-default .navbar-nav>.active>a:hover,
        .navbar-default .navbar-nav>.active>a:focus {
            color: #545454;
            background-color: #e5e5e5;
        }

        .navbar-default .navbar-nav>.open>a,
        .navbar-default .navbar-nav>.open>a:hover,
        .navbar-default .navbar-nav>.open>a:focus {
            color: #545454;
            background-color: #e5e5e5;
        }

        .navbar-default .navbar-toggle {
            border-color: #e5e5e5;
        }

        .navbar-default .navbar-toggle:hover,
        .navbar-default .navbar-toggle:focus {
            background-color: #e5e5e5;
        }

        .navbar-default .navbar-toggle .icon-bar {
            background-color: #545454;
        }

        .navbar-default .navbar-collapse,
        .navbar-default .navbar-form {
            border-color: #545454;
        }

        .navbar-default .navbar-link {
            color: #545454;
        }

        .navbar-default .navbar-link:hover {
            color: #545454;
        }

        @media (max-width: 767px) {
            .navbar-default .navbar-nav .open .dropdown-menu>li>a {
                color: #545454;
            }

            .navbar-default .navbar-nav .open .dropdown-menu>li>a:hover,
            .navbar-default .navbar-nav .open .dropdown-menu>li>a:focus {
                color: #545454;
            }

            .navbar-default .navbar-nav .open .dropdown-menu>.active>a,
            .navbar-default .navbar-nav .open .dropdown-menu>.active>a:hover,
            .navbar-default .navbar-nav .open .dropdown-menu>.active>a:focus {
                color: #545454;
                background-color: #e5e5e5;
            }
        }
    </style>
</head>

<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                    aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Epidemics</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="#">Home
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">Patient</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">Action</a>
                            </li>
                            <li>
                                <a href="#">Another action</a>
                            </li>
                            <li>
                                <a href="#">Something else here</a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li>
                                <a href="#">Separated link</a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li>
                                <a href="#">One more separated link</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search patient">
                    </div>
                    <button type="button" class="btn btn-default">Submit</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#">Help</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Aarsh
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">Profile</a>
                            </li>
                            <li>
                                <a href="#">Settings</a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li>
                                <a href="#">Logout</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

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
    <script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../../static/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {

            // hardcoding some variables, these might come from API at some point
            var ageGroupId = 1;
            var ageGroupTxt = "0-4";
            var url = '/api/questionnaire/' + ageGroupId.toString();
            var questionHtml = '';
            var header = "<h3 class='text-center'>" + ageGroupTxt + " Years Old Asthma Control Assessment" + "</h3>";
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
                console.log('hide #' + questionId);
                $('#' + questionId).hide();
                current--;
                questionId = 'question' + current.toString();
                console.log('show #' + questionId);
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
                if (current + 1 > max) {
                    return;
                }
                var questionId = 'question' + current.toString();
                console.log('hide #' + questionId);
                $('#' + questionId).hide();
                current++;
                questionId = 'question' + current.toString();
                console.log('show #' + questionId);
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
</body>

</html>