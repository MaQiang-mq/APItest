import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.*;


/**
 * Created by qiangma on 2018/4/28.
 */

//第四讲 断言提升

public class lesson04 {
    @BeforeClass
    public static void setup() {
        useRelaxedHTTPSValidation();
        RestAssured.baseURI = "http://182.92.106.199:8090";
//        RestAssured.proxy("127.0.0.1",8080);
        System.setProperty("javax.net.ssl.trustStore", "/Users/qiangma/APItest180415/jssecacerts");

    }


    @Test
    public void lesson04() {
        given().
                header("Content-Type", "application/json")
                .header("userToken", "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MjQ4ODYwMzIsInN1YiI6IntcInVzZXJOYW1lXCI6XCIxODg2NzUzNzM3M1wifSIsImV4cCI6MTUyNTQ5MDgzMn0.MzbkkMsKPwH7-BKJJavtnkmTG82G6dRM_8iYffO6p6E5rMJhSAvPwpBgVdud1-Uhp48hKFOVEDnSQdWIQa8S2w")
                .request().body("{}")
                .when()
                .post("/api/contentTargeting/list").prettyPeek() //文章定向，获取用户列表
                .then()
                .statusCode(200)
                .body("result.data.factoryName[0]", equalTo("马强"))
                .body("result.data.factoryName", hasItem("总计划厂家"))
        ;

    }//Expected status code <200> but was <400>. ??? .request().body("{}")

    @Test
    public void contentTargeting0430Jsonpost() {
        HashMap<String,Object>  data= new HashMap<String,Object>();
        data.put("factoryName", "马强");
        data.put("articleId", "243667");
        data.put("articleTitle", "美国涉12起谋杀案“金州杀手”被捕 DNA鉴定锁真凶");


        given().
                header("Content-Type", "application/json")
                .header("userToken", "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MjQ4ODYwMzIsInN1YiI6IntcInVzZXJOYW1lXCI6XCIxODg2NzUzNzM3M1wifSIsImV4cCI6MTUyNTQ5MDgzMn0.MzbkkMsKPwH7-BKJJavtnkmTG82G6dRM_8iYffO6p6E5rMJhSAvPwpBgVdud1-Uhp48hKFOVEDnSQdWIQa8S2w")
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("/api/contentTargeting/list").prettyPeek() //文章定向，获取用户列表
                .then()
                .statusCode(200)
                .body("result.data.factoryName[0]", equalTo("马强"))
        ;

    }

    @Test
    public void juliye_valid() {
//        Response a =
        given().
                header("Content-Type", "application/json")
                .header("userToken", "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MjQ2MjE3NDksInN1YiI6IntcInVzZXJOYW1lXCI6XCIxODg2NzUzNzM3M1wifSIsImV4cCI6MTUyNTIyNjU0OX0.dSKzcd_AbbGgONfCQPpaegZK4xXKbTCj2JgNPuCKZ4JuvF0eg_wcTW8c0CC_2xK10TJswZc4DYxhHsK6Z7VJvA")
                .when()
                .get("/api/user/group/get/5ad998767aab995a74b6fd4e").prettyPeek()
                .then()
                .statusCode(200)
                .extract()
                .response()
        ;

//        System.out.println(a.body());
    }

    @Test
    public void druglist() {
        given().
                header("Content-Type", "application/json")
                .header("userToken", "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MjUwMjEyODksInN1YiI6IntcInVzZXJOYW1lXCI6XCIxODg2NzUzNzM3M1wifSIsImV4cCI6MTUyNTYyNjA4OX0.-3p84MCVZVPPyEugrMI6nDzlMK7l2PaCBqauUNywZcj--0qAFmgrnJMIpm61GjsV8VnxgHeqJaZ3qOGdkhyT9A")
//                .params(parameters)
                .request().body("{}")
        .when()
                .post("/api/medicine/list")   // 药品管理
                .prettyPeek()
        .then()
                .statusCode(200)
        ;

    }

    @Test
    public void login4postasjson(){
        Map<String, String> jsonAsMap = new HashMap<String, String>();
        jsonAsMap.put("userName", "18867537373");
        jsonAsMap.put("password", "12345678");

        given()
                .header("Content-Type","application/json") //避免415错误
                .proxy("127.0.0.1",8080)
                .contentType(ContentType.JSON)      //传参为json格式
                .body(jsonAsMap)
        .when()
                .post("/api/sys/login")
                .prettyPeek()
        .then()
                .statusCode(200)//180430：终于登录成功了，传参为json格式。lesson4讲到.
                .time(lessThan(1000L)) //Expected response time was not a value less than <10L> milliseconds, was 742 milliseconds (742 milliseconds).
                //"message": "登录成功"
        ;

    }
@Test
    public void spectest(){
    ResponseSpecBuilder builder = (ResponseSpecBuilder) new ResponseSpecBuilder().build(); //封装
    builder.expectStatusCode(200);
    builder.expectResponseTime(lessThan(500L));


        given().
                header("Content-Type", "application/json")
                .header("userToken", "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MjUwMjEyODksInN1YiI6IntcInVzZXJOYW1lXCI6XCIxODg2NzUzNzM3M1wifSIsImV4cCI6MTUyNTYyNjA4OX0.-3p84MCVZVPPyEugrMI6nDzlMK7l2PaCBqauUNywZcj--0qAFmgrnJMIpm61GjsV8VnxgHeqJaZ3qOGdkhyT9A")
                .request().body("{}")
        .when()
                .post("/api/medicine/list")   // 药品管理
                .prettyPeek()
        .then()
                .spec((ResponseSpecification) builder)//java.lang.ClassCastException: io.restassured.internal.ResponseSpecificationImpl cannot be cast to io.restassured.builder.ResponseSpecBuilder

        ;

    }
}


