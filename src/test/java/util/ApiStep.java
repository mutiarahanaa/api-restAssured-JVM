package util;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured.*;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers.*;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ApiStep {

    public static final Dotenv dotenv = Dotenv.configure().systemProperties().load();;
    private RequestSpecification request;
    private Response response;
    private String json;
    //private ResponseBody resp ;
    private String url = System.getProperty("BASEURL");
    private ValidatableResponse StatusCode;
    private Object object;


    public void setURL(String path){
        url=url+path;
        request = given();
    }
    public void getRequestURL(){
        response = request.when().get(url);
        json = response.body().asString();

    }
    public void getURLRequestWithID(Integer id){
        response = request.when().get(url+"/"+id);
        response.prettyPrint();
        json = response.body().asString();
        JsonPath jsonPath = new JsonPath(json);
        Assert.assertEquals(jsonPath.getInt("data.id"), id.intValue());
    }
    public void verifyDataResponse(String var, String val){
        json = response.body().asString();
        assertThat(response.getBody().jsonPath().get(var), equalTo(val));

    }
    public  void verifyStatusCode(Integer code){
        StatusCode = response.then().statusCode(code);
        Assert.assertEquals( response.getStatusCode(), code.intValue());
    }

    public void showResponse() {
        json = response.asString();
        System.out.println("===== SHOW ME THE RESPONSE =====" + "\n" + json + "\n" + "===== END =====");
    }

}
