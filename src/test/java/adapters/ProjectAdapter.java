package adapters;

import io.qameta.allure.Step;
import models.Project;
import models.ResponseProject;
import models.ResponseStatus;

public class ProjectAdapter extends BaseAdapter {

    @Step("Create Project")
    public ResponseStatus create(Project project, int status) {
        String response = post(gson.toJson(project), status, apiUrl + "add_project");
        return gson.fromJson(response, ResponseStatus.class);
    }

    @Step("Get Project")
    public ResponseProject getProject(int id) {
        String response = get(200, apiUrl + "get_project/:" + id);
        return gson.fromJson(response, ResponseProject.class);
    }
}
