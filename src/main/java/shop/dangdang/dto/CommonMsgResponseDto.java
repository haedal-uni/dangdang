package shop.dangdang.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommonMsgResponseDto {
    private Long code;
    private String msg;
    private String desc;
}
