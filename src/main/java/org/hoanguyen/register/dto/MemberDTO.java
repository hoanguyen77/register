package org.hoanguyen.register.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MemberDTO {


    @NotEmpty(message = "Can't be empty")
    private String firstName;
    @NotEmpty(message = "Can't be empty")
    private String lastName;

    @Email(message = "Wrong formatting")
    @NotEmpty(message = "Can't be empty")
    private String email;

    private AccountDTO account;
    private String phoneNumber;
}
