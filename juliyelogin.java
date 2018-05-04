import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
/**
 * Created by qiangma on 2018/4/24.
 */
public class juliyelogin {

    @Test
    public void login(){
        useRelaxedHTTPSValidation();

        given()
                .header("Content-Type","application/json")
                .queryParam("userName", "18867537373")
                .queryParam("password", "12345678").
        when()
                .post("http://182.92.106.199:8090/api/sys/login?userName=18867537373&password=12345678").prettyPeek()
//        .then().statusCode(200) //HTTP/1.1 400
        ;
    }
    public static void main(String[]args){

    }
}
