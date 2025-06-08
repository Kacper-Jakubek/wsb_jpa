package com.jpacourse.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;

public class PatientMapper {
    
    public static PatientTO mapToTO(final PatientEntity patientEntity)
    {
        if (patientEntity == null)
        {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setMarried(patientEntity.isMarried());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());

        List<VisitEntity> visits = patientEntity.getVisits();

        List<VisitEntity> finishedVisits = visits.stream().filter(visit -> visit.getTime().isBefore(LocalDateTime.now())).collect(Collectors.toList());
        List<VisitTO> mappedVisits = VisitMapper.mapListToTO(finishedVisits);
        patientTO.setFinishedVisits(mappedVisits);
        return patientTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO)
    {
        if(patientTO == null)
        {
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setMarried(patientTO.isMarried());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setVisits(VisitMapper.mapListToEntity(patientTO.getFinishedVisits()));
        return patientEntity;
    }
}
