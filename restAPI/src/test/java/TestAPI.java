import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestAPI {
    private String baseURI = RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
    private String employees = "employees";
    private String employeesWithId = "employee/";
    private String create = "create";
    @Test
    public void getAllEmployees(){
        Response response = given().when().get(employees).then().extract().response();
        JsonPath x = new JsonPath(response.asString());
        System.out.println("Employee name : " + x.get("employee_name"));
        System.out.println("Response is " + response.asString());
    }

    @Test
    public void getSpecificEmployee(){
        Response response = given().when().get(employeesWithId+52391).then().extract().response();
        System.out.println("Response is : " + response.asString());
        JsonPath x = new JsonPath(response.asString());
        System.out.println("Response after is :" + response.asString());
    }

    @Test
    public void postNewEmployee() {
        JSONObject newEmployee = new JSONObject();
        newEmployee.put("name", "Otto Bismark");
        newEmployee.put("salary", "180000");
        newEmployee.put("age", "76");

        Response response = given().header("Content-type", "application/json").body(newEmployee.toString()).when().post(create).then().statusCode(200).extract().response();
        System.out.println("Response : " + response.asString());
    }

    @Test
    public void deleteSomeUser(){
        Response response = given().contentType(ContentType.JSON).delete("/delete/52426");
        System.out.println("Status code is : " + response.getStatusCode());
    }
}
