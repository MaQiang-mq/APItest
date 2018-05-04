import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by qiangma on 2018/4/24.
 */
public class juliyeservicepackage {

    @Test
    public void getservicepackage(){
        given()
            .header("Content-Type","application/json")
            .header("userToken","eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MjQ1NTkyNDAsInN1YiI6IntcInVzZXJOYW1lXCI6XCIxODg2NzUzNzM3M1wifSIsImV4cCI6MTUyNTE2NDA0MH0.mMosw-RB_lFfjjphHLBaA3jbLFtKg29nX5EvFvBkBkZlyIciAqKtQwiYkqH2Pbz-sJThjmLEu1TTwmR5sAMDTA")
        .when()
                .post("http://182.92.106.199:8090/api/sp/list").prettyPeek()
        .then()
                .statusCode(200) //HTTP/1.1 400
//                .body("result.data.name[0]",equalTo("加载服务包"))
        ;


    }
}
