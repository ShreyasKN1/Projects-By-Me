package com.IoTExample.service;

import java.io.IOException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import reactor.core.publisher.Mono;
import java.nio.file.*;

@Service
public class StockBatchService {


    @Value("${file.upload-dir}")
    private String uploadDir;

    private JobLauncher joblauncher;
    
    private Job job;


    StockBatchService(JobLauncher joblauncher,Job job)
    {
        this.joblauncher=joblauncher;
        this.job=job;
    }

    //since we are uploading one file at a time so for that we use mono and return mono obj
    public Mono<String> handleFileUpload(MultipartFile file) {
        try {
            Path path = Paths.get(uploadDir, file.getOriginalFilename());
            System.out.println("Saving file to: " + path.toAbsolutePath());

            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());

    
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("filePath", path.toAbsolutePath().toString())
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
    
                    joblauncher.run(job, jobParameters);
    
            return Mono.just("Batch Job triggered");
        } catch (IOException | JobExecutionException e) {
            return Mono.error(e);
        }
    }
    
}
