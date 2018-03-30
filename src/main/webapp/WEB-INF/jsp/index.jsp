<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>

        <head>
            <link rel="stylesheet" type="text/css" href="../../static/css/bootstrap.min.css" />
            <link rel="stylesheet" type="text/css" href="../../static/css/bootstrap-theme.min.css" />
        </head>

        <body>
            <nav class="navbar navbar-inverse">
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

            <div id="questions" class="questionsContainer">
                
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
        </body>
        <footer>
            By the way, I still speak whale. Go to
            <a href="http://localhost:8080/api/user/hello">http://localhost:8080/api/user/hello</a>
            ;-)
        </footer>

        </html>