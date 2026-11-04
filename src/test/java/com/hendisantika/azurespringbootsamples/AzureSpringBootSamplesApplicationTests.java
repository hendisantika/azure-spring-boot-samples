package com.hendisantika.azurespringbootsamples;

import com.hendisantika.azurespringbootsamples.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest(properties = "spring.cloud.azure.cosmos.enabled=false")
class AzureSpringBootSamplesApplicationTests {

    @MockitoBean
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }

}
