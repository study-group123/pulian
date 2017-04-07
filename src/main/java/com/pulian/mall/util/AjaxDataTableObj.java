package com.pulian.mall.util;

import java.util.List;

public class AjaxDataTableObj<T> {
    /** 返回数据 */
    private List<T> data;
    /** 请求标识 */
    private int draw;
    /** 数据库中总共有多少条 */
    private int recordsTotal;
    /** 数据库中查询过滤后有多少条记录,和iTotalRecords设置为相同 */
    private int recordsFiltered;
    
	/**
     * 无参构造函数
     */
    public AjaxDataTableObj() {
    }

   

    /**
     * 构造函数
     * 
     * @param sEcho 请求标识
     * @param prs 分页结果集
     */
    public AjaxDataTableObj(int sEcho, List<T> results) {
        this.draw = sEcho;
        // 设置列表数据
        this.data = results;
        // 设置显示总记录条数
        this.recordsTotal = results.size();
        // 设置总记录条数
        this.recordsFiltered = results.size();
    }



	public List<T> getData() {
		return data;
	}



	public void setData(List<T> data) {
		this.data = data;
	}



	public int getDraw() {
		return draw;
	}



	public void setDraw(int draw) {
		this.draw = draw;
	}



	public int getRecordsTotal() {
		return recordsTotal;
	}



	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}



	public int getRecordsFiltered() {
		return recordsFiltered;
	}



	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

  
}
