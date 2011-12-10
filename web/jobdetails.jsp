<%-- 
    Document   : jobdetails
    Created on : Jun 26, 2011, 12:26:50 AM
    Author     : saurabh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" %>
<%@page  import="java.sql.*"%>
<%@page import="db.dbconnect" %>

<%
String title=null,description=null,location=null,skills=null,contactno=null,address=null,experience=null;
int salary=0;


int value=Integer.parseInt(request.getParameter("id"));
String query="select * from job_det where jid="+value;
System.out.println(query);
dbconnect db=new dbconnect(query);
ResultSet res=db.returnResults();
try{
while(res.next()){
    title=res.getString("title");
    description=res.getString("description");
    location=res.getString("location");
    skills=res.getString("skills");
    salary=res.getInt("sal");
    contactno=res.getString("contact_no");
    address=res.getString("address");
    experience=res.getString("exp");
}
}
catch(SQLException e){
    e.printStackTrace();
}


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>STeam>>Job Details</title>
    </head>
    <body>
        <h1><%=title %></h1><br/><br />
        Description:<%=description %><br />
        Location:<%=location %><br />
        Skills:<%= skills %><br />
        Salary:<%= salary %><br />
        Experience:<%= experience %><br />
        Address:<%= address %><br />
        Contact No: <%= contactno %><br />
        
    </body>
</html>
