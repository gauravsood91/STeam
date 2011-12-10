<%-- 
    Document   : login
    Created on : Jun 21, 2011, 11:06:06 PM
    Author     : saurabh
--%>
<%@page language="java" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>

<%

//HttpSession sess=request.getSession();
//String loggedin=(String)sess.getAttribute("loggedin");
    Cookie c[] = request.getCookies();
    String loggedin = c[0].getValue();
    if (loggedin.equals("1")) {
        response.sendRedirect("home.jsp");
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <title>STeam>>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function clearName(){
                document.getElementById("txtname").value="";
            }
        </script>
    </head>
    <body>
    <font size="4" face="Garmond" color="green">Login Page</font>
        <hr><center><br><br>    <center><font size="4" face="Garmond" color="#9900FF">
        <form method="post" action="login">
            <table border="1" color="green"><center>
                    <tr><td>     <table border="0">
                                <tr>

                                    <td><br>Username: </td><td><br><input type="text" name="txtname" id="txtname" onclick="clearName();" value="Username"><br />
                                    </td>
                                </tr>
                                <tr>
                                    <td><br>Password: </td><td><br><input type="password" name="txtpasswd"><td><br />
                                    </td>
                                </tr>
                                <tr>
                                    <td><br>
                                        Login Type:</td><td> <br><select name="type">
                                            <option>User</option>
                                            <option>Organisation</option>
                                        </select><br /></td></tr></table>
                    <center> <br> <input type="submit">
                            <br /><br />
                        </td></tr></table><br><br>
            <a href="usr_reg.jsp">User Registration</a><br />
            <a href="companyreg.jsp">Company Registration</a>
        </form>
    </body>
</html>
