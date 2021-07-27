package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseSection {
    String description;
    @Expose(serialize = false)
    @SerializedName("suite_id")
    int suiteId;
    @Expose(serialize = false)
    @SerializedName("parent_id")
    int parentId;
    int id;
    @Expose(serialize = false)
    int depth;
    String name;
    @Expose(serialize = false)
    @SerializedName("display_order")
    int displayOrder;
}
