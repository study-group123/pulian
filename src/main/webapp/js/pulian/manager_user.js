function saveUser(){
	 var userCode=$.trim($("#userCode").val());
	 var password=$.trim($("#passWord").val());
		if(userCode=='' || password==''){
			alert("请输入登录用户名和密码");
			return;
		}
	   $.ajax({
			url : "/user/saveUser",
			cache : false,
			async : false,
			data : JSON.stringify($("#addUserForm").serializeObject()),
			type : "POST",
			datatype : "json",
			contentType:"application/json",
			success: function(data){
			 if(data!="" && data.successStatus=="YES"){
		            alert()
			 }else{
			     alert("登录失败,请重新登录！");
			     window.location.reload(); 
			 }
   		  }
	    });
}