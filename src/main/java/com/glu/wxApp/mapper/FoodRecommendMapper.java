package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.FoodRecommend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRecommendMapper {

    void addFoodRecommend (@Param("foodRecommend") FoodRecommend foodRecommend);

    List<FoodRecommend> findFoodRecommend(@Param("foodRecommend") FoodRecommend foodRecommend);

    void updateFoodRecommend (@Param("foodRecommendOld") FoodRecommend foodRecommendOld, @Param("foodRecommendNew") FoodRecommend foodRecommendNew);

    void deleteFoodRecommend (@Param("foodRecommend") FoodRecommend foodRecommend);
}
