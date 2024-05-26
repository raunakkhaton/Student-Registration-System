package com.rounak.hw1.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ModifyFeePaymentRequest {
    private int studentId;
    private int feeDetailsId;
}
