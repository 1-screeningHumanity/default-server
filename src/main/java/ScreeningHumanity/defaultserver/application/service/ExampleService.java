package ScreeningHumanity.defaultserver.application.service;

import ScreeningHumanity.defaultserver.application.port.in.usecase.ExampleUseCase;
import ScreeningHumanity.defaultserver.application.port.out.dto.ExampleDto;
import ScreeningHumanity.defaultserver.application.port.out.outport.LoadExamplePort;
import ScreeningHumanity.defaultserver.application.port.out.outport.SaveExamplePort;
import ScreeningHumanity.defaultserver.domain.Example;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleService implements ExampleUseCase {

    private final LoadExamplePort loadExamplePort;
    private final SaveExamplePort saveExamplePort;

    @Override
    public ExampleDto SaveExample(SaveExampleDto saveExampleDto) {
        return saveExamplePort.SaveExample(Example.toDomainFrom(saveExampleDto));
    }

    @Override
    public ExampleDto LoadExampleByEmail(String email) {
        return loadExamplePort.LoadExampleByEmail(email);
    }
}
