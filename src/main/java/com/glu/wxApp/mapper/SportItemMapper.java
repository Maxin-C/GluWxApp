package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.SportItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportItemMapper {

    void addSportItem (@Param("sportItem") SportItem sportItem);

    List<SportItem> findSportItem(@Param("sportItem") SportItem sportItem);

    void updateSportItem (@Param("sportItemOld") SportItem sportItemOld, @Param("sportItemNew") SportItem sportItemNew);

    void deleteSportItem (@Param("sportItem") SportItem sportItem);
}
