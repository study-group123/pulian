function saveApprovalDto(){

	   $.ajax({
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
	    });
}

function updateApprovalStatus(approvalId,beforeThirtyAchievement,status){

	Modal.confirm(
			  {
			    msg: "请填写理由</br><input type='textarea' id='desc'>"
			  })
			  .on( function (e,desc) {
			    alert("返回结果：" + desc);
			  });
	   $.ajax({
			url : "/approval/updateApprovalStatus",
			cache : false,
			async : false,
			data : "{}",
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
function getParams()
{
	conditionHtmlToExportCsvForm();
	return JSON.stringify($("#exportCsvForm").serializeObject());
}
function queryApprovalList() { 
		
	$("#jqGridList").jqGrid('setGridParam', {
		url: "/approval/queryApprovalList", 
		datatype : "json",
		contentType:"application/json",
		mtype : "POST",
		postData : getParams()
	}).trigger("reloadGrid");
}
$("#jqGridList").jqGrid({  
    caption: "审批管理",  
    url: "/approval/queryApprovalList", 
    contentType:"application/json",
    mtype: "POST",  
    styleUI: 'Bootstrap',//设置jqgrid的全局样式为bootstrap样式  
    datatype: "json",  
    colNames: ['审批表主键','申请人姓名', '申请人手机号', '审批人姓名','审批人手机号', '连续30天业绩', '审批结果', '操作'],  
    colModel: [  
	    { name: 'approvalId', index: 'approvalId', hidden:true}, 
        { name: 'applicantName', index: 'applicantName'},  
        { name: 'applicantPhone', index: 'applicantPhone', },  
        { name: 'approverName', index: 'approverName', },  
        { name: 'approverPhone', index: 'approverPhone', },  
        { name: 'beforeThirtyAchievement', index: 'beforeThirtyAchievement', },  
        { name: 'approvalResult', index: 'approvalResult', },  
        {  
            name: 'currentUserVipLevel', index: 'currentUserVipLevel', 
            formatter: function(cellValue, options, rowObject) {  
            	str = '';
				if($('input[name="currentUserVipLevel"]') == 'SILVER'){
					operateClick+='<a href="javascript:;" style="color:blue" onclick="saveApprovalDto()" >申请</a>';
				}else{
					operateClick+='<a href="javascript:;" style="color:blue" onclick="updateApprovalStatus('+"'"+approvalId+"' ,'"+ beforeThirtyAchievement+"' ,'YES'"+')" >批准</a>    ';
					operateClick+='<a href="javascript:;" style="color:blue" onclick="updateApprovalStatus('+"'"+approvalId+"' ,'"+ beforeThirtyAchievement+"' ,'NO'"+')" >拒绝</a>';
				} 
                return str ;  
            }//jqgrid自定义格式化  
        }, 
    ],  
    viewrecords: true,  
    multiselect: true,  
    rownumbers: true,  
    autowidth: true,  
    height: "100%",  
    rowNum: 20,  
    rownumbers: true, // 显示行号  
    rownumWidth: 35, // the width of the row numbers columns  
    pager: "#jqGridPager",//分页控件的id
    rowList:[10,20,50,500],   //分页选项，可以下拉选择每页显示记录数
    jsonReader : {
		root : "results",               // json中代表实际模型数据的入口  
		page : "pagination.page",       // json中代表当前页码的数据   
		records : "pagination.records", // json中代表数据行总数的数据   
		total:'pagination.total',       // json中代表页码总数的数据 
		repeatitems : false             // 如果设为false，则jqGrid在解析json时，会根据name来搜索对应的数据元素（即可以json中元素可以不按顺序）；而所使用的name是来自于colModel中的name设定。   
	    },
    subGrid: false,//是否启用子表格  
    postData : getParams(),
});  

// 设置jqgrid的宽度  
$(window).bind('resize', function () {  
    var width = $('.jqGrid_wrapper').width();  
    jqGrid.setGridWidth(width);  
});  