package com.rounak.hw1.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ModifyStaffRequest {
    private String department;
    private String name;
}
