package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {

    void addUserInfo (@Param("userInfo") UserInfo userInfo);

    List<UserInfo> findUserInfo(@Param("userInfo") UserInfo userInfo);

    void updateUserInfo (@Param("userInfoOld") UserInfo userInfoOld, @Param("userInfoNew") UserInfo userInfoNew);

    void deleteUserInfo (@Param("userInfo") UserInfo userInfo);
}
