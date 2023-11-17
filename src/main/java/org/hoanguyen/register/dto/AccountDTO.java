package org.hoanguyen.register.dto;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
public class AccountDTO {
//    @NotEmpty(message = "Can't be empty string")

    private int acNumber;

    @NotNull(message = "Balance can't be null")
    @Positive(message = "Balance must be a positive number")
    private Double balance;

}
