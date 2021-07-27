package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseProject {
    String announcement;
    @SerializedName("completed_on")
    int completedOn;
    int id;
    @SerializedName("is_completed")
    boolean isCompleted;
    String name;
    @SerializedName("show_announcement")
    boolean showAnnouncement;
    @SerializedName("suite_mode")
    Integer suiteMode;
    String url;
}
