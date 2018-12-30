package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Modele.AfficheProduits;
import Modele.Categories;
import Modele.BaseModele;
import java.util.List;
import Metier.AvoirListes;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/assets/include/header1.jsp");
    _jspx_dependants.add("/assets/include/search.jsp");
    _jspx_dependants.add("/assets/include/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\n");
      out.write("        <link rel=\"icon\" href=\"images/favicon.png\"/>\n");
      out.write("        <title>Medistore</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/bootstrap.min.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/style.css\"/> \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"assets/font-awesome/css/font-awesome.min.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/owl-carousel.css\"/>\n");
      out.write("        <script src=\"assets/js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/owl-carousel.js\"></script>\n");
      out.write("        <script src=\"assets/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/custom.js\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-4 col-sm-4 col-xs-4\" id=\"logo\" >\r\n");
      out.write("                    <a href=\"index.jsp\" class=\"logo-text\">\r\n");
      out.write("                        Medi<span style=\"color:#39BAF0; font-size:40px\">STORE</span>\r\n");
      out.write("                    </a>\t\t\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-2 col-sm-12 col-xs-12\" style=\"display:none \" id=\"navbar_hide\" >\r\n");
      out.write("                    <nav  role=\"navigation\" class=\"navbar navbar-inverse\">\r\n");
      out.write("                        <a href=\"index.jsp\" style=\"float: left\" class=\"logo-text\">\r\n");
      out.write("                            Medi<span style=\"color:#39BAF0; font-size:40px\">STORE</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <div id=\"nav\">\r\n");
      out.write("                            <div class=\"navbar-header\">\r\n");
      out.write("                                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\" style=\"background: #8EBE08; border: none; margin-right: 0\">\r\n");
      out.write("                                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                                </button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\r\n");
      out.write("                                <ul class=\"nav navbar-nav site_nav_menu1\"  >\r\n");
      out.write("                                    <li class=\"first \" ><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">About us</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">Guarantee</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">Disclaimer</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">Shipping & Payment</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">Privacy Policy</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">Terms & Conditions</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">Contact Us</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">Site Map</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </nav>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4 col-md-offset-4 col-sm-offset-2  col-sm-6 col-xs-12\" >\r\n");
      out.write("                    <div id=\"top_right\">\r\n");
      out.write("                        <div id=\"cart\">\r\n");
      out.write("                            <div class=\"text\"> \r\n");
      out.write("                                <div class=\"img\">\r\n");
      out.write("                                     ");

                                        if(session.getAttribute("nomclient")!=null && session.getAttribute("idclient")!=null){
                                     
      out.write("\r\n");
      out.write("                                     <a href=\"index.jsp?contenue=cart\"> <img class=\"img-responsive\" src=\"assets/images/cart.png\" alt=\"\" title=\"\" width=\"26\" height=\"27\" /></a>\r\n");
      out.write("                                     ");
            
                                        }
                                    
      out.write("\r\n");
      out.write("                                </div><span>Panier</span><span class=\"cart_total\">\r\n");
      out.write("                                    ");

                                        if(session.getAttribute("nomclient")!=null && session.getAttribute("idclient")!=null){
                                            out.println(session.getAttribute("nomclient").toString().toUpperCase());
                                        }
                                    
      out.write("\r\n");
      out.write("                                </span><span class=\"cart_items\">");

                                    if(session.getAttribute("nomclient")!=null && session.getAttribute("idclient")!=null && session.getAttribute("panier")!=null){
                                            List<AfficheProduits> listes = (List<AfficheProduits>) session.getAttribute("panier");
                                            out.println("("+listes.size()+")");
                                    }
                                 
      out.write("</span>\r\n");
      out.write("                            </div> \r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div id=\"bottom_right\">\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"col-md-6 col-xs-6 wd_auto\">\r\n");
      out.write("                                    <div class=\"left\">\r\n");
      out.write("                                        <div class=\"login\">\r\n");
      out.write("                                            ");

                                                if(session.getAttribute("idclient")!=null){
                                           
      out.write("\r\n");
      out.write("                                                    <a class=\"btn btn-default reg_button\" href=\"DecoController\">Deconnection</a>\r\n");
      out.write("                                           ");

                                                }else{ 
      out.write("\r\n");
      out.write("                                                     <a class=\"btn btn-default reg_button\" href=\"index.jsp?contenue=login\">Login</a> \r\n");
      out.write("                                            <a class=\"btn btn-default reg_button\" href=\"register.html\">Signup</a>\r\n");
      out.write("                                           ");
  
                                                }
                                           
      out.write("\r\n");
      out.write("                                           \r\n");
      out.write("                                        </div>\t\t\t\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div> \r\n");
      out.write("                                <div class=\"dropdown-bn wd-33 col-md-6 remove_PL col-xs-6\">\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        \r\n");
      out.write("                                        <div class=\"pl_0 col-md-6 col-xs-6\">\r\n");
      out.write("                                            <div class=\"dropdown btn-group\">\r\n");
      out.write("                                                <button class=\"btn btn-primary dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">currency\r\n");
      out.write("                                                    <span class=\"caret\"></span></button>\r\n");
      out.write("                                                <ul class=\"dropdown-menu\">\r\n");
      out.write("                                                    <li><a href=\"#\">U.S. Dollar</a></li>\r\n");
      out.write("                                                    <li><a href=\"#\">Euro</a></li>\r\n");
      out.write("                                                    <li><a href=\"#\">Pounds Sterling</a></l>\r\n");
      out.write("                                                </ul>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div> \r\n");
      out.write("        <div class=\"container-fluid bg-color\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-md-12 col-xs-12\">\r\n");
      out.write("                            <nav  role=\"navigation\" class=\"navbar navbar-inverse\" id=\"nav_show\">\r\n");
      out.write("                                <div id=\"nav\">\r\n");
      out.write("                                    <div class=\"navbar-header\">\r\n");
      out.write("                                        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\r\n");
      out.write("                                            <span class=\"icon-bar\"></span>\r\n");
      out.write("                                            <span class=\"icon-bar\"></span>\r\n");
      out.write("                                            <span class=\"icon-bar\"></span>\r\n");
      out.write("                                        </button>\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\r\n");
      out.write("                                        <ul class=\"nav navbar-nav site_nav_menu1\"  >\r\n");
      out.write("                                            <li class=\"first \"><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("                                            <li><a href=\"#\">About us</a></li>\r\n");
      out.write("                                            <li><a href=\"#\">Guarantee</a></li>\r\n");
      out.write("                                            <li><a href=\"#\">Disclaimer</a></li>\r\n");
      out.write("                                            <li><a href=\"#\">Shipping & Payment</a></li>\r\n");
      out.write("                                            <li><a href=\"#\">Privacy Policy</a></li>\r\n");
      out.write("                                            <li><a href=\"#\">Terms & Conditions</a></li>\r\n");
      out.write("                                            <li><a href=\"#\">Contact Us</a></li>\r\n");
      out.write("                                            <li><a href=\"#\">Site Map</a></li>\r\n");
      out.write("                                        </ul>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </nav>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div> \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    AvoirListes getList = new AvoirListes();
    List<BaseModele> listes = null;

      out.write("\r\n");
      out.write("<div class=\"container\" >\r\n");
      out.write("    <div class=\"row\" id=\"search_manu\" style=\"margin-top: 10px\">\r\n");
      out.write("      <form action=\"SearchController\" method=\"get\">\r\n");
      out.write("         <div class=\"col-md-4 col-xs-10\">\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <div class=\"input-group\">\r\n");
      out.write("                                <input type=\"text\" name=\"key\" placeholder=\"Entrer le mot clé de recherche\" class=\"form-control input-lg\" id=\"inputGroup\"/>\r\n");
      out.write("                                <input type=\"submit\" value=\"Rechercher\" class=\"btn btn-default\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4 col-xs-10\">\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <div class=\"\">\r\n");
      out.write("                                <select style=\"font-size: 14px; background: #EAEAEA; border: none;\" name=\"categorie\" id=\"categorie\" size=\"1\" class=\"input-lg form-control arrow-hide date_class\">\r\n");
      out.write("                                    <option value=\"all\" selected=\"selected\">Toutes categories</option>\r\n");
      out.write("                                    ");

                                        listes = getList.findAllCategories();
                                        out.println(listes.size()+"");
                                        Categories tmp;
                                        for(int i = 0;i<listes.size();i++){
                                        tmp = (Categories) listes.get(i);
                                    
      out.write("\r\n");
      out.write("                                    <option value=\"");
 out.println(tmp.getId()); 
      out.write('"');
      out.write('>');
 out.println(tmp.getNomCategorie()); 
      out.write("</option>\r\n");
      out.write("                                    ");
 } 
      out.write("\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\t <div class=\"col-md-4 col-xs-10\">\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <div class=\"\">\r\n");
      out.write("                                <select style=\"font-size: 14px; background: #EAEAEA; border: none;\" name=\"souscategorie\" id=\"souscategorie\" size=\"1\" class=\"input-lg form-control arrow-hide date_class\">\r\n");
      out.write("                                    <option value=\"all\" selected=\"selected\">Toutes sous categories</option>\r\n");
      out.write("                                </select>\r\n");
      out.write("                                \r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  \r\n");
      out.write("                </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            $(document).ready(function(){\r\n");
      out.write("                $('#categorie').on('change',function(){\r\n");
      out.write("                    var catId = $(this).val(); \r\n");
      out.write("                    if(catId){\r\n");
      out.write("                        $.ajax({\r\n");
      out.write("                            type:'POST',\r\n");
      out.write("                            url:'AjaxSearch',\r\n");
      out.write("                            data:'idcategorie='+catId,\r\n");
      out.write("                            success:function(html){\r\n");
      out.write("                                $('#souscategorie').html(html);\r\n");
      out.write("                            }\r\n");
      out.write("                        });\r\n");
      out.write("                    }             \r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("      </script>");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"site_content\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                        <script>\n");
      out.write("                            function toggleChevron(e) {\n");
      out.write("                                $(e.target)\n");
      out.write("                                        .prev('.panel-heading')\n");
      out.write("                                        .find(\"i.indicator\")\n");
      out.write("                                        .toggleClass('glyphicon-chevron-down glyphicon-chevron-up');\n");
      out.write("                            }\n");
      out.write("                            $('#accordion').on('hidden.bs.collapse', toggleChevron);\n");
      out.write("                            $('#accordion').on('shown.bs.collapse', toggleChevron);\n");
      out.write("                        </script>\n");
      out.write("       \n");
      out.write("                   ");

                       try{
                            String contenue = request.getParameter("contenue");                       
                            if(request.getParameter("contenue") == null){ 
      out.write("\n");
      out.write("                             ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "assets/include/content.jsp", out, true);
      out.write("\n");
      out.write("                         ");
 }if(contenue != null){
                         
      out.write("\n");
      out.write("                        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "assets/include/content-" + contenue + ".jsp" , out, false);
      out.write("\n");
      out.write("\n");
      out.write("                         ");
 } 
                         }catch(Exception ex){
                           out.println(ex.getMessage());
                        }
                         
      out.write("\n");
      out.write("                       \n");
      out.write("                      \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"footer1\">\r\n");
      out.write("            <div class=\"container-fluid footer-background\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-2 col-sm-3 col-xs-12 txt-center\">\r\n");
      out.write("                                <a href=\"home.html\">\r\n");
      out.write("                                    <span class=\"logo-text\">DRUGSTORE</span>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-7 col-sm-6 col-xs-12\">\r\n");
      out.write("                                <div id=\"footer_menu\">\r\n");
      out.write("                                    <a href=\"home.html\">Home</a> | \r\n");
      out.write("                                    <a href=\"#\">About Us</a> | \r\n");
      out.write("                                    <a href=\"#\">Disclaimer</a> | \r\n");
      out.write("                                    <a href=\"#\">Guarantee</a> | \r\n");
      out.write("                                    <a href=\"#\">Shipping & Payment</a> | \r\n");
      out.write("                                    <a href=\"#\">Privacy Policy</a> <br class=\"disable_content\" />\r\n");
      out.write("                                    <a href=\"#\">Terms & Conditions</a> | \r\n");
      out.write("                                    <a href=\"#\">Contact Us</a> | \r\n");
      out.write("                                    <a href=\"#\">Site Map<span></span></a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-3 col-sm-3 col-xs-12\">\r\n");
      out.write("                                <div id=\"social_icons\" class=\"pull-right\">\r\n");
      out.write("                                    <a href=\"#\" class=\"btn btn-default reg_button\"><i class=\"fa fa-facebook\"></i></a>\r\n");
      out.write("                                    <a href=\"#\" class=\"btn btn-default reg_button\"><i class=\"fa fa-twitter\"></i></a>\r\n");
      out.write("                                    <a href=\"#\" class=\"btn btn-default reg_button\"><i class=\"fa fa-yahoo\"></i></a>\r\n");
      out.write("                                    <a href=\"#\" class=\"btn btn-default reg_button\"><i class=\"fa fa-envelope\"></i></a>\r\n");
      out.write("                                    <a href=\"#\" class=\"btn btn-default reg_button\"><i class=\"fa fa-linkedin\"></i></a>\t\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                                <div class=\"copyright\">\r\n");
      out.write("                                    <!--Do not remove Backlink from footer of the template. To remove it you can purchase the Backlink !-->\r\n");
      out.write("                                    Â© 2017 All right reserved. Designed by\r\n");
      out.write("                                    <a href=\"http://www.themevault.net/\" target=\"_blank\">ThemeVault.</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \n");
      out.write("\n");
      out.write("        <a style=\"display: none\" href=\"javascript:void(0);\" class=\"scrollTop back-to-top\" id=\"back-to-top\">\n");
      out.write("            <i class=\"fa fa-chevron-up\"></i>\n");
      out.write("        </a>\n");
      out.write("     <script src=\"js/lib/datatables/cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js\"></script>\n");
      out.write("    <script src=\"js/lib/datatables/cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html> ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
