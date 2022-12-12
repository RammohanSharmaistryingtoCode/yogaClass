package com.example.yogaclass.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBookingDTO {
    public long customerId;
    public long month;
    public long year;
    public long classId;
    public boolean newBooking;
    public boolean transaction;
}
