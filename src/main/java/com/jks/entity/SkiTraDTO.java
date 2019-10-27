package com.jks.entity;

import java.util.List;

public class SkiTraDTO {//动态查询时的数据统一传输对象
	private List<Skill> list;
	private SkillTrain main;
	public List<Skill> getList() {
		return list;
	}
	public void setList(List<Skill> list) {
		this.list = list;
	}
	public SkillTrain getMain() {
		return main;
	}
	public void setMain(SkillTrain main) {
		this.main = main;
	}
	@Override
	public String toString() {
		return "SkiTraDTO [list=" + list + ", main=" + main + "]";
	}
	
}
