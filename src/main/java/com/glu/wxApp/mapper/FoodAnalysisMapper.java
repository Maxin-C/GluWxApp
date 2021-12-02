package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.FoodAnalysis;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodAnalysisMapper {

    void addFoodAnalysis (@Param("foodAnalysis") FoodAnalysis foodAnalysis);

    List<FoodAnalysis> findFoodAnalysis(@Param("foodAnalysis") FoodAnalysis foodAnalysis);

    void updateFoodAnalysis (@Param("foodAnalysisOld") FoodAnalysis foodAnalysisOld, @Param("foodAnalysisNew") FoodAnalysis foodAnalysisNew);

    void deleteFoodAnalysis (@Param("foodAnalysis") FoodAnalysis foodAnalysis);
}
