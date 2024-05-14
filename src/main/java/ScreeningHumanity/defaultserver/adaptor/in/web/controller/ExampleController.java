package ScreeningHumanity.defaultserver.adaptor.in.web.controller;

import ScreeningHumanity.defaultserver.adaptor.in.web.vo.RequestVo;
import ScreeningHumanity.defaultserver.application.port.in.usecase.ExampleUseCase;
import ScreeningHumanity.defaultserver.application.port.in.usecase.ExampleUseCase.SaveExampleDto;
import ScreeningHumanity.defaultserver.application.port.out.dto.ExampleDto;
import ScreeningHumanity.defaultserver.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/example-service")
@Slf4j
@Tag(name = "Example API", description = "예시용 API")
public class ExampleController {

    private final ExampleUseCase exampleUseCase;
    private final ModelMapper modelMapper;

    @Operation(summary = "example api", description = "예제 API 호출")
    @GetMapping
    public String example() {
        return "Good! Example API Success!!";
    }

    @Operation(summary = "save example api", description = "저장 예제 API 호출")
    @PostMapping("/save")
    public BaseResponse<ExampleDto> saveExample(
            @RequestBody RequestVo.SaveExample requestExampleVo
    ) {
        ExampleDto exampleDto = exampleUseCase.SaveExample(
                modelMapper.map(requestExampleVo, SaveExampleDto.class)
        );

        return new BaseResponse<>(exampleDto);
    }

    @Operation(summary = "Load example api", description = "읽기 예제 API 호출")
    @GetMapping("/read")
    public BaseResponse<ExampleDto> saveExample(
            @RequestParam(name = "email") @Email String email
    ) {
        ExampleDto loadExampleDto = exampleUseCase.LoadExampleByEmail(email);
        return new BaseResponse<>(loadExampleDto);
    }
}
