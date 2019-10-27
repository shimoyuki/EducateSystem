package com.jks.entity;

public class Skill {
    private Integer id;

    private String admcode;

    private String year;

    private String city;

    private String name;

    private Integer audit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdmcode() {
        return admcode;
    }

    public void setAdmcode(String admcode) {
        this.admcode = admcode == null ? null : admcode.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }

	@Override
	public String toString() {
		return "Skill [id=" + id + ", admcode=" + admcode + ", year=" + year
				+ ", city=" + city + ", name=" + name + ", audit=" + audit
				+ "]";
	}
    
}