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
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExampleAdaptor implements LoadExamplePort, SaveExamplePort {

    private final ExampleJpaRepository exampleJpaRepository;
    private final ModelMapper modelMapper;

    @Override
    public ExampleDto SaveExample(Example example) {

        ExampleEntity savedEntity = exampleJpaRepository.save(ExampleEntity.toEntityFrom(example));

        return modelMapper.map(savedEntity, ExampleDto.class);
    }

    @Override
    public ExampleDto LoadExampleByEmail(String email) {
        ExampleEntity findExample = exampleJpaRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(BaseResponseCode.TEST_ERROR));
        //현재 TEST_ERROR 를 발생 하지만, 알맞은 ERROR 발생 시키면 됨.

        //MySql entity -> Domain
        return modelMapper.map(findExample, ExampleDto.class);
    }
}
