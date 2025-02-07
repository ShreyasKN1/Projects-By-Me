package com.example.TaskManagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


// We use spring-boot-email to send and receive emails and this is for creating your mail as well as mailbody
@Service
public class EmailService {

   
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")  // fromemail from applications.properties called
    private String fromEmail;

    public void sendApprovalNotification(String to, String taskTitle) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(to);
            message.setSubject("Task Approval Request");
            message.setText("Please approve the task: " + taskTitle);

            mailSender.send(message);
            System.out.println("Email sent successfully to: " + to);
        } catch (Exception e) {
            System.err.println("Error sending email: " + e.getMessage());
        }
    }
}

