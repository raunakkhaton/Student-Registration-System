package com.rounak.hw1.controller;

import com.rounak.hw1.model.dto.StaffDto;
import com.rounak.hw1.model.entity.Staff;
import com.rounak.hw1.model.request.AddStaffRequest;
import com.rounak.hw1.model.request.ModifyStaffRequest;
import com.rounak.hw1.service.StaffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staffs")
public class StaffController {
    private StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public ResponseEntity<List<StaffDto>> getAllStaffs() {
        return  new ResponseEntity<>(staffService.getAllStaffs(), HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<StaffDto> addStaff(@RequestBody AddStaffRequest addStaffRequest) {
        return new ResponseEntity<>(staffService.addStaff(addStaffRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StaffDto> updateStaff(@PathVariable("id") Integer id,
                                                @RequestBody ModifyStaffRequest modifyStaffRequest) {
        StaffDto staffDto = staffService.updateStaff(id, modifyStaffRequest);
        return ResponseEntity.ok(staffDto);
    }

    @DeleteMapping
    public ResponseEntity<StaffDto> deleteStaff(@PathVariable("id") Integer id) {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
}
