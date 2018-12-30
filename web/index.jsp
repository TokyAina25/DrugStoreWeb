<%-- 
    Document   : index
    Created on : 8 déc. 2018, 19:04:06
    Author     : OTME
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <link rel="icon" href="images/favicon.png"/>
        <title>Medistore</title>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/style.css"/> 
        <link rel="stylesheet" type="text/css" href="assets/font-awesome/css/font-awesome.min.css"/>
        <link rel="stylesheet" href="assets/css/owl-carousel.css"/>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/owl-carousel.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/custom.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    </head>
    <body>
        <%@include file="assets/include/header1.jsp" %>
        
        <%@include file="assets/include/search.jsp" %>

        <div id="site_content">
            <div class="container">
                <div class="row">
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
       
                   <%
                       try{
                            String contenue = request.getParameter("contenue");                       
                            if(request.getParameter("contenue") == null){ %>
                             <jsp:include page="assets/include/content.jsp" flush = 'true'></jsp:include>
                         <% }if(contenue != null){
                         %>
                        <jsp:include page='<%="assets/include/content-" + contenue + ".jsp" %>' />

                         <% } 
                         }catch(Exception ex){
                           out.println(ex.getMessage());
                         }
                    %>
                       
                      
                </div>
            </div>
        </div>
        <%@include file="assets/include/footer.jsp" %>            

        <a style="display: none" href="javascript:void(0);" class="scrollTop back-to-top" id="back-to-top">
            <i class="fa fa-chevron-up"></i>
        </a>
     <script src="js/lib/datatables/cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"></script>
    <script src="js/lib/datatables/cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"></script>
    </body>
</html> 