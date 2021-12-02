package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.Doctor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorMapper {

    void addDoctor (@Param("doctor") Doctor doctor);

    List<Doctor> findDoctor(@Param("doctor") Doctor doctor);

    void updateDoctor (@Param("doctorOld") Doctor doctorOld, @Param("doctorNew") Doctor doctorNew);

    void deleteDoctor (@Param("doctor") Doctor doctor);
}
