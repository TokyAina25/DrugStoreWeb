<%@page import="Modele.FactureAffiche"%>
<%@page import="Modele.FactureBO"%>
<%@page import="Modele.BaseModele"%>
<%@page import="java.util.List"%>
<%
    List<FactureAffiche> listes =(List<FactureAffiche>) request.getAttribute("DetailFacture");
    String montant = request.getParameter("montant");
    String numeros = request.getParameter("numeros");
    int taille = listes.size();
    out.println("numeros "+numeros);
%>

<div class="main-content">
            <div class="container cart-block-style">          
                <div class="breadcrumbs">
                    <a href="index.jsp"><i class="fa fa-home"></i></a>
                    <a href="#">Listes facture</a>
                </div>
                <div class="contentText">
                </div>
                <a href="PdfController2?montant=<% out.println(montant);%>&&numeros=<% out.println(numeros);%>" >Exporter pdf</a>
                <form action="PanierFactureController" method="get">
                    <div class="table-responsive margin-top"> 
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <td class="text-center">Id produit</td>
                                    <td class="text-left">Nom Produit</td>
                                    <td class="text-left">Prix</td>
                                    <td class="text-left">Quantite</td>
                                    <td class="text-right">Somme</td>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    FactureAffiche facture = new FactureAffiche();
                                    for(int i =0;i<taille;i++){
                                        facture = listes.get(i);
                                %>
                                <tr>
                                    <td class="text-left"><br><% out.println(facture.getProduit()); %></td>                                  
                                    <td class="text-left"><br><% out.println(facture.getNomProduit()); %></td>
                                    <td class="text-left"><br><% out.println(facture.getPrix()); %></td>
                                    <td class="text-right"><br><% out.println(facture.getQtt()); %>$</td>
                                    <td class="text-right"><br><% out.println(facture.getSomme()); %>$</td>
                                </tr>
                                <%
                                }
                                %>
                            </tbody>
                        </table>
                    </div>
                <br>
                
                <div class="row">
                    <div class="col-sm-4 col-sm-offset-8">
                        <table class="table table-bordered">
                            <tbody>
                            <tr>
                            <strong style="font-size: 30px;float: right">Panier</strong>
                            <td class="text-right"><strong>Nombres de produits: <% out.println(listes.size()); %></strong></td>
                            </tr>
                            <tr>
                                <td class="text-right"><strong>Montant total: <% out.println(montant+" $"); %></strong></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                </form>
            </div>
        </div>