package com.jks.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jks.entity.User;

@Repository("getCityListDao")
public interface GetCityListDao {

	List<User> getCityList();

}
