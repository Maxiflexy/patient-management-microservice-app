package com.maxiflexy.patientservice.mapper;

import com.maxiflexy.patientservice.dto.response.PatientResponseDTO;
import com.maxiflexy.patientservice.model.Patient;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient){
        var patientResponseDTO = new PatientResponseDTO();
        //patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setName(patient.getName());

        return patientResponseDTO;
//        return PatientResponseDTO.builder()
//                .id(patient.getId().toString())
//                .name(patient.getName())
//                .address(patient.getAddress())
//                .email(patient.getEmail())
//                .dateOfBirth(patient.getDateOfBirth().toString())
//                .build();
    }
}
