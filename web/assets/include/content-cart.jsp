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
        float prix = 1;
%>
        <div class="main-content">
            <div class="container cart-block-style">          
                <div class="breadcrumbs">
                    <a href="index.jsp"><i class="fa fa-home"></i></a>
                    <a href="#">Panier temporaire</a>
                </div>
                <div class="contentText">
                </div>
                    <form action="PanierController" method="get">
                    <div class="table-responsive margin-top">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <td class="text-center">Images</td>
                                    <td class="text-left">Libéllé</td>
                                    <td class="text-left">Categorie</td>
                                    <td class="text-left">Quantité</td>
                                    <td class="text-right">Prix Unitaire</td>
                                </tr>
                            </thead>
                            <tbody>
                                <% 
                                    for(int i =0;i<taille;i++){
                                        prix = produit.get(i).getPrix();
                                        indice = i;
                                %>
                                <tr>
                                    <td class="text-center">                                   
                                        <a href="single-product.html">
                                            <img title="ana" src="assets/images/produits/<% out.println(produit.get(i).getNomcategorie()+"/"+produit.get(i).getNomsouscategorie()+"/"+produit.get(i).getIdproduit()); %>.jpg" style="width: 100px; height: 80px;">
                                        </a>
                                    </td>
                                    <td class="text-left"><a href="#"><% out.println(produit.get(i).getNomproduit()); %></a>
                                        <br>
                                        <small><% out.println(produit.get(i).getDescriptionproduit()); %></small>                                        
                                    </td>
                                    <td class="text-left"><br><% out.println(produit.get(i).getNomcategorie()); %></td>
                                    <td class="text-left"><br><div style="max-width: 200px;" class="input-group btn-block">
                                            <input id='<%="quantite"+i %>'  name=<%="quantite"+i%> onkeyup="getMontant()" type="number" class="form-control input-sm" size="1">
                                    </td>
                                    <td class="text-right"><br><% out.println(produit.get(i).getPrix()); %>$</td>
                                </tr>
                                <%
                                }
                                %>
                            </tbody>
                        </table>
                    </div>
                <br>
                <div class="buttons">
                    <div class="pull-left"><a class="btn btn-default" href="index.jsp"><i class="fa fa-caret-right"></i>&nbsp;Continue Shopping</a></div>
                    <div class="pull-right"><input onclick="return(confirm('Voulez vous créer le panier?'));" type="submit" value="Ajouter au panier"></div>
                </div>
                </form>
            </div>
        </div>
<script>      
         function getMontant() {
             console.log(<%=indice%>);
            var x = document.getElementById("quantite"+<%=indice%>).value;
            console.log(x);
            document.getElementById("montant"+<%=indice%>).innerHTML = x*<%=prix%>+"$";
        }            
</script>                               