package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jks.entity.User;
@Repository
public interface UserMapper {
   
    boolean deleteByPrimaryKey(Integer id);
   
    int insert(User record);
  
    int insertSelective(User record);
    
    int saveUser(User record);
    
    User selectByPrimaryKey(Integer id);
    
    User selectUserByCode(String usercode);
    
    Integer selectUserIDByCode(String usercode);
    
    String selectPWByID(int id);
    
    String selectPWByUserCode(String usercode);
    
    User selectByNameAndPW(@Param("loginName")String loginName,@Param("loginPwd")String loginPwd);
   
    List<User> selectAllUser();
    
    int selectSumUser();
    
    int updateByPrimaryKeySelective(User record);
   
    int updateByPrimaryKey(User record);
    
    int updatePWByUserCode(String password,String usercode);

	List<User> getAllUserByAccount(String account);
 
}