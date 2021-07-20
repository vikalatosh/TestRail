package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    String name, code, announcement, show_announcement, suite_mode;
}
