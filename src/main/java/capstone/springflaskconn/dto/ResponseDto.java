package capstone.springflaskconn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseDto {
    private String msg;
    private String updatedName;
    private Integer updatedAge;
}
