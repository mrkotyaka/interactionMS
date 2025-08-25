package ru.mrkotyaka.userms.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mrkotyaka.userms.models.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final Map<Long, User> users = new ConcurrentHashMap<>();

    public UserController() {
        users.put(1L, new User(1L, "Иван Иванов", "г. Москва, ул. Пушкина, д. 10", "+7 900 123-45-67", "ivanov@example.com"));
        users.put(2L, new User(2L, "Петр Петров", "г. Санкт-Петербург, Невский пр., 1", "+7 901 222-33-44", "petrov@example.com"));
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return users.getOrDefault(userId, new User(userId, "Unknown", "-", "-", "-"));
    }
}
