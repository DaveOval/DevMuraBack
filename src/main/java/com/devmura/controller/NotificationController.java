package com.devmura.controller;

import com.devmura.entity.Notification;
import com.devmura.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
@CrossOrigin(origins = "*")

public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<?>> getNotifications(){
        return notificationService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> saveNotification(@RequestBody Notification notification){
        return notificationService.save(notification);
    }

}
