/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DT.DtLR;
import DT.DtVideo;
import Fabrica.FabricaSistema;
import Interfaz.ISistema;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tecnologo
 */
public class AgregarVideoServlet extends HttpServlet {

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
            out.println("<title>Servlet AgregarVideoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarVideoServlet at " + request.getContextPath() + "</h1>");
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

        String nomVideo = request.getParameter("video");
        FabricaSistema f = new FabricaSistema();
        ISistema s = f.getSistema();
        Collection<DtVideo> videos = s.ListaTVideos();
        Iterator<DtVideo> it = videos.iterator();
        DtVideo dtvid = null;
        while (it.hasNext()) {
            if (it.next().getNomVideo().equalsIgnoreCase(nomVideo)) {
                dtvid = it.next();
            }
        }
        Collection<DtLR> listas = s.ListaTLR();
        String lista = request.getParameter("lista");
        Iterator<DtLR> it2 = listas.iterator();
        DtLR dtlista = null;
        while (it2.hasNext()) {
            if (it2.next().getNombre().equalsIgnoreCase(lista)) {
                dtlista = it2.next();
            }
        }
        if (!s.ExisteLista(dtlista.getPropietario(), lista)) {
            s.AgregarVideoListaReproduccion(dtvid.getPropietario(), nomVideo, dtlista.getPropietario(), lista);
            RequestDispatcher rd = request.getRequestDispatcher("Lista.jsp?value=<%=lista%>");
            rd.forward(request, response);
        } else {
            request.getRequestDispatcher("AgregarVideo.jsp").include(request, response);
            out.print("<p style='color: red; font-size: larger;'>Username o mail ya esta en uso!</p>");
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
