package HomeWork_17;

import HomeWork_17.POJOUSERS.Root;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;

public class RestAssured {

    @BeforeTest
    public void precondition() {
        baseURI = "https://reqres.in";
    }

    @Test(priority = 1)
    public void getSingleUser() {
        Response response = given().when().get("/api/users/2");
        response.then().assertThat().statusCode(200);

        Assert.assertEquals(response.as(Root.class).data.id, 2);
        Assert.assertEquals(response.as(Root.class).data.first_name, "Janet");
        Assert.assertEquals(response.as(Root.class).support.url, "https://reqres.in/#support-heading");
    }

    @Test(priority = 2)
    public void getListUsers() {
        List<String> id = new ArrayList() {{
            add("1");
            add("2");
            add("3");
            add("4");
            add("5");
            add("6");
        }};
        Response response = given().when().get("/api/users");
        response.then().assertThat().statusCode(200);
        response.then().extract().response().prettyPrint();

        Assert.assertEquals(response.then().extract().response().jsonPath().get("data.id").toString(), id.toString());
    }

    @Test(priority = 3)
    public void getSingleUserNotFound() {
        Response response = given().when().get("/api/users/23");
        response.then().assertThat().statusCode(404);

        Assert.assertEquals(response.then().extract().response().jsonPath().get().toString(), "{}");

    }

    @Test(priority = 4)
    public void getListResource() {
        Response response = given().when().get("/api/unknown");
        List<String> name = new ArrayList() {{
            add("cerulean");
            add("fuchsia rose");
            add("true red");
            add("aqua sky");
            add("tigerlily");
            add("blue turquoise");
        }};
        response.then().assertThat().statusCode(200);

        Assert.assertEquals(response.then().extract().response().jsonPath().get("data.name").toString(), name.toString());
    }

    @Test(priority = 5)
    public void getSingleResource() {
        Response response = given().when().get("/api/unknown/2");
        response.then().assertThat().statusCode(200);

        Assert.assertEquals(response.as(HomeWork_17.POJOResource.Root.class).data.id, 2);
        Assert.assertEquals(response.as(HomeWork_17.POJOResource.Root.class).data.color, "#C74375");
    }

    @Test(priority = 6)
    public void postCreate() {
        Response response = given().when().header("Content-Type", "application/json").and().body(getRequestCreate()).post("/api/users");
        response.then().assertThat().statusCode(201);

        Assert.assertEquals(response.then().extract().response().jsonPath().get("name").toString(), "morpheus");
        Assert.assertEquals(response.then().extract().response().jsonPath().get("job").toString(), "leader");
    }

    @Test(priority = 7)
    public void putUpdate() {
        Response response = given().when().header("Content-Type", "application/json").and().body(getRequestUpdate()).put("/api/users/2");
        response.then().assertThat().statusCode(200);

        Assert.assertEquals(response.then().extract().response().jsonPath().get("name").toString(), "morpheus");
        Assert.assertEquals(response.then().extract().response().jsonPath().get("job").toString(), "zion resident");
    }

    @Test(priority = 8)
    public void patchUpdate() {
        Response response = given().when().header("Content-Type", "application/json").and().body(getRequestUpdate()).put("/api/users/2");
        response.then().assertThat().statusCode(200);

        Assert.assertEquals(response.then().extract().response().jsonPath().get("name").toString(), "morpheus");
        Assert.assertEquals(response.then().extract().response().jsonPath().get("job").toString(), "zion resident");
    }

    @Test(priority = 9)
    public void deleteUser() {
        Response response = given().when().delete("/api/users/2");
        response.then().assertThat().statusCode(204);
    }

    @Test(priority = 10)
    public void postRegisterSuccessful() {
        Response response = given().when().header("Content-Type", "application/json").and().body(getRequestRegisterSuccess()).post("/api/register");
        response.then().assertThat().statusCode(200);

        Assert.assertEquals(Integer.parseInt(response.then().extract().response().jsonPath().get("id").toString()), 4);
        Assert.assertEquals(response.then().extract().response().jsonPath().get("token").toString(), "QpwL5tke4Pnpja7X4");
    }

    @Test(priority = 11)
    public void postRegisterUnSuccessful() {
        Response response = given().when().header("Content-Type", "application/json").and().body(getRequestRegisterUnSuccess()).post("/api/register");
        response.then().assertThat().statusCode(400);

        Assert.assertEquals(response.then().extract().response().jsonPath().get("error").toString(), "Missing password");
    }

    @Test(priority = 12)
    public void postLoginSuccessful() {
        Response response = given().when().header("Content-Type", "application/json").and().body(getRequestLoginSuccess()).post("/api/login");
        response.then().assertThat().statusCode(200);

        Assert.assertEquals(response.then().extract().response().jsonPath().get("token").toString(), "QpwL5tke4Pnpja7X4");
    }

    @Test(priority = 13)
    public void postLoginUnSuccessful() {
        Response response = given().when().header("Content-Type", "application/json").and().body(getRequestLoginUnSuccess()).post("/api/login");
        response.then().assertThat().statusCode(400);

        Assert.assertEquals(response.then().extract().response().jsonPath().get("error").toString(), "Missing password");
    }

    @Test(priority = 14)
    public void getDelayedResponse() {
        Response response = given().when().get("api/users?delay=3");
        List<String> email = new ArrayList() {{
            add("george.bluth@reqres.in");
            add("janet.weaver@reqres.in");
            add("emma.wong@reqres.in");
            add("eve.holt@reqres.in");
            add("charles.morris@reqres.in");
            add("tracey.ramos@reqres.in");
        }};
        response.then().assertThat().statusCode(200);

        Assert.assertEquals(response.then().extract().response().jsonPath().get("data.email").toString(), email.toString());
        Assert.assertEquals(response.then().extract().response().jsonPath().get("support.text").toString(), "To keep ReqRes free, contributions towards server costs are appreciated!");
    }


    private String getRequestCreate() {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/HomeWork_17/Requests/Create.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getRequestUpdate() {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/HomeWork_17/Requests/Update.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getRequestRegisterSuccess() {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/HomeWork_17/Requests/RegisterSuccessful.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getRequestRegisterUnSuccess() {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/HomeWork_17/Requests/RegisterUnSuccessful.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getRequestLoginSuccess() {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/HomeWork_17/Requests/LoginSuccessful.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getRequestLoginUnSuccess() {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/HomeWork_17/Requests/LoginUnSuccessful.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}



