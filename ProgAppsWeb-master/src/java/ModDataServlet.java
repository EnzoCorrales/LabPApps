/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import WSClient.DtFecha;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author kangaru
 */
public class ModDataServlet extends HttpServlet {

    private static final String DATA_DIRECTORY = "Imagenes";

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
            HttpSession sesion = request.getSession();
            WSClient.SistemaService service = new WSClient.SistemaService();
            WSClient.Sistema port = service.getSistemaPort();
            
            String nick = (String) sesion.getAttribute("username");
            String nom = null;
            String ape = null;
            String pass = null;
            String Cpass = null;
            String nomC = null;
            String descC = null;
            String img = null;
            String priv = null;
            int id = 0;
            int dia = 0;
            int mes = 0;
            int anio = 0;
            boolean Auxnom = false;
            boolean Auxape = false;
            boolean Auxpass = false;
            boolean Auxnomc = false;
            boolean Auxdesc = false;
            boolean Auximg = false;
            boolean Auxf = false;
            boolean Auxpriv = false;

            try {
                // Parse the request
                List items = upload.parseRequest(request);
                Iterator iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();

                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadFolder + File.separator + fileName;
                        img = fileName;
                        File uploadedFile = new File(filePath);
                        // saves the file to upload directory
                        if (!fileName.equalsIgnoreCase("")) {
                            Auximg = true;
                            item.write(uploadedFile);
                        }
                    } else {
                        if (item.getFieldName().equalsIgnoreCase("NameIns")) {
                            nom = item.getString();
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
                            nomC = item.getString();
                        }
                        if (item.getFieldName().equalsIgnoreCase("DescCanal")) {
                            descC = item.getString();
                        }
                        if (item.getFieldName().equalsIgnoreCase("privado")) {
                            if (!item.getString().equalsIgnoreCase("")) {
                                priv = item.getString();
                            }
                        }
                        if (item.getFieldName().equalsIgnoreCase("Fdia")) {
                            if (!item.getString().equalsIgnoreCase("")) {
                                dia = Integer.parseInt(item.getString());
                            }
                        }
                        if (item.getFieldName().equalsIgnoreCase("Fmes")) {
                            if (!item.getString().equalsIgnoreCase("")) {
                                mes = Integer.parseInt(item.getString());
                            }
                        }
                        if (item.getFieldName().equalsIgnoreCase("Fanio")) {
                            if (!item.getString().equalsIgnoreCase("")) {
                                anio = Integer.parseInt(item.getString());
                            }
                        }

                    }
                }
                DtFecha f = null;
                if (dia != 0 && mes != 0 && anio != 0) {
                    f = new DtFecha();
                    f.setAnio(anio);
                    f.setDia(dia);
                    f.setMes(mes);
                    Auxf = true;
                }
                boolean privado = true;
                if (priv != null) {
                    Auxpriv = true;
                    if (priv.equalsIgnoreCase("privado")) {
                        privado = true;
                    } else {
                        privado = false;
                    }
                }

                if (!nom.equalsIgnoreCase("")) {
                    Auxnom = true;
                }
                if (!ape.equalsIgnoreCase("")) {
                    Auxape = true;
                }
                if (!pass.equalsIgnoreCase("")) {
                    Auxpass = true;
                }
                if (!nomC.equalsIgnoreCase("")) {
                    Auxnomc = true;
                }
                if (!descC.equalsIgnoreCase("")) {
                    Auxdesc = true;
                }
                if (f != null) {
                    Auxf = true;
                }

                if (Auxnom == true) {
                    port.modificarNombreU(nick, nom);
                }
                if (Auxape == true) {
                    port.modificarApellidoU(nick, ape);
                }
                if (Auxpass == true) {
                    if (!pass.equalsIgnoreCase(Cpass)) {
                        request.getRequestDispatcher("ModDataUsr.jsp").include(request, response);
                        out.print("<p style='color: red; font-size: larger;'>Contraseñas no coinciden</p>");

                    } else {
                        port.modificarNombreU(nick, pass);
                    }
                }
                if (Auxnomc == true) {
                    port.modificarNomC(nick, nomC);
                }
                if (Auxdesc == true) {
                    port.modificarDescC(nick, descC);
                }
                if (Auximg == true) {
                    port.modificarImagenU(nick, img);
                }
                if (Auxf == true) {
                    port.modificarFechaU(nick, f);
                }
                if (Auxpriv == true) {
                    port.modificarPrivC(nick, privado);
                }
                RequestDispatcher rd = request.getRequestDispatcher("ModDataUsr.jsp");
                rd.forward(request, response);

            } catch (FileUploadException ex) {
                request.getRequestDispatcher("Login.jsp").include(request, response);
                throw new ServletException(ex);
            } catch (Exception ex) {
                request.getRequestDispatcher("Login.jsp").include(request, response);
                throw new ServletException(ex);
            }

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
