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

    //여기서는 Entity를 불러 오면 안됨.
    //따라서 inner static class 적용 하면 안됨.
    //왜냐면 이 파트는 Entity가 뭔지 몰라야됨.
}
