package com.common.notification_service.controller;

import com.common.notification_service.dto.OrderCreatedEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                          // (1)
@RequestMapping("/notifications")        // (2)
public class NotificationController {

    @PostMapping                         // (3)
    public ResponseEntity<Void> notify(@RequestBody OrderCreatedEvent event) { // (4)
        System.out.println("Sending notification to user " + event.userId()
                + " for order " + event.orderId());
        return ResponseEntity.ok().build();
    }
}
