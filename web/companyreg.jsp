<%-- 
    Document   : companyreg
    Created on : 26 Jun, 2011, 11:05:37 AM
    Author     : devworks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>STeam>>Employer Registration</title>
    </head>
    <style>
               table{
               position:relative;
               border:2px solid #272727;
               padding:10px;
               }
               body{
                   background: url(images/back.jpg) no-repeat;
                   position:relative;   
               }
        </style>
    <body>
        <h1><center>Employer Registration</center></h1>
        <form method="post" action="company_reg">
            <center><table border="1">
                <tr>
                    <td>
                        <table border="0">
                            <tr>
                                <td>Email Id </td><td> <input type="text" name="emailcomp"/><br></td>
                            <tr><td>Password </td><td> <input type="password" name="passcomp"/><br></td></tr>
                            <tr><td>
            Confirm Password </td><td> <input type="password" name="pass_comp"/><br></td></tr>
                            <tr><td>
            Company Name </td><td> <input type="text" name="cname" /><br></td>
                            </tr><tr><td>
                                State</td><td>
           <select name="sel_loc_comp">
                <option>    Uttar Pradesh</option>
                <option>Delhi</option>
                <option>Bombay</option>
                <option>Lucknow</option>
           </select><br></td></tr>
                            <tr><td>
                                    Contact No.  </td><td>       <input type="text" name="con_no"/><br></td>  
            
                            <tr><td>City </td><td> <input type="text" name="city" /><br></td>
                            </tr>
                            <tr><td>
                                    Address </td><td> <input type="text" name="add_comp" /><br></td></tr></table>
                <center><input type="submit" name="submit" /></center></tr></table>
        </form>   
    </body>
</html>
