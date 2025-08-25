package ru.mrkotyaka.bffms.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String email;
}
