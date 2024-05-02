package ScreeningHumanity.defaultserver;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaAuditing
//@OpenAPIDefinition(
//        servers = {
//                @Server(url = "http://localhost:8282", description = "Local Test Server URL"),
//                @Server(url = "https://sssg.shop", description = "Server URL")
//        }
//)
public class DefaultServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DefaultServerApplication.class, args);
    }

}
