package org.hoanguyen.register.dto;
<<<<<<< HEAD
import jakarta.validation.constraints.*;
=======
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
>>>>>>> 067d4aa9f30180f12c718988c5537b6ecf6ffe73
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
public class AccountDTO {
//    @NotEmpty(message = "Can't be empty string")
<<<<<<< HEAD

    private int acNumber;

    @NotNull(message = "Balance can't be null")
    @Positive(message = "Balance must be a positive number")
=======
    @Size(max = 100)
    private int acNumber;
    @Size(max = 100)
    @NotEmpty(message = "Can't be empty string")
    @NotBlank
>>>>>>> 067d4aa9f30180f12c718988c5537b6ecf6ffe73
    private Double balance;

}
