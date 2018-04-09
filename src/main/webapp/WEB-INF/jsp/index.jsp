<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:wrapper>

<jsp:attribute name="header">
</jsp:attribute>

    <jsp:body>
        <div class="col-md-6">

            <h2>Sign In ...</h2>

            <form action="/" method="post">
                <input id= "tbUsername" name="username" type="text">
                <input id= "tbPassword" name="password" type="password">
                <button type="submit">Login</button>
            </form>

            <%--<button onClick="doLogin()">Login</button>--%>
        </div>

        <%--<script type="text/javascript">--%>
            <%--var doLogin = function() {--%>
                <%--var loginData = new Object();--%>
                <%--loginData.username = $('#tbUsername').val();--%>
                <%--loginData.password = $('#tbPassword').val();--%>
                <%--var _url = '/';--%>
                <%--$.ajax({--%>
                    <%--type: 'POST',--%>
                    <%--// headers: {--%>
                    <%--//     'Accept': 'application/json',--%>
                    <%--//     'Content-Type': 'application/json'--%>
                    <%--// },--%>
                    <%--url: _url,--%>
                    <%--data: JSON.stringify(loginData),--%>
                    <%--dataType: 'json',--%>
                    <%--success: function (data) {--%>
                        <%--console.log('login succeeded');--%>
                        <%--console.log(data);--%>
                        <%--if(data == "True"){--%>
                            <%--window.location.href = '';--%>
                        <%--}--%>
                    <%--},--%>
                    <%--error: function (xhr, status, err) {--%>
                        <%--console.log(err);--%>
                        <%--console.log(status);--%>
                        <%--console.log(xhr);--%>
                        <%--alert('login failed');--%>
                    <%--}--%>
                <%--});--%>
            <%--};--%>
        <%--</script>--%>
    </jsp:body>
</t:wrapper>