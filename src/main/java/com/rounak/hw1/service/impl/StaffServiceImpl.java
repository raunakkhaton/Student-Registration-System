package com.rounak.hw1.service.impl;

import com.rounak.hw1.mapper.StaffMapper;
import com.rounak.hw1.model.dto.StaffDto;
import com.rounak.hw1.model.entity.Staff;
import com.rounak.hw1.model.request.AddStaffRequest;
import com.rounak.hw1.model.request.ModifyStaffRequest;
import com.rounak.hw1.repository.StaffRepository;
import com.rounak.hw1.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    private StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }


    @Override
    public List<StaffDto> getAllStaffs() {
        List<Staff> staff = staffRepository.findAll();
        if (staff.size() == 0) {
            return Collections.emptyList();
        }

        List<StaffDto> staffDtos = new ArrayList<StaffDto>();
        for (int i = 0; i < staff.size(); i++) {
            Staff s = staff.get(i);
            StaffDto staffDto = StaffMapper.mapToStaffDto(s);
            staffDtos.add(staffDto);
        }

        return staffDtos;
    }

    @Override
    public StaffDto addStaff(AddStaffRequest addStaffRequest) {
        Staff staff = StaffMapper.mapToStaff(addStaffRequest);
        staff = staffRepository.save(staff);
        return StaffMapper.mapToStaffDto(staff);
    }


    @Override
    public StaffDto updateStaff(Integer id, ModifyStaffRequest modifyStaffRequest) {
        Staff staff = staffRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Staff not found")
        );
        staff.setDepartment(modifyStaffRequest.getDepartment());
        staff.setName(modifyStaffRequest.getName());
        Staff savedStaff = staffRepository.save(staff);
        return StaffMapper.mapToStaffDto(savedStaff);
    }

    @Override
    public void deleteStaff(Integer id) {
        Staff staff = staffRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        staffRepository.delete(staff);
    }
}
