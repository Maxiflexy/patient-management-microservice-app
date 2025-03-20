package com.maxiflexy.patientservice.service;

import com.maxiflexy.patientservice.dto.request.PatientRequestDTO;
import com.maxiflexy.patientservice.dto.response.PatientResponseDTO;
import com.maxiflexy.patientservice.mapper.PatientMapper;
import com.maxiflexy.patientservice.model.Patient;
import com.maxiflexy.patientservice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;

    @Override
    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(PatientMapper::toDTO).toList();
    }

    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        var newPatient = patientRepository.save(PatientMapper.toPatientModel(patientRequestDTO));

        return PatientMapper.toDTO(newPatient);
    }
}
