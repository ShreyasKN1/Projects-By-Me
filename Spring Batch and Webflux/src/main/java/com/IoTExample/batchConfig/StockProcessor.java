package com.IoTExample.batchConfig;

import org.springframework.batch.item.ItemProcessor;

import com.IoTExample.entity.Stock;

public class StockProcessor implements ItemProcessor<Stock,Stock> {

    @Override
    public Stock process(Stock item) {
        return item;
    }
    
}
