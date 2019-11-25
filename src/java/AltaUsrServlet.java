
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entidades.Fecha;
import Fabrica.FabricaSistema;
import Interfaz.ISistema;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author kangaru
 */
public class AltaUsrServlet extends HttpServlet {

    private static final String DATA_DIRECTORY = "Imagenes";
    //private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    //private static final int MAX_REQUEST_SIZE = 1024 * 1024;

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
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {

            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Sets the size threshold beyond which files are written directly to
            // disk.
            //factory.setSizeThreshold(MAX_MEMORY_SIZE);
            // Sets the directory used to temporarily store files that are larger
            // than the configured size threshold. We use temporary directory for
            // java
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            // constructs the folder where uploaded file will be stored
            String uploadFolder = getServletContext().getRealPath("")
                    + File.separator + DATA_DIRECTORY;

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Set overall request size constraint
            //upload.setSizeMax(MAX_REQUEST_SIZE);
            FabricaSistema fa = new FabricaSistema();
            ISistema s = fa.getSistema();
            String username = null;
            String nom = null;
            String mail = null;
            String ape = null;
            String pass = null;
            String Cpass = null;
            String nomC = null;
            String descC = null;
            String img = "blank-profile-picture-973460_960_720.png";
            String priv = null;
            int dia = 0;
            int mes = 0;
            int anio = 0;

            try {
                // Parse the request
                List items = upload.parseRequest(request);
                Iterator iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();

                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadFolder + File.separator + fileName;
                        File uploadedFile = new File(filePath);
                        System.out.println("ACAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"+filePath);
                        // saves the file to upload directory
                        if (!fileName.equalsIgnoreCase("")) {
                            img = fileName;
                            item.write(uploadedFile);
                        }
                    } else {
                        if (item.getFieldName().equalsIgnoreCase("NickIns")) {
                            username = item.getString();
                        }
                        if (item.getFieldName().equalsIgnoreCase("NameIns")) {
                            nom = item.getString();
                        }
                        if (item.getFieldName().equalsIgnoreCase("CorreoIns")) {
                            if (item.getString() != null) {
                                mail = item.getString();
                            }
                        }
                        if (item.getFieldName().equalsIgnoreCase("ApeIns")) {
                            ape = item.getString();
                        }
                        if (item.getFieldName().equalsIgnoreCase("PassIns")) {
                            pass = item.getString();
                        }
                        if (item.getFieldName().equalsIgnoreCase("CPassIns")) {
                            Cpass = item.getString();
                        }
                        if (item.getFieldName().equalsIgnoreCase("NombreCanal")) {
                            if (!item.getString().equalsIgnoreCase("")) {
                                nomC = item.getString();
                            }
                        }
                        if (item.getFieldName().equalsIgnoreCase("DescCanal")) {
                            descC = item.getString();
                        }
                        if (item.getFieldName().equalsIgnoreCase("Fdia")) {
                            dia = Integer.parseInt(item.getString());
                        }
                        if (item.getFieldName().equalsIgnoreCase("Fmes")) {
                            mes = Integer.parseInt(item.getString());
                        }
                        if (item.getFieldName().equalsIgnoreCase("Fanio")) {
                            anio = Integer.parseInt(item.getString());
                        }
                        if (item.getFieldName().equalsIgnoreCase("privado")) {
                            priv = item.getString();
                        }

                    }
                }
                Fecha f = new Fecha(dia, mes, anio);
                boolean privado = true;
                if (priv != null) {
                    if (priv.equalsIgnoreCase("privado")) {
                        privado = true;
                    } else {
                        privado = false;
                    }
                }
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
                            if(nomC==null){
                                nomC=username;
                            }
                            s.AltaUsuarioWeb(username, nom, ape, mail, pass, f, nomC, descC, img, privado);
                            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                            rd.forward(request, response);
                        }

                    } else {
                        out.print("<p style='color: red; font-size: larger;'>Username = null </p>");
                    }
                }

            } catch (FileUploadException ex) {
                throw new ServletException(ex);
            } catch (Exception ex) {
                throw new ServletException(ex);
            }

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";

    }
}
