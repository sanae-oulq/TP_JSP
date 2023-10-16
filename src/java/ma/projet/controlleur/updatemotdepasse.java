
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
import ma.projet.util.Util;


@WebServlet(name = "updatemotdepasse", urlPatterns = {"/updatemotdepasse"})
public class updatemotdepasse extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String password=request.getParameter("password");
      String passwordcnf=request.getParameter("passwordcnf");
      ServiceClient cl = new ServiceClient();
      if(password.equals(passwordcnf)){
        HttpSession session = request.getSession();
        Client c = (Client) session.getAttribute("client");
        c.setPassword(Util.md5(password));
        cl.update(c);
         response.sendRedirect("Authentification.jsp?email="+c.getEmail());
      }
      else{
      response.sendRedirect("updatemotdepasse.jsp?email=mot de passe incorrect");
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

