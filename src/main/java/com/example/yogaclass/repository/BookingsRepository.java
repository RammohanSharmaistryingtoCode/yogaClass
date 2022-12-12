package com.example.yogaclass.repository;

import com.example.yogaclass.models.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.YearMonth;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long> {
    
    boolean existsByCustomerIdAndYearAndMonth(long customerId, long year, long month);

    Bookings findByCustomerIdAndYearAndMonth(long customerId, long year, long month);
}
