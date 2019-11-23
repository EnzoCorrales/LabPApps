/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabrixstar
 */
public class AltaListaDRServlet extends HttpServlet {

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
            out.println("<title>Servlet AltaListaDRServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaListaDRServlet at " + request.getContextPath() + "</h1>");
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

        response.setContentType("text/html;charset=UTF-8");
        WSClient.SistemaService service = new WSClient.SistemaService();
        WSClient.Sistema port = service.getSistemaPort();

        PrintWriter out = response.getWriter();
        HttpSession sesion = request.getSession();
        String user = (String) sesion.getAttribute("username");
        String NLista = request.getParameter("NombreLDRPpart");
        String[] Categoria = request.getParameterValues("Categoria");
        String priv = request.getParameter("privado");
        List<String> cat = new ArrayList<>();
        boolean es = false;
        if (priv.equalsIgnoreCase("privado")) {
            es = true;
        }
        if (Categoria == null) {
            request.getRequestDispatcher("AltaListaDR.jsp").include(request, response);
            out.print("<p style='color: red; font-size: larger;'>No eligio categoria!</p>");
        } else {
            for (String Categoria1 : Categoria) {
                cat.add(Categoria1);
            }
            if (!port.existeLista(user, NLista)) {
                port.crearListaParticular(user, NLista, es, cat);
                RequestDispatcher rd = request.getRequestDispatcher("MiPerfil.jsp");
                rd.forward(request, response);
            } else {
                request.getRequestDispatcher("AltaListaDR.jsp").include(request, response);
                out.print("<p style='color: red; font-size: larger;'>Esta lista ya existe!</p>");
            }
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
