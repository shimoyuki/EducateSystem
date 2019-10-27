package com.jks.entity;

public class Informant {
   
    private Integer id;

   
    private String usercode;

   
    private String name;

   
    private String post;

    
    private String position;

    
    private String telnumber;

    
    private String mailbox;

    private Integer logincount;
   
    public Integer getId() {
        return id;
    }

   
    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getUsercode() {
        return usercode;
    }

   
    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    
    public String getName() {
        return name;
    }

   
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

   
    public String getPost() {
        return post;
    }

    
    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

   
    public String getPosition() {
        return position;
    }

   
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

  
    public String getTelnumber() {
        return telnumber;
    }

   
    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber == null ? null : telnumber.trim();
    }

    public String getMailbox() {
        return mailbox;
    }

   
    public void setMailbox(String mailbox) {
        this.mailbox = mailbox == null ? null : mailbox.trim();
    }
    
    public Integer getLogincount() {
        return logincount;
    }

    
    public void setLogincount(Integer logincount) {
        this.logincount = logincount;
    }


	@Override
	public String toString() {
		return "Informant [id=" + id + ", usercode=" + usercode + ", name=" + name + ", post=" + post + ", position="
				+ position + ", telnumber=" + telnumber + ", mailbox=" + mailbox + ", logincount=" + logincount + "]";
	}
}