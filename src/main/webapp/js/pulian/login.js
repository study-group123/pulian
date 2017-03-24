
function checkUserLogin(){
	 var userCode=$.trim($("#userCode").val());
	 var password=$.trim($("#passWord").val());
		if(loginName=='' || password==''){
			alert("请输入登录用户名和密码");
			return;
		}
	   $.ajax({
			url : "${request.contextPath}/login/userLogin",
			cache : false,
			async : false,
			data : {
				"userCode" : userCode,
				"passWord" : password
				},
			type : "POST",
			datatype : "json",
			success: function(data){
			 if(data!="" && data.successStatus=="YES"){
			    	$("#userName").val(loginName);
		            $("#passwords").val(password);
		            document.form1.action = "searchUserLogin";
                    document.form1.submit(); 
			 }else{
			     alert("登录失败,请重新登录！");
			     window.location.reload(); 
			 }
   		  }
	    });
	}
