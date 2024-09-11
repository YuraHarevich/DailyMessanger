package ru.Harevich.Messanger.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="MYUSER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2,max = 20,message = "wrong username size")
    private String username;

    @Email
    private String email;

    @Size(min=5,max =60,message = "wrong password size")
    private String password;

    private String role;
}
