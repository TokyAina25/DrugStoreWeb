     <%
       float montant =(float) request.getAttribute("montant");
       int taux =  (int) request.getAttribute("taux");
       float remise =  (float) request.getAttribute("remise");
       float exact = montant-remise;
     %>                       
     <form class="form-horizontal" method="post" action="ControllerDetailFacture">
                     <div class="contentText">  
                            <fieldset id="account">
                                    <h1>Facturation</h1>
                                    <div style="display: none;" class="form-group required">
                                    </div>
                                    <div class="form-group required">
                                        <label for="input-firstname" class="col-sm-2 control-label">Montant du facture</label>
                                        <div class="col-sm-5">
                                            <input type="text" class="form-control" id="input-firstname" value="<%=montant%>$" name="montant" disabled="">
                                        </div>
                                    </div>
                                    <div class="form-group required">
                                        <label for="input-firstname" class="col-sm-2 control-label">Taux de remise</label>
                                        <div class="col-sm-5">
                                            <input type="text" class="form-control" id="input-firstname" value="<%=taux%>%" name="taux" disabled="">
                                        </div>
                                    </div>
                                    <div class="form-group required">
                                        <label for="input-lastname" class="col-sm-2 control-label">Remise</label>
                                        <div class="col-sm-5">
                                            <input type="text" class="form-control" id="input-lastname" value="<%=remise%>$" name="remise" disabled="">
                                        </div>
                                    </div>
                                    <div class="form-group required">
                                        <label for="input-email" class="col-sm-2 control-label">Montant exacte a payé</label>
                                        <div class="col-sm-5">
                                            <input type="text" class="form-control" id="input-email" value="<%=exact%>$" name="montantE" disabled="">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group required">
                                        <label for="input-email" class="col-sm-2 control-label">Paye</label>
                                        <div class="col-sm-5">
                                            <input type="number" class="form-control" id="input-email" placeholder="Somme" name="paye">
                                        </div>
                                    </div>

                                    <input type="submit" class="btn btn-primary reg_button" value="Valider" >
                                    
                             </fieldset>
                      </div>
              </form>