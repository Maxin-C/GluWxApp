package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.DoctorChat;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorChatMapper {

    void addDoctorChat (@Param("doctorChat") DoctorChat doctorChat);

    List<DoctorChat> findDoctorChat(@Param("doctorChat") DoctorChat doctorChat);

    void updateDoctorChat (@Param("doctorChatOld") DoctorChat doctorChatOld, @Param("doctorChatNew") DoctorChat doctorChatNew);

    void deleteDoctorChat (@Param("doctorChat") DoctorChat doctorChat);
}
