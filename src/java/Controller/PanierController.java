/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Metier.AutresFonction;
import Metier.FonctionClient;
import Modele.AfficheProduits;
import Modele.Panier;
import java.io.IOException;
import java.io.PrintWriter;
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
public class PanierController extends HttpServlet {

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
            out.println("<title>Servlet PanierController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PanierController at " + request.getContextPath() + "</h1>");
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
        
        int indice;
        try {
            HttpSession session = request.getSession();
            AutresFonction autres = new AutresFonction();
            FonctionClient fc = new FonctionClient();
            float montant = 0;
            float qtt =0;
            PrintWriter out = response.getWriter();
            List<AfficheProduits> liste = (List<AfficheProduits>) session.getAttribute("panier");
            String[] tabqtt;
            tabqtt = new String[liste.size()];
            indice = liste.size();
            for(int i=0;i<indice;i++){ 
                tabqtt[i] = request.getParameter("quantite"+i);
                montant+=Float.parseFloat(tabqtt[i])*liste.get(i).getPrix();
                qtt+=Float.parseFloat(tabqtt[i]);
            }
            int reponse =0;
            if(session.getAttribute("pan")==null){
                      reponse = autres.createPanier(new Panier((String) session.getAttribute("idclient")));
                      session.setAttribute("pan", 1);
            }if(session.getAttribute("pan")!=null){
                      reponse = 1;
            }
            if(reponse == 1){
                    request.setAttribute("isa", qtt);
                    request.setAttribute("montant", montant);
                    session.setAttribute("qtt", tabqtt);
                    RequestDispatcher disp = request.getRequestDispatcher("index.jsp?contenue=panier");
                    disp.forward(request, response);
            }if(reponse == 0){
                    RequestDispatcher disp = request.getRequestDispatcher("index.jsp?contenue=cart");
                    disp.forward(request, response);           
            }
            
          
        } catch (Exception e) {
            e.printStackTrace();
        } 
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
