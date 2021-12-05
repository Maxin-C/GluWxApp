package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.FoodRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRecordMapper {

    void addFoodRecord (@Param("foodRecord") FoodRecord foodRecord);

    List<FoodRecord> findFoodRecord(@Param("foodRecord") FoodRecord foodRecord);

    void updateFoodRecord (@Param("foodRecordOld") FoodRecord foodRecordOld, @Param("foodRecordNew") FoodRecord foodRecordNew);

    void deleteFoodRecord (@Param("foodRecord") FoodRecord foodRecord);
}
