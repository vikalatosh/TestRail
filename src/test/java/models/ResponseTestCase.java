package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseTestCase {
    @SerializedName("created_by")
    int createdBy;
    @SerializedName("created_on")
    String createdOn;
    String estimate;
    @SerializedName("estimate_forecast")
    String estimateForecast;
    int id;
    @Expose(serialize = false)
    @SerializedName("milestone_id")
    String milestone;
    @Expose(serialize = false)
    @SerializedName("priority_id")
    String priority;
    String refs;
    @SerializedName("suite_id")
    @Expose(serialize = false)
    int suiteId;
    @Expose(serialize = false)
    @SerializedName("section_id")
    int sectionId;
    @Expose(serialize = false)
    @SerializedName("template_id")
    String template;
    String title;
    @Expose(serialize = false)
    @SerializedName("type_id")
    String type;
    @Expose(serialize = false)
    @SerializedName("update_by")
    int updatedBy;
    @Expose(serialize = false)
    @SerializedName("update_on")
    int updateOn;
}
