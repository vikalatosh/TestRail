package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Section {
    @Expose(serialize = false)
    String description;
    //    @SerializedName("suite_id")
//    @Expose(serialize = false)
//    int suiteId;
//    @SerializedName("parent_id")
//    @Expose(serialize = false)
//    int parentId;
    String name;
}
