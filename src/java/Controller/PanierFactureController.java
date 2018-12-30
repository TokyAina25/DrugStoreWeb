/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Metier.AutresFonction;
import Metier.FonctionClient;
import Modele.AfficheProduits;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
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
public class PanierFactureController extends HttpServlet {

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
            out.println("<title>Servlet PanierFactureController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PanierFactureController at " + request.getContextPath() + "</h1>");
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
        
        try{
            int taille = 0;
            FonctionClient fc = new FonctionClient();
            HttpSession session = request.getSession(); 
            AutresFonction autres = new AutresFonction();
            PrintWriter out = response.getWriter();
            List<AfficheProduits> liste = (List<AfficheProduits>) session.getAttribute("panier");
            float montant =Float.parseFloat(request.getParameter("montant"));
            taille = liste.size();
            String[] quantite = (String[]) session.getAttribute("qtt");
            int idPanier = autres.getIdPanier(Integer.parseInt(session.getAttribute("idclient").toString()));
            
            for(int i = 0;i<taille;i++){
                autres.insertPanier(liste.get(i), quantite[i], idPanier);
            }
             int taux = 10;
             float remise = fc.remise(montant,taux);
             
             if(remise<0){
                 taux = 0;
                 remise = 0;
             }
             
             if(fc.siFactureExisteDeja(idPanier)==0){
                autres.insertFacture(idPanier, montant, remise, 1);
             }
             
             request.setAttribute("montant", montant);
             request.setAttribute("taux", taux);
             request.setAttribute("remise", remise);
             
             RequestDispatcher disp = request.getRequestDispatcher("index.jsp?contenue=facture");
             disp.forward(request, response);
        }catch (Exception e) {
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
