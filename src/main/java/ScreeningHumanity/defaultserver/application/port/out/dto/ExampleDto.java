package ScreeningHumanity.defaultserver.application.port.out.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExampleDto {

    private Long id;
    private String email;
    private String name;
}
