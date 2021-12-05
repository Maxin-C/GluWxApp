package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.MedicinePlan;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicinePlanMapper {

    void addMedicinePlan (@Param("medicinePlan") MedicinePlan medicinePlan);

    List<MedicinePlan> findMedicinePlan(@Param("medicinePlan") MedicinePlan medicinePlan);

    void updateMedicinePlan (@Param("medicinePlanOld") MedicinePlan medicinePlanOld, @Param("medicinePlanNew") MedicinePlan medicinePlanNew);

    void deleteMedicinePlan (@Param("medicinePlan") MedicinePlan MedicinePlan);
}
