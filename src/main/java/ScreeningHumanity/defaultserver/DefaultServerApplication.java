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
//                @Server(url = "http://localhost:8080", description = "Local Test Server URL"),
//                @Server(url = "https://{domain}", description = "Server URL")
//        }
//)
public class DefaultServerApplication {
    //todo : 유레카 서버 등록되는거 확인 필요. + healthCheck 확인;

    public static void main(String[] args) {
        SpringApplication.run(DefaultServerApplication.class, args);
    }

}
