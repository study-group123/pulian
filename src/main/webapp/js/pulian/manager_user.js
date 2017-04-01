function saveUser(){

	   if(!validateRequire()) return false;
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
			        var msgStr = "新用户的CODE是"+data.result.userCode+"</br>"+
			                  "新用户的账号是"+data.result.userAccount
		            Modal.alert({msg: msgStr,title: '标题', btnok: '确定',btncl:'取消'});
			 }else{
			      Modal.alert({msg: data.message,title: '标题', btnok: '确定',btncl:'取消'});
			 }
   		  }
	    });
}

function validateRequire(){
   
		if($.trim($("#userName").val())==""){
		  Modal.alert({msg: '真实姓名不能为空！',title: '校验结果', btnok: '确定',btncl:'取消'});
		  $("#userName").focus()
		  return false;
		}
		if($.trim($("#userPhone").val())==""){
		  Modal.alert({msg: '手机号不能为空！',title: '校验结果', btnok: '确定',btncl:'取消'});
		  $("#userPhone").focus()
		  return false;
		}
		if($.trim($("#userAddress").val())==""){
		  Modal.alert({msg: '详细地址不能为空！',title: '校验结果', btnok: '确定',btncl:'取消'});
		  $("#userAddress").focus()
		  return false;
		}
		if($.trim($("#cardNo").val())==""){
		  Modal.alert({msg: '证件号不能为空！',title: '校验结果', btnok: '确定',btncl:'取消'});
		  $("#cardNo").focus()
		  return false;
		}
		if($.trim($("#bankBranchName").val())==""){
		  Modal.alert({msg: '开户行支行名称不能为空！',title: '校验结果', btnok: '确定',btncl:'取消'});
		  $("#bankBranchName").focus()
		  return false;
		}
		if($.trim($("#bankSerialNo").val())==""){
		  Modal.alert({msg: '联行号不能为空！',title: '校验结果', btnok: '确定',btncl:'取消'});
		  $("#bankSerialNo").focus()
		  return false;
		}
		if($.trim($("#bankNo").val())==""){
		  Modal.alert({msg: '银行卡号不能为空！',title: '标题', btnok: '确定',btncl:'取消'});
		  $("#bankNo").focus()
		  return false;
		}
		


       return true;
}