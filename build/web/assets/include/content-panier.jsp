<%@page import="java.util.List"%>
<%@page import="Modele.AfficheProduits"%>
<%
    int taille = 0;
    int indice = 0;
    List<AfficheProduits> produit = null;
    if(session.getAttribute("panier")!=null){
        produit =(List<AfficheProduits>) session.getAttribute("panier");
        taille = produit.size();
    }
     String[] quantite = (String[]) session.getAttribute("qtt");
%>
        <div class="main-content">
            <div class="container cart-block-style">          
                <div class="breadcrumbs">
                    <a href="index.jsp"><i class="fa fa-home"></i></a>
                    <a href="#">Panier</a>
                </div>
                <div class="pull-left"><a class="btn btn-default" href="PdfController?montant=<% out.println(request.getAttribute("montant")); %>"><i class="fa fa-caret-right"></i>PDF</a></div>
                <div class="contentText">
                </div>
                <form action="PanierFactureController" method="get">
                    <div class="table-responsive margin-top"> 
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <td class="text-center"></td>
                                    <td class="text-left">Libéllé</td>
                                    <td class="text-left">Categorie</td>
                                    <td class="text-left">Quantité</td>
                                    <td class="text-right">Prix Unitaire</td>
                                    <td class="text-right">Somme</td>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    float montant;
                                    for(int i =0;i<taille;i++){
                                        montant = produit.get(i).getPrix()*Float.parseFloat(quantite[i]);
                                        indice = i;
                                %>
                                <tr>
                                    <td class="text-center">                                   
                                        <a href="single-product.html">
                                            <img title="ana" src="assets/images/produits/<% out.println(produit.get(i).getNomcategorie()+"/"+produit.get(i).getNomsouscategorie()+"/"+produit.get(i).getIdproduit()); %>.jpg" style="width: 100px; height: 80px;">
                                        </a>
                                    </td>
                                    <td class="text-left"><br><% out.println(produit.get(i).getNomproduit()); %></td>                                  
                                    <td class="text-left"><br><% out.println(produit.get(i).getNomcategorie()); %></td>
                                    <td class="text-left"><br><div style="max-width: 200px;" class="input-group btn-block">
                                            <input name="<%="quantite"+i%>" value="<%=quantite[i]%>" type="number" class="form-control input-sm" size="1" disabled="">
                                    </td>
                                    <td class="text-right"><br><% out.println(produit.get(i).getPrix()); %>$</td>
                                    <td class="text-right"><br><% out.println(montant); %>$</td>
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
                            <td class="text-right" style="color:#31708f"><% out.println(request.getAttribute("isa")); %></td>
                            </tr>
                            <tr>
                                <td class="text-right"><strong>Montant total:</strong></td>
                                <td class="text-right" style="color:#c9302c"><strong><% out.println(request.getAttribute("montant")); %>$</strong></td>
                            </tr>
                            </tbody></table>
                    </div>
                </div>
                     <input type="hidden" name="montant" value="<% out.println(request.getAttribute("montant")); %>">            
                <div class="buttons">
                    <div class="pull-left"><a class="btn btn-default" href="index.jsp"><i class="fa fa-caret-right"></i>&nbsp;Continue Shopping</a></div>
                    <div class="pull-right"><input onclick="return(confirm('Voulez vous effectué les achats?'));" type="submit" value="Confirmer l'achat"></div>
                </div>
                </form>
            </div>
        </div>
                           