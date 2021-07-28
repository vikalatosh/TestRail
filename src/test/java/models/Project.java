package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    @Expose
    String name;
    @Expose(serialize = false)
    String announcement;
    @SerializedName("show_announcement")
    @Expose(serialize = false)
    boolean showAnnouncement;
    @SerializedName("suite_mode")
    @Expose
    Integer suiteMode;
}
