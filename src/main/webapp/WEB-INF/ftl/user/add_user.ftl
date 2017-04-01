		   <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header">新增银卡用户</h3>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <form class="form-horizontal" role="form" name="addUserForm">
			  <div class="form-group">
				<label for="userName" class="col-sm-2 control-label">真实姓名:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="userName"  >
				</div>
			  </div>
			  <div class="form-group">
				<label for="userPhone" class="col-sm-2 control-label">手机号:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="userPhone"  >
				</div>
			  </div>
			  <div class="form-group">
				<label for="userAddress" class="col-sm-2 control-label">详细地址:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="userAddress"  >
				</div>
			  </div>
			  <div class="form-group">
				<label for="userArea" class="col-sm-2 control-label">所属大区:</label>
				<div class="col-sm-2">
				  <select class="form-control" name="userArea" >
                        <option value="">全部</option>
                        <#list userAreaEnum as area><option value="${area!''}">${(area.cnName)!''}</option></#list>
                        </select>
				</div>
			  </div>
			  <div class="form-group">
				<label for="cardType" class="col-sm-2 control-label">证件类型:</label>
				<div class="col-sm-2">
				  <select class="form-control" name="cardType" >
                        <option value="">全部</option>
                        <#list cardTypeEnum as c><option value="${c!''}">${(c.cnName)!''}</option></#list>
                        </select>
				</div>
			  </div>
			  <div class="form-group">
				<label for="cardNo" class="col-sm-2 control-label">证件号:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="cardNo"  >
				</div>
			  </div>
			  <div class="form-group">
				<label for="weChatNo" class="col-sm-2 control-label">微信号:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="weChatNo"  >
				</div>
			  </div>
			  <div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">邮箱地址:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="frozenStatus" >
				</div>
			  </div>
			  <div class="form-group">
				<label for="settlementBank" class="col-sm-2 control-label">结算银行:</label>
				<div class="col-sm-2">
				  <select class="form-control" name="settlementBank" >
                        <option value="">全部</option>
                        <#list settlementBankEnum as s><option value="${s!''}">${(s.cnName)!''}</option></#list>
                        </select>
				</div>
			  </div>
			  <div class="form-group">
				<label for="bankBranchName" class="col-sm-2 control-label">开户行支行名称:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="bankBranchName" palceholder="XX银行XX市分行XX支行">
				</div>
			  </div>
			  <div class="form-group">
				<label for="bankSerialNo" class="col-sm-2 control-label">联行号:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="bankSerialNo"  >
				</div>
			  </div>
			  <div class="form-group">
				<label for="bankNo" class="col-sm-2 control-label">银行卡号:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="bankNo"  >
				</div>
			  </div>
			  <a href="javascript:saveUser()" class="btn btn-lg btn-success btn-block">提交</a>
			 
			</form>
		<script src="${request.contextPath}/js/pulian/manager_user.js"></script>
