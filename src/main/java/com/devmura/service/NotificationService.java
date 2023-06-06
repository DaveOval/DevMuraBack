package com.devmura.service;

import com.devmura.entity.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    void save(Notification notification);
    void delete(Integer id);
    Optional<Notification> findById(Integer id);
    List<Notification> getAll();
}
