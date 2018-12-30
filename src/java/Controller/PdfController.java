/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Metier.FonctionClient;
import Modele.AfficheProduits;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author OTME
 */
public class PdfController extends HttpServlet {

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
            out.println("<title>Servlet PdfController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PdfController at " + request.getContextPath() + "</h1>");
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
        
        Document doc = new Document();
        try{
             FonctionClient fc = new FonctionClient();
             HttpSession session = request.getSession(); 
             PrintWriter out = response.getWriter();
             List<AfficheProduits> produit =(List<AfficheProduits>) session.getAttribute("panier");
             String[] quantite = (String[]) session.getAttribute("qtt");
             String montant = request.getParameter("montant");
             String nomClient = session.getAttribute("nomclient").toString().toUpperCase();
             int taux = 20;
             float remise = fc.remise(Float.parseFloat(montant),taux);
             if(remise<0){
                 taux = 0;
                 remise = 0;
             }
             
             PdfWriter.getInstance(doc, new FileOutputStream("F:\\facture.pdf"));
             doc.open();
             doc.add(new Paragraph("Date: 2018-12-20"));
             doc.add(new Paragraph("Facture de "+nomClient));
             
             doc.add(new Paragraph(" "));
             PdfPTable table = new PdfPTable(5);
             table.setWidthPercentage(100);
             PdfPCell cell;
             
             cell = new PdfPCell(new Phrase("Id Produit"));
             cell.setBackgroundColor(BaseColor.GRAY);
             table.addCell(cell);
             
             cell = new PdfPCell(new Phrase("Nom Produit"));
             cell.setBackgroundColor(BaseColor.GRAY);
             table.addCell(cell);
             
             cell = new PdfPCell(new Phrase("Prix"));
             cell.setBackgroundColor(BaseColor.GRAY);
             table.addCell(cell);
             
             cell = new PdfPCell(new Phrase("Quanite"));
             cell.setBackgroundColor(BaseColor.GRAY);
             table.addCell(cell);
             
             cell = new PdfPCell(new Phrase("Somme"));
             cell.setBackgroundColor(BaseColor.GRAY);
             table.addCell(cell);
             
             for(int i = 0;i<produit.size();i++){
                 cell = new PdfPCell(new Phrase(produit.get(i).getIdproduit()));
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(produit.get(i).getNomproduit()));
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(produit.get(i).getPrix()+" $"));
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(quantite[i]));
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase((Float.parseFloat(quantite[i])*produit.get(i).getPrix())+" $"));
                 table.addCell(cell);
             }
             doc.add(table);
             doc.add(new Paragraph("Montant: "+montant+" $"));
             doc.add(new Paragraph("Taux de remise: "+taux+" %"));
             doc.add(new Paragraph("Remise: "+remise+" %"));
             if(remise==0){
                 doc.add(new Paragraph("Montant Exacte: "+montant+" $"));
             }if(remise>0){
                 doc.add(new Paragraph("Montant Exacte: "+(Float.parseFloat(montant)-remise)+" $"));
             }
             doc.close();
             Desktop.getDesktop().open(new File("F:\\facture.pdf"));
        }catch(Exception ex){
            ex.printStackTrace();
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
