package com.example.bills.billspayment_demo.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Biller {
    private Long billerID;
    private String billerName;
}
