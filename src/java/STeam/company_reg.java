package STeam;
import db.dbconnect;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class company_reg extends HttpServlet {
        String passchk,passcnf;
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String data_ins;
        int result=0;
        String [] details;
        details=new String[8];
        details[0]=request.getParameter("emailcomp");
        details[1]=request.getParameter("passcomp");
        details[2]=request.getParameter("pass_comp");
        details[3]=request.getParameter("cname");
        details[4]=request.getParameter("sel_loc_comp");
        details[5]=request.getParameter("con_no");
        details[6]=request.getParameter("add_comp");
        details[7]=request.getParameter("city");
        data_ins="insert into comp_reg (email,pass,comp_name,state,contact_no,address,city) values('"+details[0]+"','"+details[1]+"','"+details[3]+"','"+details[4]+"','"+details[5]+"','"+details[6]+"','"+details[7]+"')";
        dbconnect con_db=new dbconnect(data_ins);
        out.println(data_ins);
        out.println(details[0]);
        out.println(details[1]);
        if(details[1].equals(details[2]) && !details[0].equals("") && !details[3].equals("") && !details[4].equals("")
                && !details[5].equals("") && !details[6].equals("") && !details.equals(""))
        {
            out.println("true");
            result=con_db.modifyQuery();
            out.println(result);
            //out.println("Created");
            response.sendRedirect("login.jsp");
        }
        else
        {
           response.sendRedirect("companyreg.jsp");
        }
        if(result==1)
        {
            out.println("ID Creation Successful!!");
        }
        else
        {
            out.println("Error while creating ID");
        }

        
        try {} finally {            
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
