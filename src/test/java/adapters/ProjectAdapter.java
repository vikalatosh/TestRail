package adapters;

import io.qameta.allure.Step;
import models.Project;
import models.ResponseProject;

public class ProjectAdapter extends BaseAdapter {

    @Step("Create Project")
    public ResponseProject create(Project project, int status) {
        String response = post(gson.toJson(project), status, apiUrl + "add_project");
        return gson.fromJson(response, ResponseProject.class);
    }

    @Step("Get Project")
    public ResponseProject getProject(int status, int id) {
        String response = get(status, apiUrl + "get_project/" + id);
        return gson.fromJson(response, ResponseProject.class);
    }

    @Step("Delete Project")
    public ResponseProject deleteProject(int status, int id) {
        String response = delete(status, apiUrl + "delete_project/" + id);
        return gson.fromJson(response, ResponseProject.class);
    }
}
