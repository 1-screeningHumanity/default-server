package ScreeningHumanity.defaultserver.adaptor.in.web.vo;

import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class RequestExampleVo {
    private String name;
    @Email
    private String email;
}
