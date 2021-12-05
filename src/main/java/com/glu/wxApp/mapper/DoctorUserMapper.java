package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.DoctorUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorUserMapper {

    void addDoctorUser (@Param("doctorUser") DoctorUser doctorUser);

    List<DoctorUser> findDoctorUser(@Param("doctorUser") DoctorUser doctorUser);

    void updateDoctorUser (@Param("doctorUserOld") DoctorUser doctorUserOld, @Param("doctorUserNew") DoctorUser doctorUserNew);

    void deleteDoctorUser (@Param("doctorUser") DoctorUser doctorUser);
}
