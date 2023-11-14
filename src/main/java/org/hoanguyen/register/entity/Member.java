package org.hoanguyen.register.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;

    private String email;

    private String phoneNumber;
    @OneToOne(fetch = FetchType.EAGER)
    private Account account;
    private String login;
}
