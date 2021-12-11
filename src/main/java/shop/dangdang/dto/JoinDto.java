package shop.dangdang.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class JoinDto {
    @Getter
    @Setter
    public static class Request {
        @NotNull
        private String nickName;

        @NotNull
        private String password;

        @NotNull
        @Email
        private String email;
    }

    @Getter
    @Setter
    public static class Response {
        private Long code;
        private String msg;
        private String desc;
    }
}
