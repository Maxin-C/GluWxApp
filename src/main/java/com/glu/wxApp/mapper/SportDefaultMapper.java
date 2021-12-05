package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.SportDefault;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportDefaultMapper {

    void addSportDefault (@Param("sportDefault") SportDefault sportDefault);

    List<SportDefault> findSportDefault(@Param("sportDefault") SportDefault sportDefault);

    void updateSportDefault (@Param("sportDefaultOld") SportDefault sportDefaultOld, @Param("sportDefaultNew") SportDefault sportDefaultNew);

    void deleteSportDefault (@Param("sportDefault") SportDefault sportDefault);
}
