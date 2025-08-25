package ru.mrkotyaka.orderms.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mrkotyaka.orderms.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final Map<Long, List<Order>> ordersByUser = new ConcurrentHashMap<>();

    public OrderController() {
        List<Order> user1 = new ArrayList<>();
        user1.add(new Order(1L, 1L, 2500L, "RUB", List.of("Ноутбук", "Мышка")));
        user1.add(new Order(2L, 1L, 300L, "RUB", List.of("Клавиатура")));
        ordersByUser.put(1L, user1);

        List<Order> user2 = new ArrayList<>();
        user2.add(new Order(3L, 2L, 99L, "RUB", List.of("Книга", "Обложка")));
        ordersByUser.put(2L, user2);
    }

    @GetMapping("/by-user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId) {
        return ordersByUser.getOrDefault(userId, List.of());
    }
}
