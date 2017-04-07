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
			    if(e){
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
					            Modal.alert({msg: "操作成功",title: '标题', btnok: '确定',btncl:'取消'});
						 }else{
						      Modal.alert({msg: "操作失败",title: '标题', btnok: '确定',btncl:'取消'});
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
		
		/*"fnServerParams" : function(aoData) {
			aoData = $.merge(aoData, selectFormArray);
		},*/
		//"serverMethod" : "post",
		"serverSide" : true, // 异步请求
		"aoColumns" : [
		{
			"mData" : "applicantName",
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
		},{
			"mData" : "currentUserVipLevel",
			"bSortable" : false,
			"sClass" : "txt-center",
			"mRender" : function(data, type, full) {// 格式化数据
				var str = '';
   				if($('input[name="currentUserVipLevel"]') == 'SILVER'){
   					str+='<a href="javascript:;" style="color:blue" onclick="saveApprovalDto()" >申请</a>';
   				}else{
   					str+='<a href="javascript:;" style="color:blue" onclick="updateApprovalStatus('+"'"+full.approvalId+"' ,'"+ full.beforeThirtyAchievement+"' ,'YES'"+')" >批准</a>    ';
   					str+='<a href="javascript:;" style="color:blue" onclick="updateApprovalStatus('+"'"+full.approvalId+"' ,'"+ full.beforeThirtyAchievement+"' ,'NO'"+')" >拒绝</a>';
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
		/*"fnServerData" : function(sSource, data, fnCallback) {
			$.ajax({
				"dataType" : 'json',
				"type" : "POST",
				"url" : sSource,
				"data" : data,
				"timeout" : 60000, // 连接超时时间
				"error" : function handleAjaxError(xhr,
						textStatus, error) {
				},
				"success": function(data, textStatus){
			           if(data.data!=""){
			        	   fnCallback(data.data);
			              }
			           
			       },
			});
		},*/
		"ajax":{
			"url" : '/approval/queryApprovalList',// 请求url
			"data":getParams(),
			"dataType" : 'json',
			"type" : "POST",
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
	searchAllData();
	/*$("#jqGridList").jqGrid('setGridParam', {
		url: "/approval/queryApprovalList", 
		datatype : "json",
		contentType:"application/json",
		mtype : "POST",
		postData : getParams()
	}).trigger("reloadGrid");*/
}



/*$("#jqGridList").jqGrid({  
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
            	var str = '';
				if($('input[name="currentUserVipLevel"]') == 'SILVER'){
					str+='<a href="javascript:;" style="color:blue" onclick="saveApprovalDto()" >申请</a>';
				}else{
					str+='<a href="javascript:;" style="color:blue" onclick="updateApprovalStatus('+"'"+rowObject.approvalId+"' ,'"+ rowObject.beforeThirtyAchievement+"' ,'YES'"+')" >批准</a>    ';
					str+='<a href="javascript:;" style="color:blue" onclick="updateApprovalStatus('+"'"+rowObject.approvalId+"' ,'"+ rowObject.beforeThirtyAchievement+"' ,'NO'"+')" >拒绝</a>';
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
    rowNum: 10,  
    rownumbers: true, // 显示行号  
    rownumWidth: 35, // the width of the row numbers columns  
    pager: "#jqGridPager",//分页控件的id
    rowList:[10,20,50],   //分页选项，可以下拉选择每页显示记录数
    jsonReader : {
		root : "results",               // json中代表实际模型数据的入口  
		page : "pagination.page",       // json中代表当前页码的数据   
		records : "pagination.records", // json中代表数据行总数的数据   
		total:'pagination.total',       // json中代表页码总数的数据 
		repeatitems : false             // 如果设为false，则jqGrid在解析json时，会根据name来搜索对应的数据元素（即可以json中元素可以不按顺序）；而所使用的name是来自于colModel中的name设定。   
	    },
    subGrid: false,//是否启用子表格  
    postData : getParams()
});  */

