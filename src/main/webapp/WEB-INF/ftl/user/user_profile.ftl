		   <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">用户基本信息</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <form class="form-horizontal" role="form">
			  <div class="form-group">
				<label for="userCode" class="col-sm-2 control-label">CODE:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="userCode" disabled value=${user.userCode}>
				</div>
			  </div>
			  <div class="form-group">
				<label for="vipLevel" class="col-sm-2 control-label">卡号等级:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="vipLevel" disabled  value=${user.vipLevel.cnName}>
				</div>
			  </div>
			  <div class="form-group">
				<label for="remainingCardsNum" class="col-sm-2 control-label">剩余开卡数:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="remainingCardsNum" disabled value=${user.remainingCardsNum}>
				</div>
			  </div>
			  <div class="form-group">
				<label for="boughtChildren" class="col-sm-2 control-label">活跃总人数:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="boughtChildren" disabled value=${user.boughtChildren}>
				</div>
			  </div>
			  <div class="form-group">
				<label for="inActiveChildren" class="col-sm-2 control-label">未激活人数:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="inActiveChildren" disabled value=${user.inActiveChildren}>
				</div>
			  </div>
			  <div class="form-group">
				<label for="frozenChildren" class="col-sm-2 control-label">已冻结人数:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="frozenChildren" disabled value=${user.frozenChildren}>
				</div>
			  </div>
			  <div class="form-group">
				<label for="activeStatus" class="col-sm-2 control-label">是否激活:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="activeStatus" disabled value=${user.activeStatus.cnName}>
				</div>
			  </div>
			  <div class="form-group">
				<label for="frozenStatus" class="col-sm-2 control-label">是否冻结:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="frozenStatus" disabled value=${user.frozenStatus.cnName}>
				</div>
			  </div>
			  <div class="form-group">
				<label for="userDisable" class="col-sm-2 control-label">是否销户:</label>
				<div class="col-sm-2">
				  <input type="text" class="form-control" id="userDisable" disabled value=${user.userDisable.cnName}>
				</div>
			  </div>
			 
			 
			</form>
