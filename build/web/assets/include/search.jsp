<%@page import="Modele.Categories"%>
<%@page import="Modele.BaseModele"%>
<%@page import="java.util.List"%>
<%@page import="Metier.AvoirListes"%>
<%
    AvoirListes getList = new AvoirListes();
    List<BaseModele> listes = null;
%>
<div class="container" >
    <div class="row" id="search_manu" style="margin-top: 10px">
      <form action="SearchController" method="get">
         <div class="col-md-4 col-xs-10">
                        <div class="form-group">
                            <div class="input-group">
                                <input type="text" name="key" placeholder="Entrer le mot clé de recherche" class="form-control input-lg" id="inputGroup"/>
                                <input type="submit" value="Rechercher" class="btn btn-default">
                            </div>
                        </div>
                </div>
                <div class="col-md-4 col-xs-10">
                        <div class="form-group">
                            <div class="">
                                <select style="font-size: 14px; background: #EAEAEA; border: none;" name="categorie" id="categorie" size="1" class="input-lg form-control arrow-hide date_class">
                                    <option value="all" selected="selected">Toutes categories</option>
                                    <%
                                        listes = getList.findAllCategories();
                                        out.println(listes.size()+"");
                                        Categories tmp;
                                        for(int i = 0;i<listes.size();i++){
                                        tmp = (Categories) listes.get(i);
                                    %>
                                    <option value="<% out.println(tmp.getId()); %>"><% out.println(tmp.getNomCategorie()); %></option>
                                    <% } %>
                                </select>
                            </div>
                        </div>
                </div>
	 <div class="col-md-4 col-xs-10">
                        <div class="form-group">
                            <div class="">
                                <select style="font-size: 14px; background: #EAEAEA; border: none;" name="souscategorie" id="souscategorie" size="1" class="input-lg form-control arrow-hide date_class">
                                    <option value="all" selected="selected">Toutes sous categories</option>
                                </select>
                                
                        </div>
                    </div>
                  
                </div>
                </form>
            </div>
        </div>
        <script type="text/javascript">
            $(document).ready(function(){
                $('#categorie').on('change',function(){
                    var catId = $(this).val(); 
                    if(catId){
                        $.ajax({
                            type:'POST',
                            url:'AjaxSearch',
                            data:'idcategorie='+catId,
                            success:function(html){
                                $('#souscategorie').html(html);
                            }
                        });
                    }             
                });
            });
      </script>