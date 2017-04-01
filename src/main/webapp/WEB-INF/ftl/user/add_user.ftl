		   <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header">新增银卡用户</h3>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <form class="form-horizontal" role="form" id="addUserForm">
			  <div class="form-group">
				<label for="userName" class="col-sm-2 control-label"><span style="color: red">*</span>真实姓名:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="userName" name="userName" >
				</div>
			  </div>
			  <div class="form-group">
				<label for="userPhone" class="col-sm-2 control-label"><span style="color: red">*</span>手机号:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="userPhone"  name="userPhone">
				</div>
			  </div>
			  <div class="form-group">
				<label for="userAddress" class="col-sm-2 control-label"><span style="color: red">*</span>详细地址:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="userAddress" name="userAddress" >
				</div>
			  </div>
			  <div class="form-group">
				<label for="userArea" class="col-sm-2 control-label">所属大区:</label>
				<div class="col-sm-2">
				  <select class="form-control" name="userArea" >
                        <#list userAreaEnum as area><option value="${area!''}">${(area.cnName)!''}</option></#list>
                        </select>
				</div>
			  </div>
			  <div class="form-group">
				<label for="cardType" class="col-sm-2 control-label">证件类型:</label>
				<div class="col-sm-2">
				  <select class="form-control" name="cardType" >
                        <#list cardTypeEnum as c><option value="${c!''}">${(c.cnName)!''}</option></#list>
                        </select>
				</div>
			  </div>
			  <div class="form-group">
				<label for="cardNo" class="col-sm-2 control-label"><span style="color: red">*</span>证件号:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="cardNo"  name="cardNo">
				</div>
			  </div>
			  <div class="form-group">
				<label for="weChatNo" class="col-sm-2 control-label">微信号:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="weChatNo"  name="weChatNo">
				</div>
			  </div>
			  <div class="form-group">
				<label for="userEmail" class="col-sm-2 control-label">邮箱地址:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="userEmail" name ="userEmail" >
				</div>
			  </div>
			  <div class="form-group">
				<label for="settlementBank" class="col-sm-2 control-label">结算银行:</label>
				<div class="col-sm-2">
				  <select class="form-control" name="settlementBank" >
                        <#list settlementBankEnum as s><option value="${s!''}">${(s.cnName)!''}</option></#list>
                        </select>
				</div>
			  </div>
			  <div class="form-group">
				<label for="bankBranchName" class="col-sm-2 control-label"><span style="color: red">*</span>开户行支行名称:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="bankBranchName" name="bankBranchName" placeholder="XX银行XX市分行XX支行">
				</div>
			  </div>
			  <div class="form-group">
				<label for="bankSerialNo" class="col-sm-2 control-label"><span style="color: red">*</span>联行号:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="bankSerialNo"  name="bankSerialNo">
				</div>
			  </div>
			  <div class="form-group">
				<label for="bankNo" class="col-sm-2 control-label"><span style="color: red">*</span>银行卡号:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="bankNo"  name="bankNo">
				</div>
			  </div>
			  <div class="form-group">
				<label for="bankNo" class="col-sm-2 control-label"></label>
				<div class="col-sm-1">
				  <a href="javascript:saveUser()" class="btn btn-lg btn-success btn-block">提交</a>
				</div>
			  </div>
			  
			 
			</form>
		<script src="${request.contextPath}/js/pulian/manager_user.js"></script>
