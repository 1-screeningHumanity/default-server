package ScreeningHumanity.defaultserver.adaptor.in.web.controller;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import ScreeningHumanity.defaultserver.adaptor.in.web.vo.RequestVo;
import ScreeningHumanity.defaultserver.application.port.in.usecase.ExampleUseCase;
import ScreeningHumanity.defaultserver.application.port.in.usecase.ExampleUseCase.SaveExampleDto;
import ScreeningHumanity.defaultserver.application.port.out.dto.ExampleDto;
import ScreeningHumanity.defaultserver.global.common.response.BaseResponse;
import ScreeningHumanity.defaultserver.global.common.token.DecodingToken;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
    private final DecodingToken decodingToken;

    @Operation(summary = "example api", description = "예제 API 호출")
    @GetMapping
    public String example() {
        return "Good! Example API Success!!";
    }

    @Operation(summary = "save example api", description = "저장 예제 API 호출")
    @PostMapping("/save")
    public BaseResponse<Void> saveExample( //반환하는 Data가 없는 경우 Void 로 명시적으로 표기
            @RequestBody RequestVo.SaveExample requestExampleVo
    ) {
        exampleUseCase.SaveExample(
                modelMapper.map(requestExampleVo, SaveExampleDto.class)
        );

        return new BaseResponse<>();
    }

    //유효성 (expired 등) 여부는 gateway server 에서 진행하여 각 서비스에서는 신경 쓸 필요가 없습니다.
    @Operation(summary = "Token decoding example api", description = "토큰으로 Uuid 추출 예제")
    @PostMapping("/token")
    public BaseResponse<Void> decodeExample(
            @RequestHeader(AUTHORIZATION) String token
    ) {
        String uuid = decodingToken.getUuid(token);
        log.info("uuid = {}", uuid);

        return new BaseResponse<>();
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
