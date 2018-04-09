<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../static/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="../../static/css/bootstrap-theme.min.css"/>
</head>
<body>
<div>User list:</div>

<ul username="ulUsers" class="list-group">

</ul>

<script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../../static/js/bootstrap.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $.getJSON('/api/user', function (data) {
            var users_html = [];
            $.each(data, function (key, val) {
                users_html.push("<li class=\"list-group-item\" username='" + key + "'>" + val.username + "</li>");
            });
            $('#ulUsers').append(users_html);
        });
    });
</script>

</body>
</html>