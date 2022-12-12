package com.example.yogaclass.service;

import com.example.yogaclass.commons.YogaClassesResponse;
import com.example.yogaclass.models.Bookings;
import com.example.yogaclass.models.Classes;
import com.example.yogaclass.models.Customer;
import com.example.yogaclass.models.dto.ClassesDto;
import com.example.yogaclass.models.dto.CustomerBookingDTO;
import com.example.yogaclass.models.dto.CustomerDTO;
import com.example.yogaclass.repository.BookingsRepository;
import com.example.yogaclass.repository.ClassesRepository;
import com.example.yogaclass.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class BookingService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingsRepository bookingsRepository;

    @Autowired
    ClassesRepository classesRepository;


    public boolean completePayment(boolean bool) {
        return bool;
    }

    public YogaClassesResponse bookSlot(CustomerDTO customerDTO) {
        try {
            if (!completePayment(customerDTO.transaction)) {
                return new YogaClassesResponse(false, "Transaction failed");
            }
            Customer customer = Customer.builder().age(customerDTO.age).name(customerDTO.name).build();
            customerRepository.save(customer);
            Bookings booking = Bookings.builder().classId(customerDTO.classId).customerId(customer.id).year(customerDTO.year).month(customerDTO.month).build();
            bookingsRepository.save(booking);
            return new YogaClassesResponse(true, "Booking made successfully, please note down your customer Id:" + customer.id + " and booking Id:" + booking.id);
        } catch (Exception e) {
            return new YogaClassesResponse(false, "Some error occurred while verifying on our side");
        }
    }

    public YogaClassesResponse bookSlotExistingCustomer(CustomerBookingDTO customerBookingDTO) {
        try {
            if (!customerBookingDTO.newBooking) {
                Bookings booking = bookingsRepository.findByCustomerIdAndYearAndMonth(customerBookingDTO.customerId, customerBookingDTO.year, customerBookingDTO.month);
                booking.setClassId(customerBookingDTO.classId);
                bookingsRepository.save(booking);
                return new YogaClassesResponse(true, "Slot changed Successfully");
            }

            if (!completePayment(customerBookingDTO.transaction)) {
                return new YogaClassesResponse(false, "Transaction failed");
            }

            Bookings booking = Bookings.builder().classId(customerBookingDTO.classId).customerId(customerBookingDTO.customerId).year(customerBookingDTO.year).month(customerBookingDTO.month).build();
            bookingsRepository.save(booking);
            return new YogaClassesResponse(true, "Booking made successfully, please note down your customer Id:" + customerBookingDTO.customerId + " and booking Id:" + booking.id);
        } catch (Exception e) {
            return new YogaClassesResponse(false, "Some error occurred while verifying on our side");
        }
    }

    public YogaClassesResponse verifyDetailsOfExistingCustomer(CustomerBookingDTO customerBookingDTO) {
        try {
            if (!customerRepository.existsById(customerBookingDTO.customerId)) {
                return new YogaClassesResponse(false, "No customer exists with such id");
            }
            if (customerBookingDTO.newBooking && bookingsRepository.existsByCustomerIdAndYearAndMonth(customerBookingDTO.customerId, customerBookingDTO.year, customerBookingDTO.month)) {
                return new YogaClassesResponse(false, "You already have a booking for this time period, please use option for changing slot instead");
            }
            if (!customerBookingDTO.newBooking && !bookingsRepository.existsByCustomerIdAndYearAndMonth(customerBookingDTO.customerId, customerBookingDTO.year, customerBookingDTO.month)) {
                return new YogaClassesResponse(false, "You do not have a booking for this time period, please use option for new booking instead");
            }
            long currMonth = LocalDate.now().getMonthValue();
            long currYear = LocalDate.now().getYear();
            if (!customerBookingDTO.newBooking && currYear >= customerBookingDTO.year && currMonth >= customerBookingDTO.month) {
                return new YogaClassesResponse(false, "You can change slots only for future months");
            }
            return new YogaClassesResponse(true, "Customer details are valid");
        } catch (Exception e) {
            return new YogaClassesResponse(false, "Some error occurred while booking class on our side");
        }
    }

    public YogaClassesResponse createClass(ClassesDto classesDto) {
        try {
            classesRepository.save(Classes.builder().id(classesDto.id).timeSlot(classesDto.timeSlot).build());
        } catch (Exception e) {
            return new YogaClassesResponse(false, "Error creating class :" + e.getMessage());
        }
        return new YogaClassesResponse(true, "Successfully created class");
    }


    public YogaClassesResponse verifyDetails(CustomerDTO customerDTO) {
        try {
            if (customerDTO.age < 18 || customerDTO.age > 65) {
                return new YogaClassesResponse(false, "The age limitation for this class is 18 to 65");
            }
            if (customerDTO.name.length() == 0) {
                return new YogaClassesResponse(false, "Name field cant be empty");
            }
            if (customerDTO.month == 0 || customerDTO.year == 0 || customerDTO.classId == 0) {
                return new YogaClassesResponse(false, "Please select month and year and timeslot");
            }
            return new YogaClassesResponse(true, "Customer details are valid.");
        } catch (Exception e) {
            return new YogaClassesResponse(false, "Something went wrong on our end");
        }
    }

}
