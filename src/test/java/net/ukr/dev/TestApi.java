package net.ukr.dev;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

public class TestApi {

    @Test
    public void firstTest() {
       Response resp =  given().when().post("http://accounts-new.dev.ukr.net/api/v1/login/do");
       String responseString = resp.asString();
       System.out.println(responseString);

       Assert.assertEquals(resp.getStatusCode(), 599);
       String error = from(responseString).getString("error");
       System.out.println(error);
       Assert.assertEquals("invalid_args", error);
    }

    @Test
    public void secondTest() {
        Response resp =  given().
                formParams("domain","dev.ukr.net").formParams("login", "reset_019").contentType("application/json").
                when().
                post("http://accounts-new.dev.ukr.net/api/v1/login/pow/get");
        String responseString = resp.asString();
        System.out.println(responseString);
        String cookies= String.valueOf(resp.getCookies());

        Assert.assertEquals(resp.getStatusCode(), 599);
        String error = from(responseString).getString("error");
        System.out.println(error);
        //Assert.assertEquals("recaptcha_required", error);
        Assert.assertEquals("invalid_args", error);
        System.out.println(cookies);
    }

    @Test
    public void thonsendTest() {
        Response resp =  given().
                body("{login: \"reset_019\", domain: \"dev.ukr.net\"}").contentType("application/json").
                when().
                post("http://accounts-new.dev.ukr.net/api/v1/login/pow/get");
        String responseString = resp.asString();
        System.out.println(responseString);

        Assert.assertEquals(resp.getStatusCode(), 599);
        String error = from(responseString).getString("error");
        System.out.println(error);
        Assert.assertEquals("invalid_args", error);
    }
}
