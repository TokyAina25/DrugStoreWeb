/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Metier.AutresFonction;
import Metier.FonctionClient;
import Modele.AfficheProduits;
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
public class PageCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          try {
             HttpSession session = request.getSession(); 
             FonctionClient fc = new FonctionClient();
             PrintWriter out = response.getWriter();
             AutresFonction autres = new AutresFonction();            
             
             String idProduit = request.getParameter("idProduit");
             AfficheProduits pro = autres.getProduitsById(idProduit);
             
             if(session.getAttribute("idclient")!=null && session.getAttribute("idclient")!=""){
                 
                    List<AfficheProduits> listes = new ArrayList<>();
                    listes.add(pro);
                    if(session.getAttribute("panier")==null){
                        session.setAttribute("panier",listes);
                    }if(session.getAttribute("panier")!=null){
                        List<AfficheProduits> temp =(List<AfficheProduits>) session.getAttribute("panier");
                         if(fc.siProduitEstDeja(temp, pro)==0){
                            temp.add(pro);
                        }
                        session.setAttribute("panier", temp);
                    }         
                  RequestDispatcher disp = request.getRequestDispatcher("/index.jsp?contenue=cart");
                  disp.forward(request, response);
             }else{
                  RequestDispatcher disp = request.getRequestDispatcher("/index.jsp?contenue=login&&idProduit="+idProduit);
                  disp.forward(request, response);
             }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
