package com.crymuzz.arquitecturahexagonaltasks.infrastructure.adapter;

import com.crymuzz.arquitecturahexagonaltasks.domain.model.AdditionalTaskInfo;
import com.crymuzz.arquitecturahexagonaltasks.domain.ports.out.ExternalServicePort;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        String API_URL_TODO = "https://jsonplaceholder.typicode.com/todos/" + taskId;
        ResponseEntity<JsonPlaceHolderTodo> response = restTemplate.getForEntity(API_URL_TODO,
                JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo body = response.getBody();
        if (body == null) {
            return null;
        }

        String API_URL_USER = "https://jsonplaceholder.typicode.com/users/" + body.id;
        ResponseEntity<JsonPlaceHolderUser> responseUser = restTemplate.getForEntity(API_URL_USER, JsonPlaceHolderUser.class);
        JsonPlaceHolderUser bodyUser = responseUser.getBody();
        if (bodyUser == null) {
            return null;
        }
        return new AdditionalTaskInfo(bodyUser.id, bodyUser.name, bodyUser.email);
    }


    private static class JsonPlaceHolderTodo {
        private Long id;
        private Long userId;
    }


    private static class JsonPlaceHolderUser {
        private Long id;
        private String name;
        private String email;
    }

}
