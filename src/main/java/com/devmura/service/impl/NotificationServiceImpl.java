package com.devmura.service.impl;

import com.devmura.entity.Auth;
import com.devmura.entity.Notification;
import com.devmura.repository.NotificationRepository;
import com.devmura.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    NotificationRepository notificationRepository;


    @Override
    public ResponseEntity<List<?>> findAll() {
        if (notificationRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(notificationRepository.findAll());
        }
    }

    @Override
    public ResponseEntity<?> findById(Integer id) {
        Optional<Notification> notification = notificationRepository.findById(id);
        if (notification.isPresent()) {
            return new ResponseEntity<>(notification, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Notification not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> save(Notification notification) {
        try {
            notificationRepository.save(notification);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(notification);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if (notificationRepository.findById(id).isPresent()) {
            notificationRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

