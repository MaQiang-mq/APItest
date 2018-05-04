import org.junit.Test;

import static io.restassured.RestAssured.*;

/**
 * Created by qiangma on 2018/4/18.
 */
public class doclistpost {
    @Test
    public void getTest() {
        //Map<String, String> parameters = new HashMap<String, String>();

        //parameters.put("doctorName","344");

                given().
                        header("Content-Type","application/json").
                        header("userToken", "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MjQwNDM4NDUsInN1YiI6IntcInVzZXJOYW1lXCI6XCIxODg2NzUzNzM3M1wifSIsImV4cCI6MTUyNDY0ODY0NX0.1OSWMbWKHjK5NNVrUlLeuKhK_SJ1DnuY6Htevi-Z7_vvRysgTbeLZe-HpYnViprYGOps_krjsOLdKtoU8vP9Rw")
                        //.params(parameters)
                        .queryParam("docterName","")
                .when()
                        //请求医生列表
                        .post("http://182.92.106.199:8090/api/doctor/list/get")
                        .prettyPeek()
                .then()
                        .statusCode(200)
                ;
                   }
}