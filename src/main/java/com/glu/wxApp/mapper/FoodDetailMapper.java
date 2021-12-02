package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.FoodDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodDetailMapper {

    void addFoodDetail (@Param("foodDetail") FoodDetail foodDetail);

    List<FoodDetail> findFoodDetail(@Param("foodDetail") FoodDetail foodDetail);

    void updateFoodDetail (@Param("foodDetailOld") FoodDetail foodDetailOld, @Param("foodDetailNew") FoodDetail foodDetailNew);

    void deleteFoodDetail (@Param("foodDetail") FoodDetail foodDetail);
}
