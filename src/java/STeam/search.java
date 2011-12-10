/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package STeam;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import db.dbconnect;
/**
 *
 * @author saurabh
 */
public class search extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Search Results</title></head><body>");
        try {
             String q=request.getParameter("q");
             String query="select * from job_det where title like '%"+q+"%' or description like '%"
                     +q+"%' or skills like '%"+q+"%'";
             System.err.println(query);
             dbconnect db=new dbconnect(query);
             ResultSet res=db.returnResults();
             int count=0;
             try{
             while(res.next()){
                 count++;
             }
             }
             catch(SQLException f){
             }
             if(count==0){
                 out.println("No Results Found");
                 out.println("<br />");
                 out.println("<a href=home.jsp>Back</a>");
                         
             }
             else{
             res=db.returnResults();    
             out.println("<ol>");
             printres:{
             try{
//                 if(!res.last()){
//                     out.println("No Results Found");
//                     break printres;
//                 }
                 while(res.next()){
                     int id=res.getInt("jid");
                     out.println("<li>");
                     out.println("<a href=jobdetails.jsp?id="+id+">");
                     out.println(res.getString("title"));
                     out.println("</li>");
                 }
                 out.println("</ol>");
             }
             catch(SQLException e){
                 e.printStackTrace();
             }
        }
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
