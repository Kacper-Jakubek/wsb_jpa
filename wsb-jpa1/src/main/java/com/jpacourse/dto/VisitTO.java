package com.jpacourse.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VisitTO {

    private Long id;

	private LocalDateTime time;

	private DoctorTO doctor;

    private List<MedicalTreatmentTO> medicalTreatments = new ArrayList<>();

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public DoctorTO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorTO doctor) {
		this.doctor = doctor;
	}

	public List<MedicalTreatmentTO> getMedicalTreatments() {
		return medicalTreatments;
	}

	public void setMedicalTreatments(List<MedicalTreatmentTO> medicalTreatments) {
		this.medicalTreatments = medicalTreatments;
	}
}
