/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controladores.Sistema;
import DT.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kangaru
 */
public class Busqueda extends HttpServlet {

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
            out.println("<title>Servlet Busqueda</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Busqueda at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        
        String buscar = request.getParameter("Buscar");
        String ord = request.getParameter("Ordenamiento");
        String filtro = request.getParameter("Filtro");
        
        request.setAttribute("ord", ord);
        request.setAttribute("filtro", filtro);
        Sistema s = Sistema.getInstance();
        
        Collection<String> resultado = new ArrayList<>();
        Collection <String> videos = new ArrayList<>();
        Collection<String> listas = new ArrayList<>();
        Collection<String> canales = new ArrayList<>();
        Collection<DtVideo> videos1 = new ArrayList<>();
        Collection<DtLR> listas1 = new ArrayList<>();
        Collection<DtCanal> canales1 = new ArrayList<>();
 
        if(buscar != null){
            Collection<DtVideo> video = s.ListaTVideos();
            Iterator<DtVideo> it = video.iterator();
            while(it.hasNext()){
                DtVideo v = it.next();
                if(v.getNomVideo().contains(buscar)){
                    videos.add(v.getNomVideo());
                    videos1.add(v);
                    resultado.add(v.getNomVideo());
                }
            }
            request.setAttribute("Videos", videos1);
            request.setAttribute("ListaVideos", videos);

            Collection<DtLR> lr = s.ListaTLR();
            Iterator<DtLR> it2 = lr.iterator();

            while(it2.hasNext()){
                DtLR data = it2.next();
                if(data.getNombre().contains(buscar)){
                    listas.add(data.getNombre());
                    listas1.add(data);
                    resultado.add(data.getNombre());
                }
            }
            request.setAttribute("Listas", listas1);
            request.setAttribute("ListaLR", listas);

            Collection<DtCanal> canal = s.ListaCanales();
            Iterator<DtCanal> it3 = canal.iterator();

            while(it3.hasNext()){
                DtCanal can = it3.next();
                if(can.getNombre().contains(buscar)){
                    canales.add(can.getNombre());
                    canales1.add(can);
                    resultado.add(can.getNombre());
                }
            }
            request.setAttribute("Canales", canales1);
            request.setAttribute("ListaCanales", canales);
            request.setAttribute("Resultados", resultado);
            request.getRequestDispatcher("Busqueda.jsp").include(request, response);
        }
        else{
            Collection<DtVideo> video = s.ListaTVideos();
            Iterator<DtVideo> it = video.iterator();
            while(it.hasNext()){
                DtVideo v = it.next();
                videos.add(v.getNomVideo());
                videos1.add(v);
                resultado.add(v.getNomVideo());
            }
            request.setAttribute("Videos", videos1);
            request.setAttribute("ListaVideos", videos);

            Collection<DtLR> lr = s.ListaTLR();
            Iterator<DtLR> it2 = lr.iterator();
            while(it2.hasNext()){
                DtLR data = it2.next();
                listas.add(data.getNombre());
                listas1.add(data);
                resultado.add(data.getNombre());
            }
            request.setAttribute("Listas", listas1);
            request.setAttribute("ListaLR", listas);

            Collection<DtCanal> canal = s.ListaCanales();
            Iterator<DtCanal> it3 = canal.iterator();
            while(it3.hasNext()){
                DtCanal can = it3.next();
                canales.add(can.getNombre());
                canales1.add(can);
                resultado.add(can.getNombre());
            }
            request.setAttribute("Canales", canales1);
            request.setAttribute("ListaCanales", canales);
            request.setAttribute("Resultados", resultado);
            request.getRequestDispatcher("Busqueda.jsp").include(request, response);
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