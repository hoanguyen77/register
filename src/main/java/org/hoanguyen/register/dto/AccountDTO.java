package org.hoanguyen.register.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
public class AccountDTO {
//    @NotEmpty(message = "Can't be empty string")
    @Size(max = 100)
    private int acNumber;
    @Size(max = 100)
    @NotEmpty(message = "Can't be empty string")
    @NotBlank
    private Double balance;

}
