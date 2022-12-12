package com.example.yogaclass.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.YearMonth;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bookings {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;
    private long customerId;
    private long classId;
    private long month;
    private long year;

    public void setClassId(long classId) {
        this.classId = classId;
    }
}
