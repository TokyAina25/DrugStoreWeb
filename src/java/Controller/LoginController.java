/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Metier.AutresFonction;
import Metier.FonctionClient;
import Modele.AfficheProduits;
import Modele.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author OTME
 */
public class LoginController extends HttpServlet {

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
            out.println("<title>Servlet LoginController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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
       try{
           HttpSession session = request.getSession(); 
           FonctionClient fc = new FonctionClient();
           AutresFonction autres = new AutresFonction();            
           PrintWriter out = response.getWriter();          
           String user = request.getParameter("user");
           String pass = request.getParameter("pass");
           Client client = fc.Login(user, pass);
           
           if(client!=null){
              session.setAttribute("nomclient", client.getNomClient());
              session.setAttribute("idclient", client.getId());
              
              if(request.getParameter("idProduit")!=null){
                    String idProduit = request.getParameter("idProduit");
                    AfficheProduits pro = autres.getProduitsById(idProduit);
                    List<AfficheProduits> listes = new ArrayList<>();
                    listes.add(pro);
                    if(session.getAttribute("panier")==null){
                        session.setAttribute("panier",listes);
                    }else if(session.getAttribute("panier")!=null){
                        List<AfficheProduits> temp =(List<AfficheProduits>) session.getAttribute("panier");
                        if(fc.siProduitEstDeja(temp, pro)==0){
                            temp.add(pro);
                        }
                        session.setAttribute("panier", temp);
                    }                        
                    RequestDispatcher disp = request.getRequestDispatcher("index.jsp?contenue=cart");
                    disp.forward(request, response);
              }if (request.getParameter("idProduit") == null){
                      RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
                      disp.forward(request, response);
              }
              
           }else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Erreur login!');");
                out.println("location='index.jsp?contenue=login';");
                out.println("</script>");
                //response.sendRedirect("index.jsp");
           }
       }catch(Exception ex){
          ex.printStackTrace();
       }
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
