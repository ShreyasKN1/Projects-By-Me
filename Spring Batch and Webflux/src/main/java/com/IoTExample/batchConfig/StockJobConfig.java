package com.IoTExample.batchConfig;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.IoTExample.entity.Stock;
import com.IoTExample.repository.StockDataRepository;

@Configuration
public class StockJobConfig {


    @Bean
    @StepScope
    public FlatFileItemReader<Stock> reader(@Value("#{jobParameters['filePath']}") String path)
    {
        FlatFileItemReader<Stock> reader=new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(path));
        reader.setLinesToSkip(1);

        DefaultLineMapper<Stock> linemapper=new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
        lineTokenizer.setNames("stockId","stockName","marketCap","profitOrLoss","lastUpdated");
        lineTokenizer.setDelimiter(",");


        //Can also use beanwrappedfieldsetmapper
        FieldSetMapper<Stock> fieldSetMapper=fieldSet->{
            Stock stock=new Stock();
            stock.setStockName(fieldSet.readString("stockName"));
            stock.setProfitOrLoss(fieldSet.readString("profitOrLoss"));
            return stock;
        };


        linemapper.setLineTokenizer(lineTokenizer);
        linemapper.setFieldSetMapper(fieldSetMapper);
        reader.setLineMapper(linemapper);
        return reader;
    }

    @Bean
    public StockProcessor stockprocessor(){
        return new StockProcessor();
    }


    @Bean
    public RepositoryItemWriter<Stock> writer(StockDataRepository repository)
    {
        RepositoryItemWriter<Stock> writer=new RepositoryItemWriter<>();
        writer.setRepository(repository);
        writer.setMethodName("save");
        return writer;
    }


    @Bean
    public Step stockStep(JobRepository jobRepository, PlatformTransactionManager transactionManager, FlatFileItemReader<Stock> reader, StockProcessor stockprocessor, RepositoryItemWriter<Stock> writer    ){
        return new StepBuilder("stock-step",jobRepository).<Stock,Stock>chunk(10,transactionManager)
        .reader(reader)
        .processor(stockprocessor)
        .writer(writer)
        .build();
    }


    @Bean
    public Job stockJob(JobRepository jobRepository, Step stockStep){
        return new JobBuilder("stock-job",jobRepository).start(stockStep).build();
    }

    
}