/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controladores.Sistema;
import Entidades.Fecha;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tecnologo
 */
public class AltaVideoServlet extends HttpServlet {

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
            out.println("<title>Servlet AltaVideoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaVideoServlet at " + request.getContextPath() + "</h1>");
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

        Sistema s = Sistema.getInstance();
        String nomVideo = request.getParameter("NameVideoIns");
        String dura = request.getParameter("DuracionIns");
        String url = request.getParameter("URLIns");
        String descV = request.getParameter("DescVideo");
        int y = 2019;
        int m = 10;
        int d = 14;
        Fecha f = new Fecha(d, m, y);
        HttpSession sesion = request.getSession();
        String nick = (String) sesion.getAttribute("username");
        String cate = request.getParameter("categorias");
        if (nomVideo != null) {
            if (s.ExisteVideo(nick, nomVideo) == true) {
                request.getRequestDispatcher("AltaVideo.jsp").include(request, response);
                out.print("<p style='color: red; font-size: larger;'>Nombre de video repetido!</p>");
            } else {
                s.AltaVideo(nomVideo, dura, url, descV, f, nick, cate);
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
            }
        } else {
            out.print("<p style='color: red; font-size: larger;'>Username = null </p>");
        }
    }
}

/*@Override
        public String getServletInfo() {
        return "Short description";
    }*/


