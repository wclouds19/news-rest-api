package bootcamp.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotEmpty(message="Name is required")
    @Size(message="Name only max 200 characters", max = 200)
    private String name;

    @NotEmpty(message="Email is required")
    @Size(message="Email only max 50 characters", max = 50)
    @Email(message="Email Format is not valid")
    private String email;
    
    @NotEmpty(message="Password is required")
    @Size(message="Password only max 20 characters", max = 20)
    private String password;

    @NotEmpty(message="Phone Number is required")
    @Size(message="Phone Number only max 13 digit", max = 13)
    @Pattern(regexp="(^$|[0-9]{10})", message="Phone Number only number")
    private Long phone_number;

    @NotEmpty(message="Roles is required")
    @Size(message="Roles only max 30 characters", max = 30)
    private String roles;
    
}
