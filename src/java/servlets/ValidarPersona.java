/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import clases.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.PersonaServicio;
import servicios.ValidarPersonaServicio;

/**
 *
 * @author y9d1ru
 */
@WebServlet(name = "ValidarPersona", urlPatterns = {"/validarPersona"})
public class ValidarPersona extends HttpServlet {

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
            String nombre = request.getParameter("nombre");
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
//            System.out.println("prueba 1");
//            PersonaServicio personaServicio = new PersonaServicio();
//            System.out.println("prueba 2");
//            Persona p = personaServicio.getXml(Persona.class, nombre);
//            System.out.println("prueba 3");
//            
//            ValidarPersonaServicio validarPersona = new ValidarPersonaServicio();
//                        System.out.println("prueba 4");
//
//            PersonaServicio personaServicio2 = new PersonaServicio();
//                        System.out.println("prueba 5");
//            
//            String esValido = validarPersona.postXML(personaServicio2);
//            System.out.println("prueba 6");
//            
//            System.out.println(p.getNombre());
////            System.out.println("prueba 5");
//
//            System.out.println(p.getTelefono());
////            System.out.println("prueba 6");
//            System.out.println(p.getNombre());
//
//            String s = validarPersona.postXML(p);           
////            System.out.println("prueba 7");
//            
//            System.out.println("prueba 8");
        PersonaServicio personaServicio = new PersonaServicio();
        
        Persona p = personaServicio.getXml(Persona.class, nombre);

        ValidarPersonaServicio validarPersona = new ValidarPersonaServicio();

        String respuesta = validarPersona.postXML(p);

        if(p!= null){
        if(respuesta.equals("true")){
            System.out.println("Esta persona es válida");
        }else{
            System.out.println("-----------------------");
            System.out.println("La persona no es válida");
            System.out.println("-----------------------");
        }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidarPersona</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println();
            if(respuesta.equals("true")){
                out.println("<br><h1>La persona es válida</h1>");
            }
            else{
                out.println("<br><h1>la persona no es válida</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }
        
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
        processRequest(request, response);
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
