package com.jks.service;

import com.jks.entity.Informant;

public interface InfoService {
	public Informant getInfoByUserCode(String usercode);
	public String getPWByUserCode(String usercode);
	public int updatePWByUserCode(String password,String usercode);
	public int getSum();
	public int getLoginCount();
}
