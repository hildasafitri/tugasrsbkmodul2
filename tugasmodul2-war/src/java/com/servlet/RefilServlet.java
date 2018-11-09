/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.session.refilgalon;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Agung
 */
public class RefilServlet extends HttpServlet {

    @EJB
    private refilgalon refilgalon;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
       protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {            
            out.println("<html>");
            out.println("<body");
            out.println("<h1><center>Tugas RSBK Refil Galon</center></h1>");
            String galon = request.getParameter("galon");
            
            if ((galon != null) && (galon.length() > 0)) {
                double d = Double.parseDouble(galon);
                if (request.getParameter("Refil Aqua") != null){
                    String reaq = refilgalon.refil_aqua(d);
                    out.println("<p> Harganya: Rp "+reaq+"</p>");
                }  
                if (request.getParameter("Refil Vit") != null) {
                    String revi = refilgalon.refil_vit(d);
                    out.println("<p> Harganya: Rp "+revi+ " .</p>");
                }
                if (request.getParameter("Refil Cleo") != null) {
                    String recl = refilgalon.refil_cleo(d);
                    out.println("<p> Harganya: Rp " +recl+ " .</p>");
                }
                if (request.getParameter("Refil Pelangi") != null) {
                    String repe = refilgalon.refil_pelangi(d);
                    out.println("<p> Harganya: Rp "+repe+ " .</p>");
                }
                if (request.getParameter("Refil Abal") != null) {
                    String reab = refilgalon.refil_abal(d);
                    out.println("<p> Harganya: Rp "+reab+ " .</p>");
                }                
                if (request.getParameter("Refil Tak Beremerek") != null) {
                    String retabe = refilgalon.refil_takbermerek(d); 
                    out.println("<center><p> Harganya: Rp "+retabe+ " .</p></center>");
                }
                
            } else {
                out.println("<center>");
                out.println("<p>Masukan Jumlah Galon:</p>");
                out.println("<form method=\"get\">");
                out.println("<p><input type=\"text\" name=\"galon\" size=\"20\"></p>");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"Refil Abal\" value=\"Refil Abal\">"+ "<input type=\"submit\" name=\"Refil Tak Beremerek\" value=\"Refil Tak Beremerek\">");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"Refil Aqua\" value=\"Refil Aqua\">"+ "<input type=\"submit\" name=\"Refil Vit\" value=\"Refil Vit\">");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"Refil Cleo\" value=\"Refil Cleo\">"+ "<input type=\"submit\" name=\"Refil Pelangi\" value=\"Refil Pelangi\">");
                out.println("</center>");
                out.println("</form>");
            }
        
        } finally {
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }               
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
