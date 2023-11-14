package org.hoanguyen.register.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hoanguyen.register.entity.Account;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
public class UserDTO {

    @NotEmpty(message = "Can't be empty")
    @Email(message = "Wrong formatting")
    private String email;
    @Size(min = 2, max = 40)
    @NotEmpty(message = "Please provide correct password")
    private String password;
    @NotEmpty(message = "Please provide correct password")
    private String matchingPassword;

    private String phoneNumber;

    private String role;


}