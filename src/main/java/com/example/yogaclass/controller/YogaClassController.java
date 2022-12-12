package com.example.yogaclass.controller;

import com.example.yogaclass.commons.YogaClassesResponse;
import com.example.yogaclass.models.dto.ClassesDto;
import com.example.yogaclass.models.dto.CustomerBookingDTO;
import com.example.yogaclass.models.dto.CustomerDTO;
import com.example.yogaclass.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class YogaClassController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/booking")
    public YogaClassesResponse saveBooking(@RequestBody CustomerDTO customerDTO) {
        try {
            log.info(String.valueOf(customerDTO.transaction));
            return bookingService.bookSlot(customerDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new YogaClassesResponse(false, "Some error occurred while booking class on our side");
        }
    }


    @PostMapping("/booking/existingCustomer")
    public YogaClassesResponse saveBookingExistingCustomer(@RequestBody CustomerBookingDTO customerBookingDTO) {
        try {
            return bookingService.bookSlotExistingCustomer(customerBookingDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new YogaClassesResponse(false, "Some error occurred while booking class on our side");
        }
    }


    @PostMapping("/verify/existingCustomer")
    public YogaClassesResponse verifyCustomerDetails(@RequestBody CustomerBookingDTO customerBookingDTO) {
        try {
            return bookingService.verifyDetailsOfExistingCustomer(customerBookingDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new YogaClassesResponse(false, "Some error occurred while booking class on our side");
        }
    }

    @PostMapping("/verify")
    public YogaClassesResponse verifyCustomerDetails(@RequestBody CustomerDTO customerDTO) {
        try {
            return bookingService.verifyDetails(customerDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new YogaClassesResponse(false, "Some error occurred while booking class on our side");
        }
    }


    @PostMapping("/classes")
    public YogaClassesResponse saveClass(@RequestBody ClassesDto classesDto) {
        try {
            return bookingService.createClass(classesDto);
        } catch (Exception e) {
            return new YogaClassesResponse(false, "Error creating new class :" + e.getMessage());
        }
    }
}
