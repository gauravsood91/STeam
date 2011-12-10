package STeam;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.dbconnect;
import java.sql.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 *
 * @author saurabh
 */
public class login extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String uname=null,passwd=null,query,type=null;
        int found=0;
        ResultSet res=null;
        try {
            uname=request.getParameter("txtname");
            passwd=request.getParameter("txtpasswd");
            type=request.getParameter("type");
            if(type.equals("User"))
            {
                query="select * from usr_login where email='"+uname+"' and pass='"+passwd+"'";
                dbconnect db=new dbconnect(query);
                 res=db.returnResults();
                            }
            else  
            {
                query="select * from comp_reg where email='"+uname+"' and pass='"+passwd+"'";
                dbconnect db=new dbconnect(query);
                res=db.returnResults();
            }
            try{
                while(res.next()){
                    if(uname.equals(res.getString("email")) && passwd.equals(res.getString("pass"))){
                        found=1;
                        break;
                    }
                }
            }
                
            catch(SQLException e){
                e.printStackTrace();
            }
            int uid=0;
            if(type.equals("User") && found==1)
            {
                       try {
                    uid = res.getInt("uid");
                } catch (SQLException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
                Cookie cookie=new Cookie("loggedin","1");
                Cookie userid=new Cookie("userid",""+uid);
                response.addCookie(cookie);
                response.addCookie(userid);
                response.sendRedirect("home.jsp");
            }
            else if(type.equals("Organisation") && found==1)
            {
                try
                {
                    uid=res.getInt("cid");
                }catch(SQLException e){
                    //Logger.getLogger(login.class.getName()).log(Level.SEVERE,null,ex);
                }
                Cookie cookie=new Cookie("loggedin","1");
                Cookie org_id=new Cookie("cid",""+uid);
                response.addCookie(cookie);
                response.addCookie(org_id);
                response.sendRedirect("cmp_home.jsp");
            }
            else
            {
                response.sendRedirect("login.jsp");
            }
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
