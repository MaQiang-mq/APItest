import org.junit.Test;

import static io.restassured.RestAssured.given;


/**
 * Created by qiangma on 2018/4/25.
 */
public class zlyvalid_01 {

    @Test
    public void juliye_valid(){
//        Response a =
            given().
                header("Content-Type","application/json")
                .header("userToken","eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MjQ2MjE3NDksInN1YiI6IntcInVzZXJOYW1lXCI6XCIxODg2NzUzNzM3M1wifSIsImV4cCI6MTUyNTIyNjU0OX0.dSKzcd_AbbGgONfCQPpaegZK4xXKbTCj2JgNPuCKZ4JuvF0eg_wcTW8c0CC_2xK10TJswZc4DYxhHsK6Z7VJvA")
            .when()
                .get("http://182.92.106.199:8090/api/user/group/get/5ad998767aab995a74b6fd4e").prettyPeek()
            .then()
                .statusCode(200)
            .extract()
                    .response()
         ;

//        System.out.println(a.body());
    }


}
