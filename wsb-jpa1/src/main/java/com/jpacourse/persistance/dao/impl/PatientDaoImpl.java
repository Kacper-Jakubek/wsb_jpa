package com.jpacourse.persistance.dao.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.dao.VisitDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private VisitDao visitDao;

    @Override
    public PatientEntity createNewVisitForPatient(Long patientId, Long doctorId, LocalDateTime visitTime, String desc) {
        PatientEntity patient = getOne(patientId);
        DoctorEntity doctor = doctorDao.getOne(doctorId);
        VisitEntity visit = new VisitEntity();
        visit.setDoctor(doctor);
        visit.setPatient(patient);
        visit.setTime(visitTime);
        visit.setDescription(desc);
        visitDao.save(visit);
        return getOne(patientId);
    }
}
