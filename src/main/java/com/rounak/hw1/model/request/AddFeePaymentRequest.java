package com.rounak.hw1.model.request;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class AddFeePaymentRequest {
    private int studentId;
    private int feeDetailsId;
}
