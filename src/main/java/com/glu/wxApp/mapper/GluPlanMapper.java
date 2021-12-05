package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.GluPlan;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GluPlanMapper {

    void addGluPlan (@Param("gluPlan") GluPlan gluPlan);

    List<GluPlan> findGluPlan(@Param("gluPlan") GluPlan gluPlan);

    void updateGluPlan (@Param("gluPlanOld") GluPlan gluPlanOld, @Param("gluPlanNew") GluPlan gluPlanNew);

    void deleteGluPlan (@Param("gluPlan") GluPlan gluPlan);
}
