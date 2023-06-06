package com.devmura.service.impl;

import com.devmura.entity.Notification;
import com.devmura.repository.NotificationRepository;
import com.devmura.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    NotificationRepository notificationRepository;


    @Override
    public void save(Notification notification) { notificationRepository.save(notification);

    }

    @Override
    public void delete(Integer id) { notificationRepository.deleteById(id);

    }

    @Override
    public Optional<Notification> findById(Integer id) {
        return notificationRepository.findById(id);
    }

    @Override
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }
}

