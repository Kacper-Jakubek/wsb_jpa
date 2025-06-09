package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;

import java.util.ArrayList;
import java.util.List;
import com.jpacourse.persistance.entity.VisitEntity;

public class VisitMapper {

    public static VisitTO mapToTO(final VisitEntity visitEntity)
    {
        VisitTO visit = new VisitTO();
        visit.setId(visitEntity.getId());
        visit.setTime(visitEntity.getTime());
        visit.setDoctor(DoctorMapper.mapToTO(visitEntity.getDoctor()));
        visit.setMedicalTreatments(MedicalTreatmentMapper.mapListToTO(visitEntity.getMedicalTreatments()));
        return visit;
    }

    public static List<VisitTO> mapListToTO(final List<VisitEntity> visitEntities)
    {
        List<VisitTO> list = visitEntities.stream().map(visitEntity -> VisitMapper.mapToTO(visitEntity)).toList();
        return list;
    }

    public static VisitEntity mapToEntity(final VisitTO visit)
    {
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visit.getId());
        visitEntity.setTime(visit.getTime());
        visitEntity.setDoctor(DoctorMapper.mapToEntity(visit.getDoctor()));
        visitEntity.setMedicalTreatments(MedicalTreatmentMapper.mapListToEntity(visit.getMedicalTreatments()));
        return visitEntity;
    }

    public static List<VisitEntity> mapListToEntity(final List<VisitTO> visits)
    {
        List<VisitEntity> list = visits.stream().map(visit -> VisitMapper.mapToEntity(visit)).toList();
        return list;
    }
}
