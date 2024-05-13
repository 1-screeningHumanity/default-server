package ScreeningHumanity.defaultserver.adaptor.out.infrastructure.mysql.persistance;

import ScreeningHumanity.defaultserver.adaptor.out.infrastructure.mysql.entity.ExampleEntity;
import ScreeningHumanity.defaultserver.adaptor.out.infrastructure.mysql.repository.ExampleJpaRepository;
import ScreeningHumanity.defaultserver.application.port.out.dto.ExampleDto;
import ScreeningHumanity.defaultserver.application.port.out.outport.LoadExamplePort;
import ScreeningHumanity.defaultserver.application.port.out.outport.SaveExamplePort;
import ScreeningHumanity.defaultserver.domain.Example;
import ScreeningHumanity.defaultserver.global.common.exception.CustomException;
import ScreeningHumanity.defaultserver.global.common.response.BaseResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExampleAdaptor implements LoadExamplePort, SaveExamplePort {

    private final ExampleJpaRepository exampleJpaRepository;

    @Override
    public ExampleDto SaveExample(Example example) {
        ExampleEntity savedEntity = exampleJpaRepository.save(ExampleEntity.toEntityFrom(example));

        //todo : Mapper 도입 검토.
        return ExampleDto
                .builder()
                .email(savedEntity.getEmail())
                .name(savedEntity.getName())
                .id(savedEntity.getId())
                .build();
    }

    @Override
    public ExampleDto LoadExampleByEmail(String email) {
        ExampleEntity findExample = exampleJpaRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(BaseResponseCode.TEST_ERROR));
        //현재 INTERNAL_SERVER_ERROR를 터트리지만, 알맞은 ERROR 발생 시키면 됨.

        //todo : Mapper 도입 검토
        //MySql entity -> Domain
        return ExampleDto
                .builder()
                .id(findExample.getId())
                .email(findExample.getEmail())
                .name(findExample.getName())
                .build();
    }
}
