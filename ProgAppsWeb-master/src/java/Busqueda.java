/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controladores.Sistema;
import DT.*;
import Fabrica.FabricaSistema;
import Interfaz.ISistema;
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
        FabricaSistema f = new FabricaSistema();
        ISistema s = f.getSistema();

        ArrayList<DtVideo> videos1 = new ArrayList<>();
        Collection<DtLR> listas1 = new ArrayList<>();
        Collection<DtCanal> canales1 = new ArrayList<>();
        ArrayList<DtTipo> resultado = new ArrayList<>();
        

        if (buscar != null) {
            Collection<DtVideo> video = s.ListaTVideos();
            Iterator<DtVideo> it = video.iterator();
            while (it.hasNext()) {
                DtVideo v = it.next();
                DtTipo tipo = v.getTipo();
                if(v.getNomVideo().contains(buscar))
                    videos1.add(v);
                    resultado.add(tipo);
                
            }

            Collection<DtLR> lr = s.ListaTLR();
            Iterator<DtLR> it2 = lr.iterator();
            while (it2.hasNext()) {
                DtLR data = it2.next();
                DtTipo tipo = data.getTipo();
                if (data.getNombre().contains(buscar)) {
                    listas1.add(data);
                    resultado.add(tipo);
                }
            }

            Collection<DtCanal> canal = s.ListaCanales();
            Iterator<DtCanal> it3 = canal.iterator();
            while (it3.hasNext()) {
                DtCanal can = it3.next();
                DtTipo tipo = can.getTipo();
                if (can.getNombre().contains(buscar)) {
                    canales1.add(can);
                    resultado.add(tipo);
                }
            }

            if (ord.equalsIgnoreCase("Opcion")) {
                if (filtro.equalsIgnoreCase("Opcion")) {
                    request.setAttribute("Resultados", resultado);
                    request.getRequestDispatcher("Busqueda.jsp").include(request, response);
                }

                if (filtro.equalsIgnoreCase("Videos")) {
                    resultado.clear();
                    Iterator<DtVideo> itv = videos1.iterator();
                    while (itv.hasNext()) {
                        DtVideo dtv = itv.next();
                        DtTipo dtt = dtv.getTipo();
                        resultado.add(dtt);
                    }
                    request.setAttribute("Resultados", resultado);
                    request.getRequestDispatcher("Busqueda.jsp").include(request, response);
                }

                if (filtro.equalsIgnoreCase("Listas")) {
                    resultado.clear();
                    Iterator<DtLR> itlr = listas1.iterator();
                    while (itlr.hasNext()) {
                        DtLR dtlr = itlr.next();
                        DtTipo dtt = dtlr.getTipo();
                        resultado.add(dtt);
                    }
                    request.setAttribute("Resultados", resultado);
                    request.getRequestDispatcher("Busqueda.jsp").include(request, response);
                }
                if (filtro.equalsIgnoreCase("Canales")) {
                    resultado.clear();
                    Iterator<DtCanal> itc = canales1.iterator();
                    while (itc.hasNext()) {
                        DtCanal dtc = itc.next();
                        DtTipo dtt = dtc.getTipo();
                        resultado.add(dtt);
                    }
                    request.setAttribute("Resultados", resultado);
                    request.getRequestDispatcher("Busqueda.jsp").include(request, response);
                }
            }

            if (ord.equalsIgnoreCase("Alfabeticamente")) {
                if (filtro.equalsIgnoreCase("Opcion")) {
                    Collections.sort(resultado);
                    request.setAttribute("Resultados", resultado);
                    request.getRequestDispatcher("Busqueda.jsp").include(request, response);
                }
                if (filtro.equalsIgnoreCase("Videos")) {
                    resultado.clear();
                    Iterator<DtVideo> itv = videos1.iterator();
                    while (itv.hasNext()) {
                        DtVideo dtv = itv.next();
                        DtTipo dtt = dtv.getTipo();
                        resultado.add(dtt);
                    }
                    Collections.sort(resultado);
                    request.setAttribute("Resultados", resultado);
                    request.getRequestDispatcher("Busqueda.jsp").include(request, response);
                }
                if (filtro.equalsIgnoreCase("Listas")) {
                    resultado.clear();
                    Iterator<DtLR> itlr = listas1.iterator();
                    while (itlr.hasNext()) {
                        DtLR dtlr = itlr.next();
                        DtTipo dtt = dtlr.getTipo();
                        resultado.add(dtt);
                    }
                    Collections.sort(resultado);
                    request.setAttribute("Resultados", resultado);
                    request.getRequestDispatcher("Busqueda.jsp").include(request, response);
                }
                if (filtro.equalsIgnoreCase("Canales")) {
                    resultado.clear();
                    Iterator<DtCanal> itc = canales1.iterator();
                    while (itc.hasNext()) {
                        DtCanal dtc = itc.next();
                        DtTipo dtt = dtc.getTipo();
                        resultado.add(dtt);
                    }
                    Collections.sort(resultado);
                    request.setAttribute("Resultados", resultado);
                    request.getRequestDispatcher("Busqueda.jsp").include(request, response);
                }
            }

            if (ord.equalsIgnoreCase("Anio")) {
                if (filtro.equalsIgnoreCase("Opcion")) {

                }
                if (filtro.equalsIgnoreCase("Videos")) {
                    Collections.sort(videos1,Collections.reverseOrder());
                    resultado.clear();
                    Iterator<DtVideo> itv = videos1.iterator();
                    while (itv.hasNext()) {
                        DtVideo dtv = itv.next();
                        DtTipo dtt = dtv.getTipo();
                        resultado.add(dtt);
                    }
                    request.setAttribute("Resultados", resultado);
                    request.getRequestDispatcher("Busqueda.jsp").include(request, response);
                }
                if (filtro.equalsIgnoreCase("Listas")) {
                    videos1.clear();
                    resultado.clear();
                    Iterator<DtLR> itlr = listas1.iterator();
                    while(itlr.hasNext()){
                        DtLR dtlr = itlr.next();
                        if(s.TieneVideosLR(dtlr.getId()))
                            videos1.add(s.OrdenoVideosLR(dtlr.getId()));
                        
                    }
                    Collections.sort(videos1,Collections.reverseOrder());
                    Iterator<DtVideo> itv = videos1.iterator();
                    while (itv.hasNext()) {
                        DtVideo dtv = itv.next();
                        DtTipo dtt = dtv.getTipo();
                        resultado.add(dtt);
                    }
                    request.setAttribute("Resultados", resultado);
                    request.getRequestDispatcher("Busqueda.jsp").include(request, response);
                }
                if (filtro.equalsIgnoreCase("Canales")) {
                    
                }
            }
        } 
        else {
            //request.getRequestDispatcher("Busqueda.jsp").include(request, response);
            /*Collection<DtVideo> video = s.ListaTVideos();
            Iterator<DtVideo> it = video.iterator();
            while (it.hasNext()) {
                DtVideo v = it.next();
                videos.add(v.getNomVideo());
                videos1.add(v);
                resultado.add(v.getNomVideo());
            }
            request.setAttribute("Videos", videos1);
            request.setAttribute("ListaVideos", videos);

            Collection<DtLR> lr = s.ListaTLR();
            Iterator<DtLR> it2 = lr.iterator();
            while (it2.hasNext()) {
                DtLR data = it2.next();
                listas.add(data.getNombre());
                listas1.add(data);
                resultado.add(data.getNombre());
            }
            request.setAttribute("Listas", listas1);
            request.setAttribute("ListaLR", listas);

            Collection<DtCanal> canal = s.ListaCanales();
            Iterator<DtCanal> it3 = canal.iterator();
            while (it3.hasNext()) {
                DtCanal can = it3.next();
                canales.add(can.getNombre());
                canales1.add(can);
                resultado.add(can.getNombre());
            }
            request.setAttribute("Canales", canales1);
            request.setAttribute("ListaCanales", canales);
            request.setAttribute("Resultados", resultado);
            request.getRequestDispatcher("Busqueda.jsp").include(request, response);*/
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
