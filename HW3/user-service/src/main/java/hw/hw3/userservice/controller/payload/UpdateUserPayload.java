package hw.hw3.userservice.controller.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public record UpdateUserPayload (

        @NotNull(message = "{userr.users.create.errors.username_is_null}")
        @Size(min = 3, max = 50, message = "{userr.users.create.errors.username_is_invalid}")
        String username,

        String userEmail){
}
