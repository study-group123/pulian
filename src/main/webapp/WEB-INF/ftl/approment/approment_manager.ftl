		   <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header">silver to gold manager</h3>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <form class="form-horizontal" role="form" id="appromentManagerForm">
              <input type="hidden" name="currentUserVipLevel" value=${user.vipLevel}>
			  <div class="form-group">
				<label for="userName" class="col-sm-2 control-label"><span style="color: red">*</span>真实姓名:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="userName" name="userName" >
				</div>
				<label for="userPhone" class="col-sm-2 control-label"><span style="color: red">*</span>手机号:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="userPhone"  name="userPhone">
				</div>
			  </div>
			  
			  <div class="form-group">
				<label for="bankNo" class="col-sm-7 control-label"></label>
				<div class="col-sm-1">
				  <a href="javascript:queryApprovalList()" class="btn btn-sm btn-success btn-block">搜索</a>
				</div>
			  </div>
			  
			 
			</form>
			<div class="jqGrid_wrapper">  
			    <table id="jqGridList"></table>  
			    <div id="jqGridPager"></div>  
			</div> 
			<form id="exportCsvForm" action="${request.contextPath}/vasProduct/exportVasCouponCsv" method="post" target="_blank">
				<div id="exportCsvDiv" style="display:none;">
				</div>
			</form> 
		<script src="${request.contextPath}/js/pulian/approment_manager.js"></script>
