package com.jks.entity;

import java.util.List;

public class  CounDTO{//动态查询时的数据统一传输对象
	private List<Poor> list;
	private CounpaSupp main;
	public List<Poor> getList() {
		return list;
	}
	public void setList(List<Poor> list) {
		this.list = list;
	}
	public CounpaSupp getMain() {
		return main;
	}
	public void setMain(CounpaSupp main) {
		this.main = main;
	}
	@Override
	public String toString() {
		return "CounDTO [list=" + list + ", main=" + main + "]";
	}
	
}
