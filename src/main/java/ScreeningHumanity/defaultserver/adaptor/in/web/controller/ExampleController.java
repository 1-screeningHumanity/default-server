package ScreeningHumanity.defaultserver.adaptor.in.web.controller;

import ScreeningHumanity.defaultserver.adaptor.in.web.vo.RequestExampleVo;
import ScreeningHumanity.defaultserver.application.port.in.usecase.ExampleUseCase;
import ScreeningHumanity.defaultserver.application.port.in.usecase.ExampleUseCase.SaveExampleDto;
import ScreeningHumanity.defaultserver.application.port.out.dto.ExampleDto;
import ScreeningHumanity.defaultserver.global.common.exception.BaseErrorCode;
import ScreeningHumanity.defaultserver.global.common.exception.CustomException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/example-service")
@Slf4j
@Tag(name = "Example API", description = "예시용 API")
public class ExampleController {

    private final DiscoveryClient discoveryClient;
    private final ExampleUseCase exampleUseCase;
    private final Environment env;

    @Operation(summary = "example api", description = "예제 API 호출")
    @GetMapping
    public String example() {
        return "Good! Example API Success!!";
    }

    @Operation(summary = "save example api", description = "저장 예제 API 호출")
    @PostMapping("/save")
    public ExampleDto saveExample(
            @RequestBody RequestExampleVo requestExampleVo
    ) {
        ExampleDto exampleDto = exampleUseCase.SaveExample(
                SaveExampleDto.toDtoFrom(requestExampleVo));

        throw new CustomException(BaseErrorCode.INTERNAL_SERVER_ERROR);
//        return exampleDto;
    }


    /**
     * Health Check 해당 서비스 상태 확인
     * 유레카 서버로부터 등록된 모든 instance 를 가져온다.
     * 이후, 등록된 서비스의 상태를 logging 처리 하고, return 한다.
     */
    @Operation(summary = "health check", description = "해당 서비스의 상태를 확인합니다.")
    @GetMapping("/health_check")
    public String status() {
        List<ServiceInstance> serviceList = getApplications();
        for (ServiceInstance instance : serviceList) {
            log.info("instanceId:{}, serviceId:{}, host:{}, scheme:{}, uri:{}",
                    instance.getInstanceId(),
                    instance.getServiceId(),
                    instance.getHost(),
                    instance.getScheme(),
                    instance.getUri());
        }

        return String.format("It's Working in Example Service on LOCAL PORT %s (SERVER PORT %s)",
                env.getProperty("local.server.port"),
                env.getProperty("server.port"));
    }

    private List<ServiceInstance> getApplications() {
        List<String> services = this.discoveryClient.getServices();
        List<ServiceInstance> instances = new ArrayList<ServiceInstance>();
        services.forEach(serviceName -> {
            this.discoveryClient.getInstances(serviceName).forEach(instance -> {
                instances.add(instance);
            });
        });
        return instances;
    }
}
