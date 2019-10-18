/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controladores.Sistema;
import DT.DtCanal;
import DT.DtUsuario;
import Entidades.Fecha;
import Fabrica.FabricaSistema;
import Interfaz.ISistema;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kangaru
 */
public class ModDataServlet extends HttpServlet {

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

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AltaUsrServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaUsrServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        String nick = (String) sesion.getAttribute("username");
        PrintWriter out = response.getWriter();
        FabricaSistema fa = new FabricaSistema();
        ISistema s = fa.getSistema();
        String nom = request.getParameter("NameIns");
        String ape = request.getParameter("ApeIns");
        String pass = request.getParameter("PassIns");
        String Cpass = request.getParameter("CPassIns");
        String nomC = request.getParameter("NombreCanal");
        String descC = request.getParameter("DescCanal");
        String img = request.getParameter("IngImg");
        Fecha f = null;
        if (!request.getParameter("Fdia").equalsIgnoreCase("")) {
            int dia = Integer.parseInt(request.getParameter("Fdia"));
            int mes = Integer.parseInt(request.getParameter("Fmes"));
            int anio = Integer.parseInt(request.getParameter("Fanio"));
            f = new Fecha(dia, mes, anio);
        }
        boolean Auxnom = false;
        boolean Auxape = false;
        boolean Auxpass = false;
        boolean Auxnomc = false;
        boolean Auxdesc = false;
        boolean Auximg = false;
        boolean Auxf = false;
        DtUsuario dtusr = s.getDataUsuario(nick);
        DtCanal dtc = dtusr.getDataCanal();
        if (!nom.equalsIgnoreCase("")) {
            if (!nom.equalsIgnoreCase(dtusr.getNombre())) {
                Auxnom = true;
            }
        }
        if (!ape.equalsIgnoreCase("")) {
            if (!ape.equalsIgnoreCase(dtusr.getApellido())) {
                Auxape = true;
            }
        }
        if (!pass.equalsIgnoreCase("")) {
            if (!pass.equalsIgnoreCase(dtusr.getNombre())) {
                Auxpass = true;
            }
        }
        if (!nomC.equalsIgnoreCase("")) {
            if (!nomC.equalsIgnoreCase(dtc.getNombre())) {
                Auxnomc = true;
            }
        }
        if (!descC.equalsIgnoreCase("")) {
            if (!descC.equalsIgnoreCase(dtc.getDescripcion())) {
                Auxdesc = true;
            }
        }
        if (!img.equalsIgnoreCase("")) {
            if (!img.equalsIgnoreCase(dtusr.getImagen())) {
                Auximg = true;
            }
        }
        if (f != null) {
            if (f != dtusr.getFecha()) {
                Auxf = true;
            }
        }

        if (Auxnom == true) {
            s.ModificarNombreU(nick, nom);
        }
        if (Auxape == true) {
            s.ModificarApellidoU(nick, ape);
        }
        if (Auxpass == true) {
            if (!pass.equalsIgnoreCase(Cpass)) {
                request.getRequestDispatcher("ModDataUsr.jsp").include(request, response);
                out.print("<p style='color: red; font-size: larger;'>Contraseñas no coinciden</p>");

            } else {
                s.ModificarNombreU(nick, pass);
            }
        }
        if (Auxnomc == true) {
            s.ModificarNomC(nick, nomC);
        }
        if (Auxdesc == true) {
            s.ModificarDescC(nick, descC);
        }
        if (Auximg == true) {
            s.ModificarImagenU(nick, img);
        }
        if (Auxf == true) {
            s.ModificarFechaU(nick, f);
        }
        RequestDispatcher rd = request.getRequestDispatcher("MiPerfil.jsp");
        rd.forward(request, response);
    }


@Override
        public String getServletInfo() {
        return "Short description";
    }
}

