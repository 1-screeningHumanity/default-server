package ScreeningHumanity.defaultserver.application.service;

import ScreeningHumanity.defaultserver.application.port.in.usecase.ExampleUseCase;
import ScreeningHumanity.defaultserver.application.port.out.dto.ExampleDto;
import ScreeningHumanity.defaultserver.application.port.out.outport.LoadExamplePort;
import ScreeningHumanity.defaultserver.application.port.out.outport.SaveExamplePort;
import ScreeningHumanity.defaultserver.domain.Example;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExampleService implements ExampleUseCase {

    private final LoadExamplePort loadExamplePort;
    private final SaveExamplePort saveExamplePort;

    @Override
    @Transactional
    public ExampleDto SaveExample(SaveExampleDto saveExampleDto) {
        return saveExamplePort.SaveExample(Example.toDomainFrom(saveExampleDto));
    }

    @Override
    @Transactional
    public ExampleDto LoadExampleByEmail(String email) {
        return loadExamplePort.LoadExampleByEmail(email);
    }
}
