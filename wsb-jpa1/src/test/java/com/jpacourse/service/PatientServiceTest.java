package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.dao.VisitDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.enums.TreatmentType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

@SpringBootTest
public class PatientServiceTest
{
    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private VisitDao visitDao;

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given
        // when
        PatientTO patient = patientService.findById(901L);
        // then
        assertThat(patient).isNotNull();
        assertThat(patient.getFirstName()).isEqualTo("Piotr");
        assertThat(patient.isMarried()).isEqualTo(true);
        assertThat(patient.getFinishedVisits().get(0).getTime()).isEqualTo(LocalDateTime.of(2025, 3, 13, 17, 10, 10));
        assertThat(patient.getFinishedVisits().get(0).getDoctor().getLastName()).isEqualTo("Kowalski");
        assertThat(patient.getFinishedVisits().get(0).getMedicalTreatments().get(0).getType()).isEqualTo(TreatmentType.EKG);
    }

    @Transactional
    @Test
    public void testShouldDeletePatientAndVisitsById() {
        // given
        // when
        patientService.delete(901L);
        PatientTO patient = patientService.findById(901L);
        DoctorEntity doctor = doctorDao.findOne(901L);
        VisitEntity visit = visitDao.findOne(234L);
        // then
        assertThat(patient).isNull();
        assertThat(visit).isNull();
        assertThat(doctor).isNotNull();
        assertThat(doctor.getFirstName()).isEqualTo("Jan");
        assertThat(doctor.getLastName()).isEqualTo("Kowalski");

    }
}
