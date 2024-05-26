package com.rounak.hw1.service;

import com.rounak.hw1.model.dto.StaffDto;
import com.rounak.hw1.model.request.AddStaffRequest;
import com.rounak.hw1.model.request.ModifyStaffRequest;

import java.util.List;

public interface StaffService {
    List<StaffDto> getAllStaffs();
    StaffDto addStaff(AddStaffRequest addStaffRequest);
    StaffDto updateStaff(Integer id, ModifyStaffRequest modifyStaffRequest);
    void deleteStaff(Integer id);
}
