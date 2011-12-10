<%-- 
    Document   : post_job
    Created on : Jun 25, 2011, 11:25:50 AM
    Author     : gaurav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>STeam>>Post Job</title>
    </head>
    <body bgcolor="#b0b0ff">
        <font size="4" face="Garmond" color="green">Post Jobs</font>
    <hr><center>
        <h1></h1>
        <font size="4" face="Garmond" color="red">Post a Job</font><br>
        <br><form action="jobpost" method="post"  />
        <!--<table border="0"><tr><td>-->
        <table border="0"><tr><td><br>
                    Organization:</td> <td><br><input type="text" name="org" size="50" /></td></tr>
            <tr><br><td><br>
                Job Title:</td><td><br> <input type="text" name="title" size="50"/></td></tr>
            <tr><td><br>Location:</td><td><br> <input type="text" name="loc" size="50"/></td></tr>
            <tr><td><br>Experience:</td><td> <br><select name="exp"/>
            <option value="0to5">0-5</option>
            <option value="5to10">5-10</option>
            <option value="10to15">10-15</option>
            <option value="15to20">15-20</option>
            <option value="20plus">20+</option>
            </select><br /><br /></td></tr>
            <tr><td><br>
                    Job Description:</td><td><br> <textarea name="desc" rows="4" cols="57"/></textarea><br /></td>
            <tr><td><br>
                    Salary:</td><td><br> <input type="text" name="sal" size="50"/></td></tr>
            <tr><td><br>
                    Required Skills: </td><td><br><input type="text" name="skills" size="50"/></td></tr>
            <tr><td><br>
                    Address:</td><td> <br><input type="text" name="addr" size="50"/></td></tr>
            <tr><td><br>
                    Contact No: </td><td><br><input type="text" name="ph_no" size="50"/></td></tr></table>
        <br><center><input type="submit" name="Submit" value="Post Job"/></center>
    </form>
</body>
</html>
