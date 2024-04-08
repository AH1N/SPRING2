package hw.hw3.userapp.controller.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * The type Update user payload.
 * класс для DTO вместо простого создания класса
 * NotNull и Size - для валидации данных
 */
public record UpdateUserPayload (

        @NotNull(message = "{userr.users.create.errors.username_is_null}")
        @Size(min = 3, max = 50, message = "{userr.users.create.errors.username_is_invalid}")
        String username,

        String userEmail){
}
