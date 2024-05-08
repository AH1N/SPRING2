package hw.hw6.userapp.config;

import hw.hw6.userapp.client.RestClientUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

/**
 * The type Client beans.
 */
@Configuration
public class ClientBeans {

    /**
     * Client rest user rest client user.
     * Конструктор RestClient настроен так, чтобы использовать базовый URL из userServiceBaseUri
     * @param userServiceBaseUri базовый адрес для всех запросов к API
     * @return the rest client user
     */
    @Bean
    public RestClientUser clientRestUser(@Value("${usersapp.service.hw3.uri:http://localhost:8081}") String userServiceBaseUri){
        return new RestClientUser(RestClient.builder()
                .baseUrl(userServiceBaseUri)
                .build());
    }
}

