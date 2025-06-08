package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientServiceTest
{
    @Autowired
    private PatientService patientService;

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given
        // when
        PatientTO patient = patientService.findById(901L);
        // then
        assertThat(patient).isNotNull();
        assertThat(patient.getFirstName()).isEqualTo("Piotr");
    }
}
