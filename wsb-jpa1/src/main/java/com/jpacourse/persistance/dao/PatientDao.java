package com.jpacourse.persistance.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.jpacourse.persistance.entity.PatientEntity;

public interface PatientDao extends Dao<PatientEntity, Long> {

    PatientEntity createNewVisitForPatient(Long patientId, Long doctorId, LocalDateTime visitTime, String desc);

    List<PatientEntity> getByName(String LastName);

    List<PatientEntity> getPatientsWithMoreVisitsThan(int count);

    List<PatientEntity> getPatientsRegiteredAfter(LocalDate registrationDate);
    
}
