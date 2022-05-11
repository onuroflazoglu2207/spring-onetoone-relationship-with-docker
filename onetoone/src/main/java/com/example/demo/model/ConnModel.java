package com.example.demo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "conn")
public class ConnModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long identity;

    @Email(message = "Unacceptable email address!")
    String username;

    @NotBlank(message = "Password cannot be blank!")
    String password;

    @OneToOne(mappedBy = "conn")
    UserModel user;
}
