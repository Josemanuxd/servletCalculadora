package servletHTML;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adria
 */
@WebServlet(name = "servletCalculadora", urlPatterns = {"/servletCalculadora"})
public class servletCalculadora extends HttpServlet {
    String num1;
    String num2;
    String ope;
    float num11;
    float num22;
    float resu;
    

    public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
        num1 = peticion.getParameter("num1");
        num11 = Integer.parseInt(num1); 
        num2 = peticion.getParameter("num2");
        num22 = Integer.parseInt(num2);
        ope = peticion.getParameter("opcion");
        
        switch(ope){
            case "suma":
                resu = (num11 + num22) ;
                break;
            case "resta":
                resu = num11-num22;
                break;
            case "multiplicacion":
                resu = num11*num22;
                break;
            case "division":
                resu = num11/num22;
                break;
                    
        }
        
            PrintWriter out = new PrintWriter(respuesta.getOutputStream());
        out.println("<html>");
        out.println("<head><title>Calculado</title></head>");
        out.println("<body>");
        out.println("<p><h1><center>Resultado:<B>" + resu + "</B> </center></h1></p>");
        out.println("</body></html>");
        out.close();
            
    }
}
