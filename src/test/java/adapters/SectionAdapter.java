package adapters;

import io.qameta.allure.Step;
import models.ResponseSection;
import models.Section;

public class SectionAdapter extends BaseAdapter {

    @Step("Create Section")
    public ResponseSection createSection(Section section, int status, int projectId) {
        String response = post(gson.toJson(section), status, apiUrl + "add_section/" + projectId);
        return gson.fromJson(response, ResponseSection.class);
    }

    @Step("Get Section")
    public ResponseSection getSection(int status, int sectionId) {
        String response = get(status, apiUrl + "get_section/" + sectionId);
        return gson.fromJson(response, ResponseSection.class);
    }

    @Step("Delete Section")
    public ResponseSection deleteSection(int status, int sectionId) {
        String response = delete(status, apiUrl + "delete_section/" + sectionId);
        return gson.fromJson(response, ResponseSection.class);
    }
}
