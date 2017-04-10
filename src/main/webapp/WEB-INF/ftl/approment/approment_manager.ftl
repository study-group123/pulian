	<!-- DataTables CSS -->
    <link href="${request.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="${request.contextPath}/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
		   <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header">silver to gold manager</h3>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <form class="form-horizontal" role="form" id="appromentManagerForm">
              <input type="hidden" name="currentUserVipLevel" value=${user.vipLevel}>
			  <div class="form-group">
				<label for="userName" class="col-sm-2 control-label"><span style="color: red">*</span>user real name:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="userName" name="userName" >
				</div>
				<label for="userPhone" class="col-sm-2 control-label"><span style="color: red">*</span>phone:</label>
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
			<div class="row" style="margin: 0">
                <div class="col-md-12">
                    <table id="myDataTable" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                            	
                                <th>1</th>
                                <th>2</th>
                                <th>3</th>
                                <th>4</th>
                                <th>5</th>
                                <th>6</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>

			<form id="exportCsvForm" action="${request.contextPath}/vasProduct/exportVasCouponCsv" method="post" target="_blank">
				<div id="exportCsvDiv" style="display:none;">
				</div>
			</form> 
		<!-- DataTables JavaScript -->
    <script src="${request.contextPath}/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="${request.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="${request.contextPath}/vendor/datatables-responsive/dataTables.responsive.js"></script>
	<script src="${request.contextPath}/js/pulian/approment_manager.js"></script>
	
	 <script>
    $(document).ready(function() {
       searchAllData();
    });
    </script>
