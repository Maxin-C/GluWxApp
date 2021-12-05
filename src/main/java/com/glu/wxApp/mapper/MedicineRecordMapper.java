package com.glu.wxApp.mapper;

import com.glu.wxApp.domain.MedicineRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRecordMapper {

    void addMedicineRecord (@Param("medicineRecord") MedicineRecord medicineRecord);

    List<MedicineRecord> findMedicineRecord(@Param("medicineRecord") MedicineRecord medicineRecord);

    void updateMedicineRecord (@Param("medicineRecordOld") MedicineRecord medicineRecordOld, @Param("medicineRecordNew") MedicineRecord medicineRecordNew);

    void deleteMedicineRecord (@Param("medicineRecord") MedicineRecord medicineRecord);
}
