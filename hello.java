/**
 * Created by qiangma on 2018/4/15.
 */

import org.junit.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.get;

public class hello {

    @Test
    public void getTest() {
        System.setProperty("javax.net.ssl.trustStore", "/Users/qiangma/APItest180415/jssecacerts");
        //访问testerhome一定要设置证书


        get("https://testerhome.com/account/sign_in?user[login]=qiangma&user[password]=mm78613119").prettyPeek()
                .then().statusCode(200)
                //添加了断言
                .body("html.head.title", equalTo("登录 · TesterHome"))
        ;

    }

    public static void main(String[]args){

    }
}
