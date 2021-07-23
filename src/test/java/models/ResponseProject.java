package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseProject {
    int status;
    String name;
    int id;
}
