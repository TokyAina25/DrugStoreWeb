<%@page import="Modele.AfficheProduits"%>
<%
   AfficheProduits produit =(AfficheProduits) request.getAttribute("produit");
%>
        <div class="col-md-3 col-sm-4 col-xs-12 left_sidebar1">
                                <script>
                                    function toggleChevron(e) {
                                        $(e.target)
                                                .prev('.panel-heading')
                                                .find("i.indicator")
                                                .toggleClass('glyphicon-chevron-down glyphicon-chevron-up');
                                    }
                                    $('#accordion').on('hidden.bs.collapse', toggleChevron);
                                    $('#accordion').on('shown.bs.collapse', toggleChevron);
                                </script>
        </div> 
                    <div class="col-md-9 col-sm-8 col-xs-12" id="content">            
                        <div class="breadcrumbs">
                            <a href="home.html"><i class="fa fa-home"></i></a>
                            <a href="">Details du produit</a>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <ul class="thumbnails">
                                    <li><a  href="#" class="thumbnail fix-box"><img class="changeimg" src="assets/images/produits/<% out.println(produit.getNomcategorie()+"/"+produit.getNomsouscategorie()+"/"+produit.getIdproduit()); %>.jpg"></a></li>
                                    <li class="image-additional"><a title="Dianabol"  class="thumbnail"> 
                                            <img class="galleryimg" src="assets/images/produits/<% out.println(produit.getNomcategorie()+"/"+produit.getNomsouscategorie()+"/"+produit.getIdproduit()); %>.jpg"></a></li>                                    
                                </ul>
                            </div>
                            <div class="col-sm-6">
                                <div class="btn-group">
                                    <button  title="" class="btn btn-default mr_5"  type="button"><i class="fa fa-heart"></i></button>
                                    <button  title="" class="btn btn-default"  type="button"><i class="fa fa-exchange"></i></button>
                                </div>
                                <h1 style="color: #39baf0"><% out.println(produit.getNomproduit()); %></h1>
                                <ul class="list-unstyled product-section">
                                    <li><span>Types: </span><% out.println(produit.getNomcategorie()); %></li>
                                    <li><span>Categorie: </span><% out.println(produit.getNomsouscategorie()); %></li>
                                    <li><span>Availability:</span> <span class="check-stock">Pre-Order</span></li>
                                </ul>
                                <ul class="list-unstyled">
                                    <li>
                                        <h2><% out.println(produit.getPrixPromotion()); %>$</h2>
                                    </li>
                                </ul>
                                <div id="product">
                                    <div class="form-group">
                                        <label for="input-quantity" class="control-label">Qty</label>
                                        <input type="text" class="form-control" id="input-quantity" size="2" value="1" name="quantity">
                                        <input type="hidden" value="49" name="product_id">
                                        <br>
                                        <a class="btn btn-primary btn-lg btn-block reg_button" href="PageCartController?idProduit=<% out.println(produit.getIdproduit()); %>"><i class="fa fa-shopping-cart"></i>Acheter</a>
                                    </div>
                                </div>
                                <div class="rating">
                                    <p>
                                        <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i></span>
                                        <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i></span>
                                        <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i></span>
                                        <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i></span>
                                        <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i></span>
                                        <a  href="">0 reviews</a> / <a  href="">Write a review</a></p>
                                    <hr>

                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <ul class="nav nav-tabs">
                                    <li class=""><a data-toggle="tab" href="#tab-description" aria-expanded="true">Description</a></li>
                                    <li class="active"><a data-toggle="tab" href="#tab-review" aria-expanded="false">Reviews (0)</a></li>
                                </ul>
                                <div class="tab-content">
                                    <div id="tab-description" class="tab-pane">
                                        <div class="row ">
                                            <p><% out.println(produit.getDescriptionproduit()); %></p>
                                        </div>
                                    </div>
                                    <div id="tab-review" class="tab-pane active">
                                        <form id="form-review" class="form-horizontal">

                                            <h2>Write a review</h2>
                                            <div class="form-group required">
                                                <div class="col-sm-12">
                                                    <label for="input-name" class="control-label">Your Name</label>
                                                    <input type="text" class="form-control" id="input-name" value="" name="name">
                                                </div>
                                            </div>
                                            <div class="form-group required">
                                                <div class="col-sm-12">
                                                    <label for="input-review" class="control-label">Your Review</label>
                                                    <textarea class="form-control" id="input-review" rows="5" name="text"></textarea>
                                                    <div class="help-block"><span class="text-danger">Note:</span> HTML is not translated!</div>
                                                </div>
                                            </div>
                                            <div class="form-group required">
                                                <div class="col-sm-12">
                                                    <label class="control-label">Rating</label>
                                                    &nbsp;&nbsp;&nbsp; Bad&nbsp;
                                                    <input type="radio" value="1" name="rating">
                                                    &nbsp;
                                                    <input type="radio" value="2" name="rating">
                                                    &nbsp;
                                                    <input type="radio" value="3" name="rating">
                                                    &nbsp;
                                                    <input type="radio" value="4" name="rating">
                                                    &nbsp;
                                                    <input type="radio" value="5" name="rating">
                                                    &nbsp;Good</div>
                                            </div>
                                            <div class="buttons clearfix">
                                                <div class="pull-right">
                                                    <button class="btn btn-primary reg_button"  id="button-review" type="button">
                                                        <i class="fa fa-caret-right"></i>&nbsp;
                                                        Continue                                       
                                                    </button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
