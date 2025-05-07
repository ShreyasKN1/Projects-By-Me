package com.IoTExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IoTExample.entity.Stock;

@Repository
public interface StockDataRepository extends JpaRepository<Stock,Integer>{
    
}
