package com.rounak.hw1.mapper;

import com.rounak.hw1.model.dto.StaffDto;
import com.rounak.hw1.model.entity.Staff;
import com.rounak.hw1.model.request.AddStaffRequest;


public class StaffMapper {


    public static Staff mapToStaff(AddStaffRequest addStaffRequest) {
        Staff staff = new Staff();
        staff.setDepartment(addStaffRequest.getDepartment());
        staff.setName(addStaffRequest.getName());
        return staff;
    }

    public static StaffDto mapToStaffDto(Staff staff) {
        StaffDto staffDto = new StaffDto();
        staffDto.setDepartment(staff.getDepartment());
        staffDto.setName(staff.getName());
        return staffDto;
    }


}
