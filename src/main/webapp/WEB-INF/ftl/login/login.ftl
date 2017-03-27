<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<html>    
    <head>    
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">    
    <title>登入页</title> 
	<link type="text/css" rel="stylesheet" href="${request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"/>
	<link type="text/css" rel="stylesheet" href="${request.contextPath}/vendor/metisMenu/metisMenu.min.css"/>
	<link type="text/css" rel="stylesheet" href="${request.contextPath}/dist/css/sb-admin-2.css"/>
	<link type="text/css" rel="stylesheet" href="${request.contextPath}/vendor/font-awesome/css/font-awesome.min.css"/>
	
    </head>   
       
    <body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">请登入</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" name="loginForm" id = "loginForm" action="" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="CODE" name="userCode" id="userCode"  type="email" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="passWord" id="passWord" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <a href="${request.contextPath}/updatePassWord">忘记密码</a>
                                    </label>
                                </div>
                                <a href="javascript:checkUserLogin()" class="btn btn-lg btn-success btn-block">登入</a>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="${request.contextPath}/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${request.contextPath}/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${request.contextPath}/dist/js/sb-admin-2.js"></script>

	<script src="${request.contextPath}/js/pulian/login.js"></script>
	<script src="${request.contextPath}/js/pulian/common.js"></script>
</body>
 </html>