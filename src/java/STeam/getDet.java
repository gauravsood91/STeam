package STeam;
import db.dbconnect;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class getDet extends HttpServlet 
{
        String usr_name,pass1,pass2;
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        pass1=request.getParameter("pass");
        pass2=request.getParameter("pass_rep");
        String q_ins;
        String []data=new String[8];
        data[0]=request.getParameter("emailusr");
        data[1]=request.getParameter("usr_name");
        data[2]=request.getParameter("sel_loc");
        data[3]=request.getParameter("mob_no");
        data[4]=request.getParameter("exp_yr");
        data[5]=request.getParameter("key_skills");
        data[6]=request.getParameter("edu");
        int result=0;
        q_ins="insert into usr_login (usr_name,passwd,email_usr,location,ph_no,total_exp_yr,key_skills,edu_qualifs) values ('"+data[1]+"','"+pass1+"','"+data[0]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"','"+data[5]+"','"+data[6]+"')";
         dbconnect connect_db=new dbconnect(q_ins);
        out.println(q_ins);
         if(pass1.equals(pass2) && !data[0].equals("") && !data[1].equals("") && !data[2].equals("")
                 && !data[3].equals("") && !data[4].equals("") && !data[5].equals("") &&
                 !data[6].equals(""))
        {
            result=connect_db.modifyQuery();
        }
        else
        {
           out.println("passwords do not match");
        }
        if(result==1)
        {
            out.println("ID Creation Successful!!");
            response.sendRedirect("login.jsp");
        }
        else
        {
            out.println("Error while creating ID");
            response.sendRedirect("usr_reg.jsp");
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
