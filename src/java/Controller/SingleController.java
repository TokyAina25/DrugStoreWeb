/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Metier.AutresFonction;
import Modele.AfficheProduits;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author OTME
 */
public class SingleController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            PrintWriter out = response.getWriter();
            AutresFonction autres = new AutresFonction();
            String idProduit = request.getParameter("idProduit");
            AfficheProduits pro = autres.getProduitsById(idProduit);
            request.setAttribute("produit", pro);
            RequestDispatcher disp = request.getRequestDispatcher("index.jsp?contenue=single");
            disp.forward(request, response);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
