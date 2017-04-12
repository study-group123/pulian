function saveApprovalDto(){
	Modal.confirm(
			  {
			    msg: "请填写申请理由</br><input type='textarea' id='desc'>"
			  })
			  .on( function (e,desc) {
				  
				var dataStr = '{"approvalId":"'+approvalId+'","approvalResult":"'+status+'","approvalReason":"'+desc+'"}';
			    if(e){
			    	$.ajax({
						url : "/approval/saveApprovalDto",
						cache : false,
						async : false,
						data : dataStr,
						type : "POST",
						datatype : "json",
						contentType:"application/json",
						success: function(data){
						 if(data!="" && data.successStatus=="YES"){
					            Modal.alert({msg: "申请成功",title: '标题', btnok: '确定',btncl:'取消'});
						 }else{
						      Modal.alert({msg: "申请失败",title: '标题', btnok: '确定',btncl:'取消'});
						 }
					  }
				    });
			    }
			  });
	
	   /*$.ajax({
			url : "/approval/saveApprovalDto",
			cache : false,
			async : false,
			data : "",
			type : "POST",
			datatype : "json",
			contentType:"application/json",
			success: function(data){
			 if(data!="" && data.successStatus=="YES"){
		            Modal.alert({msg: "申请成功",title: '标题', btnok: '确定',btncl:'取消'});
			 }else{
			      Modal.alert({msg: data.message,title: '标题', btnok: '确定',btncl:'取消'});
			 }
   		  }
	    });*/
}

function updateApprovalStatus(applicantId,approvalId,beforeThirtyAchievement,status){
	
	

	Modal.confirm(
			  {
			    msg: "请填写审批理由</br><input type='textarea' id='desc'>"
			  })
			  .on( function (e,desc) {
				  
				var dataStr = '{"approvalId":"'+approvalId+'","applicantId":"'applicantId+'","approvalResult":"'+status+'","approvalResultDesc":"'+desc+'"}';
			    if(e){
			    	$.ajax({
						url : "/approval/updateApprovalStatus",
						cache : false,
						async : false,
						data : dataStr,
						type : "POST",
						datatype : "json",
						contentType:"application/json",
						success: function(data){
						 if(data!="" && data.successStatus=="YES"){
					            Modal.alert({msg: "审批成功",title: '标题', btnok: '确定',btncl:'取消'});
						 }else{
						      Modal.alert({msg: "审批失败",title: '标题', btnok: '确定',btncl:'取消'});
						 }
					  }
				    });
			    }
			  });
	   
}

//将条件插入到导出exportCsvForm
function conditionHtmlToExportCsvForm()
{
	$('#exportCsvDiv').html($('#appromentManagerForm').clone());
	$.each($('#appromentManagerForm').find('select'), function(index, obj)
	{
		var objName = $(obj).attr('name');
		$('#exportCsvDiv').find('select[name="'+objName+'"]').attr('value', $(obj).val());
	});
	
}

//导出Csv
/*
 * 如果有写错的属性名，会报这个错误
 * Uncaught TypeError: Cannot read property 'fnInit' of undefined
 * */

function getParams()
{
	//conditionHtmlToExportCsvForm();
	//console.info(JSON.stringify($("#exportCsvForm").serializeObject()));
	return $("#appromentManagerForm").serializeArray();
}

var searchAll;
//var selectFormArray=[];
function searchAllData(){
	searchAll = $('#myDataTable').dataTable({
		"filter" : false,
		"paginate": true,
		"retrieve": true,
		"destroy": true,
		"serverSide" : true, // 异步请求
		"aoColumns" : [
		{
			"mData" : "applicantName",
			"bSortable" : false,
			"sClass" : "txt-center",
		},{
			"mData" : "applicantPhone",
			"bSortable" : false,
			"sClass" : "txt-center",
		},{
			"mData" : "approverName",
			"bSortable" : false,
			"sClass" : "txt-center",
		}, {
			"mData" : "approverPhone",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "beforeThirtyAchievement",
			"bSortable" : false,
			"sClass" : "txt-center"
		},{
			"mData" : "approvalResult",
			"bSortable" : false,
			"sClass" : "txt-center",
			"mRender" : function(data, type, full) {// 格式化数据
				var str = '';
   				if($('input[name="currentUserVipLevel"]').val() == 'SILVER'){
   					str+='<a href="javascript:;" style="color:blue" onclick="saveApprovalDto()" >apply</a>';
   				}else{
   					str+='<a href="javascript:;" style="color:blue" onclick="updateApprovalStatus('+"'"+full.approvalId+"' ,'"+ full.beforeThirtyAchievement+"' ,'YES'"+')" >yes</a>    ';
   					str+='<a href="javascript:;" style="color:blue" onclick="updateApprovalStatus('+"'"+full.approvalId+"' ,'"+ full.beforeThirtyAchievement+"' ,'NO'"+')" >no</a>';
   				} 
                   return data==""?"init":data ;  
			 }
		},{
			"mData" : "currentUserVipLevel",
			"bSortable" : false,
			"sClass" : "txt-center",
			"mRender" : function(data, type, full) {// 格式化数据
				var str = '';
   				if($('input[name="currentUserVipLevel"]').val() == 'SILVER'){
   					str+='<a href="javascript:;" style="color:blue" onclick="saveApprovalDto()" >apply</a>';
   				}else{
   					str+='<a href="javascript:;" style="color:blue" onclick="updateApprovalStatus('+"'"+full.applicantId+"' ,'"+"'"+full.approvalId+"' ,'"+ full.beforeThirtyAchievement+"' ,'YES'"+')" >yes</a>    ';
   					str+='<a href="javascript:;" style="color:blue" onclick="updateApprovalStatus('+"'"+full.applicantId+"' ,'"+"'"+full.approvalId+"' ,'"+ full.beforeThirtyAchievement+"' ,'NO'"+')" >no</a>';
   				} 
                   return str ;  
			 }
		}],
		
		"stateSave":false,
		"autoWidth": false,
		"sortable":false,
		"lengthMenu": [ [10, 25, 50, -1], [10, 25, 50, "All"] ],//Show options 10, 25, 50 and all records
		"pageLength" : 10,
		"stripeClasses": ["odd", "even"], //为奇偶行加上样式，兼容不支持CSS伪类的场合
		"ajax":{
			"url" : '/approval/queryApprovalList',// 请求url
			"data":getParams(),
			"dataType" : 'json',
			"type" : "POST",
			"error" : function handleAjaxError(xhr,
					textStatus, error) {
				console.error("查询异常");
			}
			//"success": function(data,callback, textStatus){callback(data);}   //callback function 传不过来
		},
		"renderer": "bootstrap", //渲染样式：Bootstrap和jquery-ui
		"pagingType": "full_numbers", //分页样式：simple,simple_numbers,full,full_numbers
		"language" : {
			"lengthMenu" : "每页显示 _MENU_ 条记录",
			"zeroRecords" : "抱歉， 没有找到",
			"info" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
			"infoEmpty" : "",
			"infoFiltered" : "",
			"paginate" : {
				"first" : "首页",
				"previous" : "前一页",
				"next" : "后一页",
				"last" : "尾页"
			}
		}
	});
};

function queryApprovalList() { 
		
	//selectFormArray = $("#appromentManagerForm").serializeArray();
	searchAll.search();
}
