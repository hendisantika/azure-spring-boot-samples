package com.hendisantika.azurespringbootsamples.repository;

import com.hendisantika.azurespringbootsamples.entity.User;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : azure-spring-boot-samples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-05
 * Time: 06:02
 */
@Repository
public interface UserRepository extends CosmosRepository<User, String> {
}