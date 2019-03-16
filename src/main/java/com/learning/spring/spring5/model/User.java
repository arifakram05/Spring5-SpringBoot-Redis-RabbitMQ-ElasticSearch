package com.learning.spring.spring5.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@ToString
@Document(indexName = "users", type = "user")
public class User {

    @Getter
    @Setter
    @Id
    private String userId;
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;

}
