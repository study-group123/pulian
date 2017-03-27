<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<html>    
    <head>    
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">    
    <title>登入页</title> 
	<link type="text/css" rel="stylesheet" href="${request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"/>
	<link type="text/css" rel="stylesheet" href="${request.contextPath}/vendor/metisMenu/metisMenu.min.css"/>
	<link type="text/css" rel="stylesheet" href="${request.contextPath}/dist/css/sb-admin-2.css"/>
	<link type="text/css" rel="stylesheet" href="${request.contextPath}/vendor/font-awesome/css/font-awesome.min.css"/>
    <link href="${request.contextPath}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    </head>   
       
    <body>

     <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            

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
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
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
                       
                       
                        <li>
                            <a href="${request.contextPath}/login/index"><i class="fa fa-dashboard fa-fw"></i> 首页</a>
                        </li>
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
                            <!-- /.nav-second-level -->
                        </li>
                        <#if menuList??>
							<#list menuList as obj>
				            	<li>
							    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> ${obj.url?if_exists}<span class="fa arrow"></span></a>
								    <ul class="nav nav-second-level">
									<#list obj.subList as subObj>
										<li ><a target="iframeMain" href="${subObj.url?if_exists}">{subObj.name}</a></li>
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

         <div id="page-wrapper">
            <form class="form-horizontal" role="form">
			  <div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">名字</label>
				<div class="col-sm-10">
				  <input type="text" class="form-control" id="firstname" >
				</div>
			  </div>
			 
			  <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
				  <button type="submit" class="btn btn-default">add</button>
				</div>
			  </div>
			</form>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="${request.contextPath}/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${request.contextPath}/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${request.contextPath}/dist/js/sb-admin-2.js"></script>

	<script src="${request.contextPath}/js/pulian/common.js"></script>
</body>
 </html>