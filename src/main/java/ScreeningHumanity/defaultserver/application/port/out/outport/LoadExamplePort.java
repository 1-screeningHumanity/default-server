package ScreeningHumanity.defaultserver.application.port.out.outport;

import ScreeningHumanity.defaultserver.application.port.out.dto.ExampleDto;

public interface LoadExamplePort {

    ExampleDto LoadExampleByEmail(String email);
}
