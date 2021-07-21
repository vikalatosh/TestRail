package adapters;

import com.google.gson.Gson;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class BaseAdapter {
    protected String apiUrl = utils.PropertyReader.getProperty("TESTRAIL_API_URL", "testrail.apiUrl");
    protected String email = utils.PropertyReader.getProperty("TESTRAIL_EMAIL", "testrail.email");
    protected String apiKey = utils.PropertyReader.getProperty("TESTRAIL_API_KEY", "testrail.apiKey");

    Gson gson = new Gson();

    @Step("Perform post")
    public String post(String body, int status, String url) {
        return
                given().
                        auth().preemptive().basic(email, apiKey).
                        header("Content-Type", "application/json").
                        body(body).
                        log().all().
                when().
                        post(url).
                then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }

    @Step("Perform get")
    public String get(int status, String url) {
        return
                given().
                        auth().preemptive().basic(email, apiKey).
                        header("Content-Type", "application/json").
                        log().all().
                        when().
                        get(url).
                        then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }

    @Step("Perform delete")
    public String delete(int status, String url) {
        return
                given().
                        auth().preemptive().basic(email, apiKey).
                        header("Content-Type", "application/json").
                        log().all().
                        when().
                        post(url).
                        then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }
}
