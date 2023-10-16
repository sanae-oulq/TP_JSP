/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.controlleur;

/**
 *
 * @author acer
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ma.projet.entity.Client;
import ma.projet.service.ServiceClient;


@WebServlet(name = "Verfier", urlPatterns = {"/Verfier"})
public class Verfier extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int code = Integer.parseInt(request.getParameter("code"));
        ServiceClient cl = new ServiceClient();
        HttpSession session = request.getSession();
        Client c = (Client) session.getAttribute("client");
        if (c != null) {
            if (Integer.parseInt(c.getCode())==code) {
                response.sendRedirect("updatemotdepasse.jsp");
            } else {
                response.sendRedirect("virfier.jsp?msg= le code est incorrect!! ");
            }
        } else {
            response.sendRedirect("virfier.jsp?msg= sesion vide!! ");
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
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

