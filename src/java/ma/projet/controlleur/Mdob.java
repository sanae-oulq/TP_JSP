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
import ma.projet.service.sendMail;
import ma.projet.util.Util;


@WebServlet(name = "Mdob", urlPatterns = {"/Mdob"})
public class Mdob extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        ServiceClient cl = new ServiceClient();
        Client c = cl.getByEmail(email);
        if (c != null) {
          
            double i = Math.random() * 100000;
            String code = (i + "").substring(0, 4);
            c.setCode(code);
            cl.update(c);
            HttpSession session = request.getSession();
            session.setAttribute("client", c);
            sendMail sed = new sendMail();
            sed.send(code,email);
            response.sendRedirect("verfier.jsp");
        } else {
            response.sendRedirect("Mpob.jsp?msg=Email n’existe pas ");
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
