package ScreeningHumanity.defaultserver.application.port.in.usecase;

import ScreeningHumanity.defaultserver.adaptor.in.web.vo.RequestExampleVo;
import ScreeningHumanity.defaultserver.application.port.out.dto.ExampleDto;
import ScreeningHumanity.defaultserver.domain.Example;
import lombok.Builder;
import lombok.Getter;

public interface ExampleUseCase {
    ExampleDto SaveExample(SaveExampleDto saveExampleDto);

    ExampleDto LoadExampleByEmail(String email);

    //todo : Mapper나 Dto 따로 빼는거 생각 해볼 것.
    @Getter
    @Builder
    class SaveExampleDto{
        private String name;
        private String email;

        public static SaveExampleDto toDtoFrom(RequestExampleVo requestExampleVo){
            return SaveExampleDto
                    .builder()
                    .email(requestExampleVo.getEmail())
                    .name(requestExampleVo.getName())
                    .build();
        }
    }
}
