package HW.HW4.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * The type New user payload.
 * Класс DTO для трансфера данных о создаваемом новом пользователе
 */
public record NewUserPayload(

//        @NotNull(message = "{userr.users.create.errors.username_is_null}")
//        @Size(min = 3, max = 50, message = "{userr.users.create.errors.username_is_invalid}")
        String username,

        String userEmail)  {
}
