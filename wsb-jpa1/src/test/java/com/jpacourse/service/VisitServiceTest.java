package com.jpacourse.service;

import com.jpacourse.dto.VisitTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
public class VisitServiceTest
{
    @Autowired
    private VisitService visitService;

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given
        // when
        List<VisitTO> visits = visitService.findPatientVisits(902L);
        // then
        assertThat(visits).isNotNull();
        assertThat(visits.size()).isEqualTo(3);
        assertThat(visits.get(0).getId()).isEqualTo(235);
        assertThat(visits.get(1).getId()).isEqualTo(236);
        assertThat(visits.get(2).getId()).isEqualTo(237);
    }
}
