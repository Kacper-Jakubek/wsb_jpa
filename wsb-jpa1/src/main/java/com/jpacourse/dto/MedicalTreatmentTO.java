package com.jpacourse.dto;

import com.jpacourse.persistance.enums.TreatmentType;

public class MedicalTreatmentTO {

    private Long id;

	private TreatmentType type;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TreatmentType getType() {
		return type;
	}

	public void setType(TreatmentType type) {
		this.type = type;
	}
    
}
