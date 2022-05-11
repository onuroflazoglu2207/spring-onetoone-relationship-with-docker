package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long identity;

    @NotBlank(message = "Name cannot be blank!")
    String name;

    @NotNull(message = "Birthday cannot be null!")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = ISO.DATE)
    LocalDate birthday;

    @NotNull(message = "Gender cannot be null!")
    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "connection") // name of db column
    ConnModel conn;
}

