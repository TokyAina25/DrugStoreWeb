/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Metier.ListesBO;
import Modele.FactureAffiche;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author OTME
 */
public class PayementFactureController extends HttpServlet {

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
            out.println("<title>Servlet PayementFactureController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PayementFactureController at " + request.getContextPath() + "</h1>");
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
        try {
            PrintWriter out = response.getWriter();
            ListesBO listes = new ListesBO();
            int numeros = Integer.parseInt(request.getParameter("numeros"));
            float montant = Float.parseFloat(request.getParameter("montant"));
            List<FactureAffiche> list = listes.findDetailFacture(numeros);
            request.setAttribute("DetailFacture", list);
            RequestDispatcher disp = request.getRequestDispatcher("index.jsp?contenue=payementsDetail");
            disp.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //create view factureAffiche as (SELECT detailpanier.produit,produits.nomProduit,detailpanier.qtt,prixproduit.prix,(detailpanier.qtt*prixproduit.prix) as somme FROM facture join detailpanier on facture.panier=detailpanier.panier join produits on detailpanier.produit = produits.idProduit join prixproduit on produits.idProduit = prixproduit.idPrd)
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
