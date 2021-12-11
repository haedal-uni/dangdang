package shop.dangdang.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class LoginDto {

    @Getter
    @Setter
    public static class Request {
        @NotNull
        @Size(min = 3, max = 50)
        private String nickName;

        @NotNull
        @Size(min = 3, max = 100)
        private String password;
    }

    @AllArgsConstructor
    @Setter
    @Getter
    public static class Response {
        final private Long    code;
        final private String  msg;
        final private String  desc;
    }
}