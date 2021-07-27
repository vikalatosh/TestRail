package adapters;

import io.qameta.allure.Step;
import models.ResponseTestCase;
import models.TestCase;

public class TestCaseAdapter extends BaseAdapter {

    @Step("Create Test Case")
    public ResponseTestCase createTestCase(TestCase testCase, int status, int sectionId) {
        String response = post(gson.toJson(testCase), status, apiUrl + "add_case/" + sectionId);
        return gson.fromJson(response, ResponseTestCase.class);
    }

    @Step("Get Test Case")
    public ResponseTestCase getTestCase(int status, int id) {
        String response = get(status, apiUrl + "get_case/" + id);
        return gson.fromJson(response, ResponseTestCase.class);
    }

    @Step("Delete Test Case")
    public ResponseTestCase deleteTestCase(int status, int id) {
        String response = delete(status, apiUrl + "delete_case/" + id);
        return gson.fromJson(response, ResponseTestCase.class);
    }
}
