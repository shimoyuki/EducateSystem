package com.jks.entity;

public class FileInfo {
    
    private Integer id;

   
    private String name;

   
    private String url;

   
    private String writetime;

   
    private String writer;

  
    private String source;

    
    private String city;

  
    private Integer audit;
    
    public FileInfo(){
    	
    }
    
    public FileInfo(String name, String url, String writetime, String writer, String source, String city,
			Integer audit) {
		super();
		this.name = name;
		this.url = url;
		this.writetime = writetime;
		this.writer = writer;
		this.source = source;
		this.city = city;
		this.audit = audit;
	}


	public Integer getId() {
        return id;
    }

  
    public void setId(Integer id) {
        this.id = id;
    }

   
    public String getName() {
        return name;
    }

   
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

  
    public String getUrl() {
        return url;
    }

   
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    
    public String getWritetime() {
        return writetime;
    }

 
    public void setWritetime(String writetime) {
        this.writetime = writetime == null ? null : writetime.trim();
    }

    
    public String getWriter() {
        return writer;
    }

   
    public void setWriter(String writer) {
        this.writer = writer == null ? null : writer.trim();
    }

   
    public String getSource() {
        return source;
    }

    
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    
    public String getCity() {
        return city;
    }

    
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

   
    public Integer getAudit() {
        return audit;
    }

    
    public void setAudit(Integer audit) {
        this.audit = audit;
    }
}