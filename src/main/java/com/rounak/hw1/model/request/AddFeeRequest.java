package com.rounak.hw1.model.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddFeeRequest {
    private int courseId;
    private double amount;
}
