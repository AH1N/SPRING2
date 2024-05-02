package HW.HW5.DTO;

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
