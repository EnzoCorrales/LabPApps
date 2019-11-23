/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import WSClient.SistemaService;
import WSClient.Sistema;
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
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        
        SistemaService service = new SistemaService();
        Sistema port = service.getSistemaPort();
        
        
        
        if(port.inicioSesion(username, pass) == true){
            String nick = port.getNick(username);
            HttpSession sesion = request.getSession();
            if(nick==null)
                sesion.setAttribute("username", username);
            else
                sesion.setAttribute("username", nick);
            
            //request.getRequestDispatcher("Index2.jsp").include(request, response);
            response.sendRedirect(request.getServletContext().getContextPath() + "/Index2.jsp");
        }
        else {
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            out.print("<p style='color: red; font-size: larger;'>Usuario o Contraseña incorrecta!</p>");
            rd.include(request,response);   
        }

        out.close();
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

    private static boolean inicioSesion(java.lang.String arg0, java.lang.String arg1) {
        WSClient.SistemaService service = new WSClient.SistemaService();
        WSClient.Sistema port = service.getSistemaPort();
        return port.inicioSesion(arg0, arg1);
    }

    private static boolean inicioSesion_1(java.lang.String arg0, java.lang.String arg1) {
        WSClient.SistemaService service = new WSClient.SistemaService();
        WSClient.Sistema port = service.getSistemaPort();
        return port.inicioSesion(arg0, arg1);
    }

    private static boolean inicioSesion_2(java.lang.String arg0, java.lang.String arg1) {
        WSClient.SistemaService service = new WSClient.SistemaService();
        WSClient.Sistema port = service.getSistemaPort();
        return port.inicioSesion(arg0, arg1);
    }

    private static boolean inicioSesion_3(java.lang.String arg0, java.lang.String arg1) {
        WSClient.SistemaService service = new WSClient.SistemaService();
        WSClient.Sistema port = service.getSistemaPort();
        return port.inicioSesion(arg0, arg1);
    }

    private static boolean inicioSesion_4(java.lang.String arg0, java.lang.String arg1) {
        WSClient.SistemaService service = new WSClient.SistemaService();
        WSClient.Sistema port = service.getSistemaPort();
        return port.inicioSesion(arg0, arg1);
    }

    private static boolean inicioSesion_5(java.lang.String arg0, java.lang.String arg1) {
        WSClient.SistemaService service = new WSClient.SistemaService();
        WSClient.Sistema port = service.getSistemaPort();
        return port.inicioSesion(arg0, arg1);
    }

}
