package com.jks.entity;

import java.util.List;

public class SchoolDTO {//动态查询时的数据统一传输对象
	List<MajorSchool> list;
	SchoolInfo main;
	
	public List<MajorSchool> getList() {
		return list;
	}
	
	public void setList(List<MajorSchool> list) {
		this.list = list;
	}
	
	public SchoolInfo getMain() {
		return main;
	}
	
	public void setMain(SchoolInfo main) {
		this.main = main;
	}

	public SchoolDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SchoolDTO(List<MajorSchool> list, SchoolInfo main) {
		super();
		this.list = list;
		this.main = main;
	}

	@Override
	public String toString() {
		return "SchoolDTO [list=" + list + ", main=" + main + "]";
	}
	
}
