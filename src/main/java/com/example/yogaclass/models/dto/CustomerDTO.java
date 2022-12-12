package com.example.yogaclass.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    public String name;
    public long age;
    public long month;
    public long year;
    public long classId;
    public boolean transaction;
}
