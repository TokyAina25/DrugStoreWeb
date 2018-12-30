<%@page import="Modele.FactureBO"%>
<%@page import="Modele.BaseModele"%>
<%@page import="java.util.List"%>
<%
    List<BaseModele> listes =(List<BaseModele>) request.getAttribute("facture");
    int taille = listes.size();
%>

<div class="main-content">
            <div class="container cart-block-style">          
                <div class="breadcrumbs">
                    <a href="index.jsp"><i class="fa fa-home"></i></a>
                    <a href="#">Listes facture</a>
                </div>
                <div class="contentText">
                </div>
                <form action="PanierFactureController" method="get">
                    <div class="table-responsive margin-top"> 
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <td class="text-center">Numeros</td>
                                    <td class="text-left">Etat</td>
                                    <td class="text-left">Montant</td>
                                    <td class="text-left">Panier</td>
                                    <td class="text-right">Remise</td>
                                    <td class="text-right">Détailler</td>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    FactureBO facture = new FactureBO();
                                    for(int i =0;i<taille;i++){
                                        facture = (FactureBO) listes.get(i);
                                %>
                                <tr>
                                    <td class="text-left"><br><% out.println(facture.getId()); %></td>                                  
                                    <td class="text-left"><br><% out.println(facture.getEtat()); %></td>
                                    <td class="text-left"><br><% out.println(facture.getMontant()); %></td>
                                    <td class="text-right"><br><% out.println(facture.getPanier()); %>$</td>
                                    <td class="text-right"><br><% out.println(facture.getRemise()); %>$</td>
                                    <td class="text-right"><br><a href="PayementFactureController?numeros=<% out.println(facture.getId()); %>&&montant=<% out.println(facture.getMontant()); %>" >Détailler facture</a></td>
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
                            <td class="text-right"><strong>Nombres de produits</strong></td>
                            </tr>
                            <tr>
                                <td class="text-right"><strong>Montant total:</strong></td>
                            </tr>
                            </tbody></table>
                    </div>
                </div>
                </form>
            </div>
        </div>