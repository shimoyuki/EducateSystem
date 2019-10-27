package com.jks.entity;

public class MajorSchool {
    private Integer id;

    private String majorcode;

    private String majorname;

    private String admcode;

    private String schoolname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMajorcode() {
        return majorcode;
    }

    public void setMajorcode(String majorcode) {
        this.majorcode = majorcode == null ? null : majorcode.trim();
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname == null ? null : majorname.trim();
    }

    public String getAdmcode() {
        return admcode;
    }

    public void setAdmcode(String admcode) {
        this.admcode = admcode == null ? null : admcode.trim();
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

	@Override
	public String toString() {
		return "MajorSchool [id=" + id + ", majorcode=" + majorcode
				+ ", majorname=" + majorname + ", admcode=" + admcode
				+ ", schoolname=" + schoolname + "]";
	}
    
}