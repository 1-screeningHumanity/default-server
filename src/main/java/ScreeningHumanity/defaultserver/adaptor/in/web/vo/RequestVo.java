package ScreeningHumanity.defaultserver.adaptor.in.web.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class RequestVo {

    @Getter
    public static class SaveExample {

        @Size(min = 2, max = 10)
        private String name;
        @Email
        @Size(min = 2, max = 50)
        private String email;
    }
}
