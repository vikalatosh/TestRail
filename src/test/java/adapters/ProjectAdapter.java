package adapters;

import io.qameta.allure.Step;
import models.Project;
import models.ResponseStatus;

public class ProjectAdapter extends BaseAdapter {

    @Step("Create Project")
    public ResponseStatus create(Project project, int status) {
        String response = post(gson.toJson(project), status, apiUrl + "add_project");
        return gson.fromJson(response, ResponseStatus.class);
    }

    @Step("Get Project")
    public ResponseStatus getProject(int status, Integer id) {
        String response = get(status, apiUrl + "get_project/" + id);
        return gson.fromJson(response, ResponseStatus.class);
    }

    @Step("Delete Project")
    public ResponseStatus deleteProject(int status, Integer id) {
        String response = delete(status, apiUrl + "delete_project/" + id);
        return gson.fromJson(response, ResponseStatus.class);
    }
}
