package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.UserAuth;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAuthMapper {

    void addUserAuth (@Param("userAuth") UserAuth userAuth);

    List<UserAuth> findUserAuth(@Param("userAuth") UserAuth userAuth);

    void updateUserAuth (@Param("userAuthOld") UserAuth userAuthOld, @Param("userAuthNew") UserAuth userAuthNew);

    void deleteUserAuth (@Param("userAuth") UserAuth userAuth);
}
