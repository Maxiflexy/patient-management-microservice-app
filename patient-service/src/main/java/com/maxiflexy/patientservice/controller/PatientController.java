package com.maxiflexy.patientservice.controller;

import com.maxiflexy.patientservice.dto.request.PatientRequestDTO;
import com.maxiflexy.patientservice.dto.response.PatientResponseDTO;
import com.maxiflexy.patientservice.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatients(){
        var patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> createPatient(
            @Valid @RequestBody
            PatientRequestDTO patientRequestDTO){

        return ResponseEntity.ok().body(patientService.createPatient(patientRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id,
        @RequestBody PatientRequestDTO patientRequestDTO){

        return ResponseEntity.ok().body(patientService.updatePatient(id, patientRequestDTO));
    }

}
