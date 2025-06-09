package com.jpacourse.mapper;

import java.util.List;

import com.jpacourse.dto.MedicalTreatmentTO;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;

public class MedicalTreatmentMapper {
    
    public static MedicalTreatmentTO mapToTO(final MedicalTreatmentEntity medicalTreatmentEntity)
    {
        MedicalTreatmentTO medicalTreatment = new MedicalTreatmentTO();
        medicalTreatment.setId(medicalTreatmentEntity.getId());
        medicalTreatment.setType(medicalTreatmentEntity.getType());
        return medicalTreatment;
    }

    public static List<MedicalTreatmentTO> mapListToTO(final List<MedicalTreatmentEntity> medicalTreatmentEntities)
    {
        List<MedicalTreatmentTO> list = medicalTreatmentEntities.stream().map(medicalTreatmentEntity -> MedicalTreatmentMapper.mapToTO(medicalTreatmentEntity)).toList();
        return list;
    }

    public static MedicalTreatmentEntity mapToEntity(final MedicalTreatmentTO medicalTreatment)
    {
        MedicalTreatmentEntity medicalTreatmentEntity = new MedicalTreatmentEntity();
        medicalTreatmentEntity.setId(medicalTreatment.getId());
        medicalTreatmentEntity.setType(medicalTreatment.getType());
        return medicalTreatmentEntity;
    }

    public static List<MedicalTreatmentEntity> mapListToEntity(final List<MedicalTreatmentTO> medicalTreatments)
    {
        List<MedicalTreatmentEntity> list = medicalTreatments.stream().map(medicalTreatment -> MedicalTreatmentMapper.mapToEntity(medicalTreatment)).toList();
        return list;
    }
    
}
