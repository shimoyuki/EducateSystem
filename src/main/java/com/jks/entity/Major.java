package com.jks.entity;

public class Major {
	
	private String induname;
	
	private String majorcode;
	
	private String name;
	
	private String skill;
		
	private String occupation;
	
	private String duration;

	public String getInduname() {
		return induname;
	}

	public void setInduname(String induname) {
		this.induname = induname;
	}

	public String getMajorcode() {
		return majorcode;
	}

	public void setMajorcode(String majorcode) {
		this.majorcode = majorcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Major [induname=" + induname + ", majorcode=" + majorcode
				+ ", name=" + name + ", skill=" + skill + ", occupation="
				+ occupation + ", duration=" + duration + "]";
	}
	
}
