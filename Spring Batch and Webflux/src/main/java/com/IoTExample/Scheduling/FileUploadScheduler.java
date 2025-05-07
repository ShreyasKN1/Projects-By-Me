package com.IoTExample.Scheduling;

import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class FileUploadScheduler {
    

    public final WebClient webClient;

    public FileUploadScheduler(WebClient.Builder webClientBuilder)
    {
        this.webClient=webClientBuilder.baseUrl("http://localhost:9191").build();
    }

    @Scheduled(cron="0 0 10 * * ?")
    public void uploadFile(){
        //How it works is we need to upload file everyday before 10 so that it can do work with that new file
        FileSystemResource file = new FileSystemResource("/uploads/stocks.csv");
        if(!file.exists())
        {
            System.out.println("No file in directory");
            return;
        }

        LinkedMultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();
        formData.add("file", file);

        webClient.post()
        .uri("/api/stocks/uploads/new")
        .bodyValue(formData)
        .retrieve()
        .bodyToMono(String.class)
        .doOnNext(response -> System.out.println("Scheduled Upload Response: " + response))
        .doOnError(error -> System.err.println("Upload failed: " + error.getMessage()))
        .subscribe();

    }
}
