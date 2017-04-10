<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<html>    
    <head>    
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">    
    <title></title> 
	<link type="text/css" rel="stylesheet" href="${request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"/>
	<link type="text/css" rel="stylesheet" href="${request.contextPath}/vendor/metisMenu/metisMenu.min.css"/>
	<link type="text/css" rel="stylesheet" href="${request.contextPath}/dist/css/sb-admin-2.css"/>
	<link type="text/css" rel="stylesheet" href="${request.contextPath}/vendor/font-awesome/css/font-awesome.min.css"/>
	<!--link type="text/css" rel="stylesheet" href="${request.contextPath}/css/jqgrid/redmond/jquery-ui-1.8.16.custom.min.css">
	<link type="text/css" rel="stylesheet" href="${request.contextPath}/css/jqgrid/ui.jqgrid.css"/-->
    </head>   
    <script type="text/javascript">
	     function showContent(url){
			console.info(url);
			$.ajax( {
			    url: url, 
			    type: "post", 
			    dataType: "html",
			    success: function(data){
			      $("#page-wrapper").html(data);
			    }
			});
		 }
	
	</script>
    <body>

     <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                
                <a class="navbar-brand" href="/index">System Name</a>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i>用户简介</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i>更新密码</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="/login/loginOut"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                       
                       
                         <!-- 
                         
                         <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Flot Charts</a>
                                </li>
                                <li>
                                    <a href="morris.html">Morris.js Charts</a>
                                </li>
                            </ul>
                           
                        </li>
                         -->
                        
                        <#if menuList??>
							<#list menuList as obj>
				            	<li>
							    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> ${obj.menuName}<span class="fa arrow"></span></a>
								    <ul class="nav nav-second-level">
									<#list obj.sonMenu as subObj>
										<li ><a href="javascript:showContent('${subObj.menuPath}')" >${subObj.menuName}</a></li>
									</#list>
									</ul>
								</li>
							</#list>
						</#if>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

         <div id="page-wrapper">
        </div>
    <#include "/common/modal_template.ftl">

    <!-- jQuery -->
    <script src="${request.contextPath}/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
    
    <!--script src="${request.contextPath}/js/jqgrid/js/jquery.jqGrid.src.js"></script-->

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${request.contextPath}/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${request.contextPath}/dist/js/sb-admin-2.js"></script>

	<script src="${request.contextPath}/js/pulian/jquery_fn_extends.js"></script>
	
	<script src="${request.contextPath}/js/pulian/Modal.js"></script>
	
	
	<script type="text/javascript">
		$(function(){ 
		　//　showContent("/user/profile");
		 
		}); 
	    
	
	</script>
</body>
 </html>