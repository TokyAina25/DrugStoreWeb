<%@page import="Modele.AfficheProduits"%>
<%@page import="Metier.AvoirListes"%>
<%@page import="Modele.BaseModele"%>
<%@page import="java.util.List"%>
<%@page import="Modele.Categories"%>
<%
    AvoirListes getListes = new AvoirListes();
    List<BaseModele> list = null;
    
    String[] tableau = new String[6];
    tableau[0] = "One";
    tableau[1] = "Two";
    tableau[2] = "Three";
    tableau[3] = "Four";
    tableau[4] = "Five";
    tableau[5] = "Six";    
%>
<div class="col-md-3 col-sm-4 col-xs-12 left_sidebar1">
                        <div id="left_part">
                            <div class="bs-example">
                                <div class="panel-group" id="accordion"> 
                                <%
                                    try{
                                        list = getListes.findAllCategories();
                                        Categories temp;
                                        for(int i = 0;i<list.size();i++){
                                            temp = (Categories) list.get(i);
                                        %>
                                        <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <div class="infoBoxHeading">
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse<% out.println(tableau[i]); %>"><% out.println(temp.getNomCategorie()); %></a>
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse<% out.println(tableau[i]); %>">
                                                <i id="accordan_plus" class="indicator glyphicon glyphicon-chevron-up  pull-right accordan_plus"></i>
                                                </a>
                                            </div>
                                        </div>
                                        <div id="collapse<% out.println(tableau[i]); %>" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <div class="infoBoxContents">
                                                
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                        <% }
                                    }catch(Exception ex){
                                         ex.printStackTrace();
                                    }
                                %>
                               </div>
                            </div>
                        </div> 
                    </div> 
            <div class="col-md-9 col-sm-8 col-xs-12 right_sidebar1">
                        <div id="right_part">
                            <div class="contentContainer">
                                <div class="contentText">
                                    <div class="breadcrumbs">
                                        <a href="home.html" class="headerNavigation"><i class="fa fa-home"></i></a>			
                                    </div>
                                </div>

                                <!----slidder start-!-->
                                <div class="contentText">
                                    <div class="infoBoxHeading">Today Bestsellers</div>

                                    <div class="row">
                                        <div class="col-md-12 col-sm-12 col-xs-12"  >
                                            <!--                                        <div class="bg_best">-->
                                            <div class="bg_best">
                                                <div class="owl-carousel">

                                                </div>

                                                <script>
                                                    $(document).ready(function () {
                                                        $('.owl-carousel').owlCarousel({
                                                            loop: true,
                                                            margin: 10,
                                                            responsiveClass: true,
                                                            responsive: {
                                                                0: {
                                                                    items: 2,
                                                                    nav: true
                                                                },
                                                                600: {
                                                                    items: 3,
                                                                    nav: false
                                                                },
                                                                1000: {
                                                                    items: 5,
                                                                    nav: true,
                                                                    loop: false,
                                                                    margin: 20
                                                                }

                                                            }
                                                        })
                                                    })
                                                </script>
                                            </div>
                                            <!--                                    </div>-->
                                        </div>
                                    </div>
                                </div>
                                <!----slidder End-!-->
                                <!----content_1--!-->
                                <div class="contentText Static">
                                    <h1>C'est quoi Medistore?</h1>
                                    <p>Il s'agit d'un site e-commerce permettant au client voulant acheté des produits en rapport ave le bien etre et la santÃ© du corps humain</p>
                                </div>
                                <!----content_1 End--!-->


                                <!----content_2 For New Products--!-->
                                <div class="contentText">
                                    <h1>Nos nouveau produits</h1>
                                    <div class="row margin-top product-layout_width">
                                    <%
                                            list = getListes.findAllAffichesProduits(1,0, 10);
                                            AfficheProduits temp;
                                            for(int i = 0; i<list.size();i++){
                                                temp = (AfficheProduits) list.get(i);
                                    %>
                                        <div class="product-layout  col-md-4 col-sm-6 col-xs-12">
                                            <div class="product-thumb-height">
                                                <div class="product-thumb transition">
                                                    <ul>
                                                        <li class="li_product_title">
                                                            <div class="product_title">
                                                                <a href="SingleController?idProduit=<% out.println(temp.getIdproduit()); %>"><% out.println(temp.getNomproduit()); %></a>
                                                            </div></li>
                                                        <li class="li_product_image">
                                                            <div class="image">
                                                                <a href="SingleController?idProduit=<% out.println(temp.getIdproduit()); %>">
                                                                    
                                                                    <img src="assets/images/produits/<% out.println(temp.getNomcategorie()+"/"+temp.getNomsouscategorie()+"/"+temp.getIdproduit()); %>.jpg" class="img-responsive" width="200" height="200" />
                                                                </a>

                                                            </div>
                                                        </li>
                                                        <li class="li_product_price">
                                                            <span class="old_price1"><% out.println(temp.getPrix()); %>$</span>
                                                            <span class="new_price1"><% out.println(temp.getPrixPromotion()); %>$</span>
                                                            <span class="saving1"></span><li>
                                                        <li class="li_product_desc">
                                                            <div class="caption">
                                                                <p>
                                                                    <% out.println(temp.getDescriptionproduit()); %>
                                                                </p>
                                                            </div>
                                                        </li>
                                                        <li class="li_product_buy_button">
                                                            <a class="btn btn-default" id="but" href="PageCartController?idProduit=<% out.println(temp.getIdproduit()); %>" role="button" >
                                                                Acheter
                                                            </a>
                                                            <div class="pull-right">
                                                                <button  type="button" class="btn btn-primary wish_button"><i class="fa fa-heart"></i></button>
                                                                <button  type="button" class="btn btn-primary wish_button"><i class="fa fa-exchange"></i></button>
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                        <% } %>                                     
                                    </div>
                                      
                                <!----content_2 End--!-->

                                <!----content_3--!-->
                                <div class="contentText">
                                    <h1>Produits courantes</h1>
                                    <div class="row margin-top product-layout_width">
                                     <%
                                            list = getListes.findAllAffichesProduits(0,0, 10);
                                            for(int i = 0; i<list.size();i++){
                                                temp = (AfficheProduits) list.get(i);
                                    %>
                                        <div class="product-layout  col-md-4 col-sm-6 col-xs-12">
                                            <div class="product-thumb-height">
                                                <div class="product-thumb transition">
                                                    <ul>
                                                        <li class="li_product_title">
                                                            <div class="product_title">
                                                                <a href="SingleController?idProduit=<% out.println(temp.getIdproduit()); %>"><% out.println(temp.getNomproduit()); %></a>
                                                            </div></li>
                                                        <li class="li_product_image">
                                                            <div class="image">
                                                                <a href="SingleController?idProduit=<% out.println(temp.getIdproduit()); %>">
                                                                    <img src="assets/images/produits/<% out.println(temp.getNomcategorie()+"/"+temp.getNomsouscategorie()+"/"+temp.getIdproduit()); %>.jpg"  class="img-responsive" width="200" height="200" />		
                                                                </a>

                                                            </div>
                                                        </li>
                                                        <li class="li_product_price">
                                                            <span class="old_price1"><% out.println(temp.getPrix()); %>$</span>
                                                            <span class="new_price1"><% out.println(temp.getPrixPromotion()); %>$</span>
                                                            <span class="saving1"></span><li>
                                                        <li class="li_product_desc">
                                                            <div class="caption">
                                                                <p>
                                                                 <% out.println(temp.getDescriptionproduit()); %>
                                                                </p>
                                                            </div>
                                                        </li>
                                                        <li class="li_product_buy_button">
                                                            <a class="btn btn-default" id="but" href="PageCartController?idProduit=<% out.println(temp.getIdproduit()); %>" role="button" >
                                                                Acheter
                                                            </a>
                                                            <div class="pull-right">
                                                                <button  type="button" class="btn btn-primary wish_button"><i class="fa fa-heart"></i></button>
                                                                <button  type="button" class="btn btn-primary wish_button"><i class="fa fa-exchange"></i></button>
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                      <% } %>                          
                                    </div>
                                </div>
                                <!----content_3 End--!-->
                            </div>
                        </div>
                    </div>
              </div>