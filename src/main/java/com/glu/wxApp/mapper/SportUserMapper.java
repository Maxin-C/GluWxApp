package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.SportUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportUserMapper {

    void addSportUser (@Param("sportUser") SportUser sportUser);

    List<SportUser> findSportUser(@Param("sportUser") SportUser sportUser);

    void updateSportUser (@Param("sportUserOld") SportUser sportUserOld, @Param("sportUserNew") SportUser sportUserNew);

    void deleteSportUser (@Param("sportUser") SportUser sportUser);
}
