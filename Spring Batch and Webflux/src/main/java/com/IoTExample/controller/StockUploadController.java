package com.IoTExample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.IoTExample.service.StockBatchService;

import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/uploads")
public class StockUploadController {


    private StockBatchService stockBatchService;

    public StockUploadController(StockBatchService stockBatchService)
    {
        this.stockBatchService=stockBatchService;
    }
    

    @PostMapping(value="/new",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<String> uploadStockCsv(@RequestPart("file") MultipartFile file) {
        return stockBatchService.handleFileUpload(file);

    }
    
   
}
