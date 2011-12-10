<%-- 
    Document   : index
    Created on : Jun 23, 2011, 9:11:53 AM
    Author     : devworks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>STeam>>Create User</title>
    </head>
     <style>
               table{
               font-size:12px;
               background:pink;
               position:relative;
               border:2px solid #272727;
               }
        </style>
    <body bgcolor="#b0b0ff">
        <h1><center>New User Registration</center></h1>
        <form method="post" action="getDet"><center><table border="1">
                    <tr><td><table border="0">
                <tr>
                    <td>Name </td><td><input type="text" name="usr_name" size="50"/><br> </td>
                </tr>
                <tr><td>Email Id </td><td> <input type="text" name="emailusr" size="50"/><br></td>
                </tr>
                <tr>
                    <td>
            Password </td> <td><input type="password" name="pass" size="50"/><br></td>
                </tr>
                <tr>
                    <td>
            Confirm Password</td><td>  <input type="password" name="pass_rep" size="50"/><br></td>
                </tr>
                <tr>
                    <td> 
            <h3>Contact Details</h3><br></td>
                <tr>
                    <td>Location</td><td>
           <select name="sel_loc">
                <option>Bengaluru</option>
                <option>Delhi</option>
                <option>Bombay</option>
                <option>Lucknow</option>
                <option>Srinagar</option>
                <option>Shimla</option>
                <option>Dehradoon</option>
                <option>Patna</option>
                <option>Ranchi</option>
                <option>Kolkata</option>
                <option>Guwahati</option>
                <option>Itanagar</option>
                <option>Gangtok</option>
                <option>Bhopal</option>
                <option>Jaipur</option>
                <option>Bhubaneshwar</option>
                <option>Hyderabad</option>
                <option>Chennai</option>
                <option>Thiruvananthapuram</option>
           </select><br></td>
                </tr>
                <tr><td>
            Mobile      </td>   <td><input type="text" name="mob_no" size="50"/><br></td>  
                <tr><td><h3>Current Professional Details</h3></td></tr>
                <tr><td>
            Total Experience</td><td>
            <select name="exp_yr">
                <option>1</option><option>2</option>
                <option>3</option><option>4</option>
                <option>5</option><option>6</option>
                <option>7</option><option>8</option>      
            </select> Years <br />              </td>
                </tr>
                <tr><td>
            Key Skills </td><td><input type="text" name="key_skills" size="50"/><br></td>
                </tr>
                <tr>
                    <td>
            <h3>Education Details</h3><br></td><td>
            <textarea name="edu" rows="4" cols="57"></textarea><br>
            </br></td></tr></table>
                   
                    <center><input type="submit" name="submit" value="Submit" /></center></td></tr></table></center>
        </form>
    </body>
</html>
