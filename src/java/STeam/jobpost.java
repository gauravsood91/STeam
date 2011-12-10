package STeam;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import db.*;
/**
 *
 * @author gaurav
 */
public class jobpost extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String loc,title,exp,skills,addr,ph_no,role;
        int sal,org_id;
        title=request.getParameter("title");
        loc=request.getParameter("loc");
        exp=request.getParameter("exp");
        addr=request.getParameter("addr");
        ph_no=request.getParameter("ph_no");
        role=request.getParameter("desc");
        skills=request.getParameter("skills");
        role=request.getParameter("desc");
        Cookie[] ck=request.getCookies();
        org_id=Integer.parseInt(ck[1].getValue());
        sal=Integer.parseInt(request.getParameter("sal"));
        String q="insert into job_det (title,description,exp,location,skills,sal,contact_no,address,org_id) values ('"+title+"','"+role+"','"+exp+"','"+loc+"','"+skills+"','"+sal+"','"+ph_no+"','"+addr+"','"+org_id+"')";
        dbconnect post=new dbconnect(q);
        int rs=post.modifyQuery();
        if(rs==1)
        {
            out.println("Row Inserted");
        }
        else
        {
            out.println("Error");
        }
        try {
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
