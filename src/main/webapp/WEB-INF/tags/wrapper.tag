<%@tag description="Simple wrapper tag" pageEncoding = "UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
  <body>
    <div id="pageHeader">
      <link rel="stylesheet" type="text/css" href="../../static/css/bootstrap_flatly.min.css" />
      <link rel="stylesheet" type="text/css" href="../../static/css/toastr.min.css" />
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
      <nav class="navbar navbar-default unselectable">
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
      <jsp:invoke fragment="header"/>
    </div>
    <div id="body">
        <script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="../../static/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../../static/js/toastr.min.js"></script>
        <script>
            $(function () {
                toastr.options = {
                    "closeButton": true,
                    "debug": false,
                    "newestOnTop": false,
                    "progressBar": false,
                    "positionClass": "toast-top-center",
                    "preventDuplicates": false,
                    "onclick": null,
                    "showDuration": "300",
                    "hideDuration": "1000",
                    "timeOut": "5000",
                    "extendedTimeOut": "1000",
                    "showEasing": "swing",
                    "hideEasing": "linear",
                    "showMethod": "slideDown",
                    "hideMethod": "slideUp"
                };
            })
        </script>
        <jsp:doBody/>
    </div>
    <div id="pageFooter">
        <jsp:invoke fragment="footer"/>
    </div>
  </body>
</html>
