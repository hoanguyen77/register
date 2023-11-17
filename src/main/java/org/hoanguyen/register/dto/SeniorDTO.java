package org.hoanguyen.register.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SeniorDTO {
    @NotEmpty(message = "Last name must be provided")
    private String lastName;
    @NotEmpty(message = "First name must be provided")
    private String firstName;
    @Email(message = "Provide correct email")
    private String email;
}
