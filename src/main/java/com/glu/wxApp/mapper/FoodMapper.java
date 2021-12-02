package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.Food;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodMapper {

    void addFood (@Param("food") Food food);

    List<Food> findFood(@Param("food") Food food);

    void updateFood (@Param("foodOld") Food FoodOld, @Param("foodNew") Food foodNew);

    void deleteFood (@Param("food") Food food);
}
