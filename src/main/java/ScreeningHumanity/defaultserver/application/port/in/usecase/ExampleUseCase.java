package ScreeningHumanity.defaultserver.application.port.in.usecase;

import ScreeningHumanity.defaultserver.application.port.out.dto.ExampleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface ExampleUseCase {

    ExampleDto SaveExample(SaveExampleDto saveExampleDto);

    ExampleDto LoadExampleByEmail(String email);

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class SaveExampleDto {

        private String name;
        private String email;
    }
}
