<%@page import="Modele.BaseModele"%>
<%@page import="java.util.List"%>
<%@page import="Modele.AfficheProduits"%>
<%
 List<BaseModele> list = (List<BaseModele>) request.getAttribute("produits");
%>

                                    <h3>Résultats trouvés(<% out.println(list.size()); %>)</h3>
                                    <div class="row margin-top product-layout_width">
                                     <%
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