package ScreeningHumanity.defaultserver.adaptor.out.infrastructure.mysql.persistance;

import ScreeningHumanity.defaultserver.adaptor.out.infrastructure.mysql.entity.ExampleEntity;
import ScreeningHumanity.defaultserver.adaptor.out.infrastructure.mysql.repository.ExampleJpaRepository;
import ScreeningHumanity.defaultserver.application.port.out.dto.ExampleDto;
import ScreeningHumanity.defaultserver.application.port.out.outport.LoadExamplePort;
import ScreeningHumanity.defaultserver.application.port.out.outport.SaveExamplePort;
import ScreeningHumanity.defaultserver.domain.Example;
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
}
