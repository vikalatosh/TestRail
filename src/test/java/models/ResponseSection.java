package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseSection {
    @Expose()
    String description;
    @Expose()
    @SerializedName("suite_id")
    int suiteId;
    @Expose()
    @SerializedName("parent_id")
    int parentId;
    @Expose()
    int id;
    @Expose()
    int depth;
    @Expose()
    String name;
    @SerializedName("display_order")
    int displayOrder;
}
