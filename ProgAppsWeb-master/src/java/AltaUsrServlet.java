
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controladores.Sistema;
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
public class AltaUsrServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        FabricaSistema fa = new FabricaSistema();
        ISistema s = fa.getSistema();
        String username = request.getParameter("NickIns");
        String nom = request.getParameter("NameIns");
        String mail = request.getParameter("CorreoIns");
        String ape = request.getParameter("ApeIns");
        String pass = request.getParameter("PassIns");
        String Cpass = request.getParameter("CPassIns");
        String nomC = request.getParameter("NombreCanal");
        String descC = request.getParameter("DescCanal");
        String img = request.getParameter("IngImg");
        int dia = Integer.parseInt(request.getParameter("Fdia"));
        int mes = Integer.parseInt(request.getParameter("Fmes"));
        int anio = Integer.parseInt(request.getParameter("Fanio"));
        Fecha f = new Fecha(dia, mes, anio);
        String priv = request.getParameter("privado");
        boolean privado;
        if(priv == null)
            privado = false;
        else
            privado = true;
        if (username == null || mail == null) {
            request.getRequestDispatcher("AltaUsr.jsp").include(request, response);
            out.print("<p style='color: red; font-size: larger;'>username null || mail null</p>");
        } else {

            if (username != null && mail != null) {
                if (s.ExisteUsr(username) == true || s.ExisteMail(mail) == true) {
                    request.getRequestDispatcher("AltaUsr.jsp").include(request, response);
                    out.print("<p style='color: red; font-size: larger;'>Username o mail ya esta en uso!</p>");
                } else if (!pass.equalsIgnoreCase(Cpass)) {
                    request.getRequestDispatcher("AltaUsr.jsp").include(request, response);
                    out.print("<p style='color: red; font-size: larger;'>Contraseñas no coinciden</p>");
                } else {
                    s.AltaUsuarioWeb(username, nom, ape, mail, pass, f, nomC, descC, img, privado);
                    RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                    rd.forward(request, response);
                }

            } else {
                out.print("<p style='color: red; font-size: larger;'>Username = null </p>");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";

    }
}
