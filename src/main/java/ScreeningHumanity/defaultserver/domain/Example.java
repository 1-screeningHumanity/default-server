package ScreeningHumanity.defaultserver.domain;

import ScreeningHumanity.defaultserver.application.port.in.usecase.ExampleUseCase.SaveExampleDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Example {
    private String name;
    private String email;

    //todo : Mapper 도입 검토 할 것.
    //
    public static Example toDomainFrom(SaveExampleDto saveExampleDto){
        return Example.builder()
                .email(saveExampleDto.getEmail())
                .name(saveExampleDto.getName())
                .build();
    }
}
