package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseStatus {
    int status;
//    Result result;
    String name;
    int id;
}
