package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseProject {
    @Expose()
    String announcement;
    @SerializedName("completed_on")
    int completedOn;
    @Expose()
    int id;
    @SerializedName("is_completed")
    boolean isCompleted;
    @Expose()
    String name;
    @SerializedName("show_announcement")
    boolean showAnnouncement;
    @SerializedName("suite_mode")
    Integer suiteMode;
    @Expose()
    String url;
}
