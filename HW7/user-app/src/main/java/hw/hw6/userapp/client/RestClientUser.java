package hw.hw6.userapp.client;

import hw.hw6.userapp.dto_userapp.NewUserPayload;
import hw.hw6.userapp.dto_userapp.UpdateUserPayload;
import hw.hw6.userapp.entity.Userr;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;


/**
 * "Прослойка" - которая связывает API и клиент
 *  реализация клиентской части для взаимодействия с REST API
 */
@RequiredArgsConstructor
public class RestClientUser implements UserRestClient{

    private final ParameterizedTypeReference<List<Userr>> USERS_TYPE_REFERENCE =
            new ParameterizedTypeReference<>(){
            };

    private final RestClient restClient;

    @Override
    public List<Userr> findAllUsers() {
        return this.restClient
                .get()
                .uri("/userr-api/users")
                .retrieve()
                .body(USERS_TYPE_REFERENCE);
    }

    @Override
    public Userr createUser(String username, String userEmail) {
        return this.restClient
                .post()
                .uri("/userr-api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new NewUserPayload(username, userEmail))
                .retrieve()
                .body(Userr.class);
    }

    @Override
    public Optional<Userr> findUser(int userId) {
        return Optional.ofNullable(this.restClient.get()
                .uri("/userr-api/users/{userId}", userId)
                .retrieve()
                .body(Userr.class));
    }

    @Override
    public void updateUser(int userId, String username, String userEmail) {
        this.restClient
                .patch()
                .uri("/userr-api/users/{userId}", userId)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new UpdateUserPayload(username, userEmail))
                .retrieve()
                .toBodilessEntity();
    }

    @Override
    public void deleteUser(int userId) {
        this.restClient
                .delete()
                .uri("/userr-api/users/{userId}", userId)
                .retrieve()
                .toBodilessEntity();
    }
}
