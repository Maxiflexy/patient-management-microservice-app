package com.maxiflexy.patientservice.service;

import com.maxiflexy.patientservice.dto.request.PatientRequestDTO;
import com.maxiflexy.patientservice.dto.response.PatientResponseDTO;

import java.util.List;

public interface PatientService {
    List<PatientResponseDTO> getPatients();
    PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO);
}
