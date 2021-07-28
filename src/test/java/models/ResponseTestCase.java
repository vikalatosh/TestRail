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
    @Expose()
    String estimate;
    @SerializedName("estimate_forecast")
    String estimateForecast;
    @Expose()
    int id;
    @Expose()
    @SerializedName("milestone_id")
    String milestone;
    @Expose()
    @SerializedName("priority_id")
    String priority;
    String refs;
    @SerializedName("suite_id")
    @Expose()
    int suiteId;
    @Expose()
    @SerializedName("section_id")
    int sectionId;
    @Expose()
    @SerializedName("template_id")
    String template;
    @Expose()
    String title;
    @Expose()
    @SerializedName("type_id")
    String type;
    @Expose()
    @SerializedName("update_by")
    int updatedBy;
    @Expose()
    @SerializedName("update_on")
    int updateOn;
}
