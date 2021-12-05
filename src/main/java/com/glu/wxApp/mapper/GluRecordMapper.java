package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.GluRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GluRecordMapper {

    void addGluRecord (@Param("gluRecord") GluRecord gluRecord);

    List<GluRecord> findGluRecord(@Param("gluRecord") GluRecord gluRecord);

    void updateGluRecord (@Param("gluRecordOld") GluRecord gluRecordOld, @Param("gluRecordNew") GluRecord gluRecordNew);

    void deleteGluRecord (@Param("gluRecord") GluRecord gluRecord);
}
