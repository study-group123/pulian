package com.pulian.mall.request;

import com.pulian.mall.util.Pagination;

public class AchievementManagerRequest {

	private Pagination pagination = new Pagination();
	
	
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	
	public void countRecords(int records) {
		pagination.countRecords(records);
	}

	public int getEndRow() {
		return pagination.getEndRow();
	}

	public int getPage() {
		return pagination.getPage();
	}

	public int getRecords() {
		return pagination.getRecords();
	}

	public int getRows() {
		return pagination.getRows();
	}

	public String getSidx() {
		return pagination.getSidx();
	}

	public String getSord() {
		return pagination.getSord();
	}

	public int getStartRow() {
		return pagination.getStartRow();
	}

	public int getTotal() {
		return pagination.getTotal();
	}

	public boolean isSearch() {
		return pagination.isSearch();
	}

	public void setPage(int page) {
		pagination.setPage(page);
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
	}

	public void setRows(int rows) {
		pagination.setRows(rows);
	}

	public void setRowsByCustom(int customRows) {
		pagination.setRowsByCustom(customRows);
	}

	public void setSearch(boolean search) {
		pagination.setSearch(search);
	}

	public void setSidx(String sidx) {
		pagination.setSidx(sidx);
	}

	public void setSord(String sord) {
		pagination.setSord(sord);
	}

	public void setTotal(int total) {
		pagination.setTotal(total);
	}
}
