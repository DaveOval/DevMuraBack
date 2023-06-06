package com.devmura.repository;

import com.devmura.entity.Group;
import com.devmura.entity.Notification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class NotificationRepositoryTest {
    @Autowired
    NotificationRepository notificationRepository;

    @Test
    public void testFindAll(){
        List<Notification> notifications = notificationRepository.findAll();
        notifications.forEach(System.out::println);
    }
}
