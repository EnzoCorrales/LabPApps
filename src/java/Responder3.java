/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Fabrica.FabricaSistema;
import Interfaz.ISistema;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kangaru
 */
public class Responder3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Responder3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Responder3 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        String comentario = new String(request.getParameter("comentario").getBytes("ISO-8859-1"), "UTF-8");
        HttpSession sesion = request.getSession();
        String usuario = (String) sesion.getAttribute("username");
        String nomVideo = new String(request.getParameter("nomVideo").getBytes("ISO-8859-1"), "UTF-8");
        String nick = new String(request.getParameter("usr").getBytes("ISO-8859-1"), "UTF-8");
        String nickC = new String(request.getParameter("nickC").getBytes("ISO-8859-1"), "UTF-8");
        String comC = new String(request.getParameter("comC").getBytes("ISO-8859-1"), "UTF-8");

        FabricaSistema f = new FabricaSistema();
        ISistema s = f.getSistema();
        
        System.out.println("AKJFADSFDJSKFDAJLKFKDFDFSKAFSKJAFSKFDKASDJK");

        if (nomVideo.equalsIgnoreCase("50")) {
            s.AgregarRespuesta(nick, nomVideo, nickC, comC, usuario, comentario);
            response.sendRedirect("Video.jsp?value=" + nomVideo + "&usr=" + nick);
        } else {
            response.sendRedirect("Index2.jsp");
        }

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
