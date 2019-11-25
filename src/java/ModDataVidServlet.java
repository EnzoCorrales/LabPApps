/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DT.DtVideo;
import Entidades.Fecha;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
public class ModDataVidServlet extends HttpServlet {

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
            out.println("<title>Servlet ModDataVidServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModDataVidServlet at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");

        Controladores.Sistema s = Controladores.Sistema.getInstance();

        String nombre = request.getParameter("NombreVideo");

        String nomVideo = request.getParameter("NameVideoIns");
        String dura = request.getParameter("DuracionIns");
        String url = request.getParameter("URLIns");
        String descV = request.getParameter("DescVideo");
        String cate = request.getParameter("categorias");
        Fecha f = null;
        String priv = request.getParameter("privado");
        if (!request.getParameter("Fdia").equalsIgnoreCase("") && !request.getParameter("Fmes").equalsIgnoreCase("") && !request.getParameter("Fanio").equalsIgnoreCase("")) {
            int dia = Integer.parseInt(request.getParameter("Fdia"));
            int mes = Integer.parseInt(request.getParameter("Fmes"));
            int anio = Integer.parseInt(request.getParameter("Fanio"));
            f = new Fecha(dia, mes, anio);
        }
        boolean Auxnom = false;
        boolean Auxdur = false;
        boolean Auxurl = false;
        boolean Auxdesc = false;
        boolean Auxf = false;
        boolean Auxcat = false;
        boolean Auxpriv = false;
        boolean privado = true;

        try {
            System.out.println(nombre);

            HttpSession sesion = request.getSession();
            String nick = (String) sesion.getAttribute("username");
            System.out.println(nick);
            DtVideo dtvid = s.getDataVideo(nombre, nick);
            String cat = dtvid.getCategoria();
            if (!nomVideo.equalsIgnoreCase("")) {
                if (!s.ExisteVideo(nick, nomVideo)) {
                    Auxnom = true;
                } else {
                    request.setAttribute("NombreVideo", nombre);
                    sesion.setAttribute("username", nick);
                    request.getRequestDispatcher("ModDataVid.jsp").forward(request, response);
                    out.print("<p style='color: red; font-size: larger;'>Nombre de video repetido!</p>");
                    return;
                }
            }
            if (!dura.equalsIgnoreCase("")) {
                if (!dura.equalsIgnoreCase(dtvid.getDuracion())) {
                    Auxdur = true;
                }
            }
            if (!url.equalsIgnoreCase("")) {
                if (!url.equalsIgnoreCase(dtvid.getURL())) {
                    Auxurl = true;
                }
            }
            if (!priv.equalsIgnoreCase("")) {
                Auxpriv = true;
            }
            
            if (!descV.equalsIgnoreCase("")) {
                if (!descV.equalsIgnoreCase(dtvid.getDescripcion())) {
                    Auxdesc = true;
                }
            }
            if (f != null) {
                if (f != dtvid.getFecha()) {
                    Auxf = true;
                }
            }
            if (!cate.equalsIgnoreCase("")) {
                if (!cate.equalsIgnoreCase(cat)) {
                    Auxcat = true;
                }
            }
            
            if(Auxpriv == true){
                if(priv.equalsIgnoreCase("privado")){
                    privado = true;
                }
                else
                {
                    privado = false;
                }
                s.ModificarPrivVideo(nick, nombre, privado);
            }

            if (Auxdur == true) {
                s.ModificarDurVideo(nick, nombre, dura);
            }
            if (Auxdesc == true) {
                s.ModificarDescVideo(nick, nombre, descV);
            }
            if (Auxurl == true) {
                s.ModificarURLVideo(nick, nombre, url);
            }
            if (Auxf == true) {
                s.ModificarFechaVideo(nick, nombre, f);
            }
            if (Auxcat == true) {
                s.ModificarCatVideo(nick, nombre, cate);
            }
            if (Auxnom == true) {
                s.ModificarNomVideo(nick, nombre, nomVideo);
            }
            RequestDispatcher rd = request.getRequestDispatcher("MiPerfil.jsp");
            rd.forward(request, response);
            return;
        } catch (Exception ex) {
            request.getRequestDispatcher("MiPerfil.jsp").include(request, response);
            throw new ServletException(ex);
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
