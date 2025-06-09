package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.AddressEntity;
import com.jpacourse.persistance.entity.PatientEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class PatientDaoTest
{
    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given
        // when
        PatientEntity patientEntity = patientDao.findOne(901L);
        // then
        assertThat(patientEntity).isNotNull();
        assertThat(patientEntity.getFirstName()).isEqualTo("Piotr");
    }

    @Transactional
    @Test
    public void testShouldSavePatient() {
        // given
        PatientEntity patientEntity = new PatientEntity();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(901L);
        patientEntity.setAddress(addressEntity);
        patientEntity.setFirstName("line1");
        patientEntity.setLastName("line2");
        patientEntity.setPatientNumber("line3");
        patientEntity.setTelephoneNumber("+48123456789");
        patientEntity.setEmail("email@email.com");
        patientEntity.setDateOfBirth(LocalDate.now());
        patientEntity.setMarried(true);
        long entitiesNumBefore = patientDao.count();

        // when
        final PatientEntity saved = patientDao.save(patientEntity);

        // then
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(patientDao.count()).isEqualTo(entitiesNumBefore+1);
    }

    @Transactional
    @Test
    public void testShouldSaveAndRemovePatient() {
        // given
        PatientEntity patientEntity = new PatientEntity();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(901L);
        patientEntity.setAddress(addressEntity);
        patientEntity.setFirstName("line1");
        patientEntity.setLastName("line2");
        patientEntity.setPatientNumber("line3");
        patientEntity.setTelephoneNumber("+48123456789");
        patientEntity.setEmail("email@email.com");
        patientEntity.setDateOfBirth(LocalDate.now());
        patientEntity.setMarried(true);

        // when
        final PatientEntity saved = patientDao.save(patientEntity);
        assertThat(saved.getId()).isNotNull();
        final PatientEntity newSaved = patientDao.findOne(saved.getId());
        assertThat(newSaved).isNotNull();

        patientDao.delete(saved.getId());

        // then
        final PatientEntity removed = patientDao.findOne(saved.getId());
        assertThat(removed).isNull();
    }

    @Transactional
    @Test
    public void testShouldAddNewVisitToPatient() {
        // given

        // when
        final PatientEntity patientWithNewVisit = patientDao.createNewVisitForPatient(901L,901L,LocalDateTime.of(2025, 8, 12, 0, 0, 0, 0), "opis nowej wizyty");
        System.out.println(patientWithNewVisit.toString());
        // then
        assertThat(patientWithNewVisit).isNotNull();
        assertThat(patientWithNewVisit.getFirstName()).isEqualTo("Piotr");
        assertThat(patientWithNewVisit.getVisits().get(0).getDescription()).isEqualTo("opis nowej wizyty");
        assertThat(patientWithNewVisit.getVisits().get(0).getDoctor().getFirstName()).isEqualTo("Jan");
    }
}
