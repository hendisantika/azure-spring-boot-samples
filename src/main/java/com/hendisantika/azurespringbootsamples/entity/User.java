package com.hendisantika.azurespringbootsamples.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : azure-spring-boot-samples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-05
 * Time: 05:50
 */
@Container(containerName = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String address;

    @Override
    public String toString() {
        return String.format("%s %s, %s", firstName, lastName, address);
    }
}