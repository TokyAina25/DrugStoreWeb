<?php
 $categories = getTable("categories");
 $array = array(
     1 => "One",
     2 => "Two",
     3 => "Three",
     4 => "Fourth",
     5 => "Five",
     6 => "Six"
 );
 ?>

<div class="col-md-3 col-sm-4 col-xs-12 left_sidebar1">
                        <div id="left_part">
                            <div class="bs-example">
                                <div class="panel-group" id="accordion">
                                <?php
                                 $i = 1;
                                 while ($ligne = $categories->fetch()){
                                ?>
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <div class="infoBoxHeading">
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse<?php echo $array[$i] ?>"><?php echo $ligne['nomcategorie']?></a>
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse<?php echo $array[$i] ?>">
                                                <i id="accordan_plus" class="indicator glyphicon glyphicon-chevron-up  pull-right accordan_plus"></i>
                                                </a>
                                            </div>
                                        </div>
                                        <div id="collapse<?php echo $array[$i] ?>" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <div class="infoBoxContents">
                                                <?php
                                                  $souscategorie = getSousCategorie($ligne['idcategorie']);
                                                  while($ligne1 = $souscategorie->fetch()){?>
                                                    <a href="product.html"><?php echo $ligne1['nomsouscategorie']; ?></a><br/>
                                                <?php } ?>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <?php
                                   $i++;   
                                }
                                  ?>
                                </div>
                            </div>
                        </div>
                        
                        