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
    //todo : 유레카 서버 등록되는거 확인 필요. + healthCheck 확인;
    //todo : 공통 API 응답 값 방식 지정 필요.
    //todo : Exception Handler 처리 필요. Validation 관련 처리 사전에 필요.

    public static void main(String[] args) {
        SpringApplication.run(DefaultServerApplication.class, args);
    }

}
