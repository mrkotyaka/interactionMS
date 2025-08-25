package ru.mrkotyaka.bffms.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.mrkotyaka.bffms.models.Order;
import ru.mrkotyaka.bffms.models.User;
import ru.mrkotyaka.bffms.models.UserProfile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/site-bff")
public class BffController {

    private final RestTemplate restTemplate;
    private final String userServiceBaseUrl;
    private final String orderServiceBaseUrl;

    public BffController(RestTemplate restTemplate,
                         @Value("${user.service.base-url}") String userServiceBaseUrl,
                         @Value("${order.service.base-url}") String orderServiceBaseUrl) {
        this.restTemplate = restTemplate;
        this.userServiceBaseUrl = userServiceBaseUrl;
        this.orderServiceBaseUrl = orderServiceBaseUrl;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable Long userId) {
        User user = restTemplate.getForObject(userServiceBaseUrl + "/api/users/" + userId, User.class);
        Order[] ordersArr = restTemplate.getForObject(orderServiceBaseUrl + "/api/orders/by-user/" + userId, Order[].class);
        List<Order> orders = ordersArr != null ? Arrays.asList(ordersArr) : List.of();
        UserProfile profile = new UserProfile(user, orders);
        return ResponseEntity.ok(profile);
    }
}
