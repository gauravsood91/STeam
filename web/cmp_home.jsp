<%--
    Document   : cmp_home
    Created on : Jun 26, 2011, 9:51:20 AM
    Author     : gaurav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.Cookie" %>
<%@page import="java.sql.*" %>
<%@page import="db.dbconnect" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>STeam>>Home</title>
    </head>
    <body><body bgcolor="#b0b0ff">
        <font size="4" face="Garmond" color="green">Company Home</font>
        <hr><center>
        <h1>Home</h1>
        <% 
            Cookie[] ck=request.getCookies();
            String query="select * from job_det where org_id="+ck[1].getValue();
            dbconnect ret_job=new dbconnect(query);
            ResultSet rs=ret_job.returnResults();
            
                int found=0;
                try{
                out.println("<ol>");
                while(rs.next()){
                    found=1;
                    out.println("Title: "+rs.getString("title"));
                    out.println("<br>");
                }
                               }
                catch(SQLException e){
                    e.printStackTrace();
                }
                if(found==0){
                    out.println("No Jobs Posted");
                }
            
        %>
       <!-- <%=ck[0].getValue() %> -->
       <br /><br /><br />
       <a href="post_job.jsp">Post a Job</a><br /><br><br>
    <img src="images/back.jpg"><center>
        </body>
</html>
