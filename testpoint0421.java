/**
 * Created by qiangma on 2018/4/15.
 */

import org.junit.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class testpoint0421 {

    @Test
    public void getTest() {
        System.setProperty("javax.net.ssl.trustStore", "/Users/qiangma/APItest180415/jssecacerts");
        //访问testerhome一定要设置证书


        //get("https://testerhome.com/account/sign_in?user[login]=qiangma&user[password]=mm78613119").prettyPeek();
        given()
        .when()
                .get("https://testerhome.com/api/v3/topics.json").prettyPeek()
        .then()
                .statusCode(200)
                .body("topics.id[0]", equalTo(12869))                                //结果是一个数组，使用[];结果是数字时，不需要引号12993
                .body("topics.findAll{topics -> topics.id == 12869}.title",hasItem("杭州移动测试开发课程线下班_霍格沃兹测试学院"))
                //高级搜索，查询findAll结果是一个数组时，使用hasItem
                .body("topics.find{topics -> topics.id == 12869}.title",equalTo("杭州移动测试开发课程线下班_霍格沃兹测试学院"))
                ;

//        given().
//                parameters("firstName", "John", "lastName", "Doe").
//                when().
//                post("/greetXML").
//                then().
//                body("greeting.firstName", equalTo("John")).
//没有执行成功

}



    public static void main(String[]args){

    }
}


