package com.pulian.mall.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pulian.mall.dto.AchievementDto;
import com.pulian.mall.request.AchievementManagerRequest;
import com.pulian.mall.request.BaseResultT;
import com.pulian.mall.util.JqGridPagination;
 
/*
 *  
 * @author wangxiaoqiang
 * @date 2017-3-22
 */
@Service
public class AchievementManagerServiceImpl {

	public BaseResultT<List<AchievementDto>> queryAchievementList(JqGridPagination pagination,AchievementManagerRequest achievementManagerRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	/*public BaseResultT<List<AchievementDto>> getBeforeThirtyAchievement(Pagination pagination,AchievementManagerRequest achievementManagerRequest) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
