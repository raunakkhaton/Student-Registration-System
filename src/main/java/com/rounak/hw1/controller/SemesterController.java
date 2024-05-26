package com.rounak.hw1.controller;

import com.rounak.hw1.model.dto.SemesterDto;
import com.rounak.hw1.model.request.AddSemesterRequest;
import com.rounak.hw1.model.request.ModifySemesterRequest;
import com.rounak.hw1.service.SemesterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sem")
public class SemesterController {
    private SemesterService semesterService;


    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @GetMapping
    public ResponseEntity<List<SemesterDto>> getAllSemesters() {
        return new ResponseEntity<>(semesterService.getAllSemesters(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SemesterDto> addSemesterInfo(@RequestBody AddSemesterRequest addSemesterRequest) {
        return new ResponseEntity<>(semesterService.addSemesterInfo(addSemesterRequest), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SemesterDto> updateSemester(@PathVariable("id") Integer id,
                                                      @RequestBody ModifySemesterRequest modifySemesterRequest) {
        return new ResponseEntity<>(semesterService.updateSemester(id, modifySemesterRequest), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<SemesterDto> deleteSemester(@PathVariable("id") Integer id) {
        semesterService.deleteSemester(id);
        return ResponseEntity.noContent().build();
    }

}
