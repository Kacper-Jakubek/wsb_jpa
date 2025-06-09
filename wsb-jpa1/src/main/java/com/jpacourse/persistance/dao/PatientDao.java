package com.jpacourse.persistance.dao;

import java.time.LocalDateTime;

import com.jpacourse.persistance.entity.PatientEntity;

public interface PatientDao extends Dao<PatientEntity, Long> {

    PatientEntity createNewVisitForPatient(Long patientId, Long doctorId, LocalDateTime visitTime, String desc);
    
}
