import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by qiangma on 2018/4/23.
 */
public class testpoint0421Test {

    public static void settings(){
        RestAssured.useRelaxedHTTPSValidation();
        System.setProperty("javax.net.ssl.trustStore", "/Users/qiangma/APItest180415/jssecacerts");
    }

//    @Test
//    public void testGetTestersearch() {
//        //HTTP请求，需要加这条 useRelaxedHTTPSValidation();
//        System.setProperty("javax.net.ssl.trustStore", "/Users/qiangma/APItest180415/jssecacerts");
//        //访问testerhome一定要设置证书
//
//
//        //get("https://testerhome.com/account/sign_in?user[login]=qiangma&user[password]=mm78613119").prettyPeek();
//
//        String name1 =
//                given()
//                .queryParam("q", "appium")
//        .when()
//                .get("https://testerhome.com/search").prettyPeek()
//                //.get("https://testerhome.com/api/v3/topics.json").prettyPeek()
//        .then()
//                .statusCode(200)
//                .body("html.head.title", equalTo("appium · 搜索结果 · TesterHome"))
//        .extract().path("html.head.title")
//                        .toString()
//          ;
//
//        System.out.println(name1);
        //输出结果错误：io.restassured.path.xml.XmlPath@2750771a
        //case passed

//    }

    @Test
        public void request(){
        System.setProperty("javax.net.ssl.trustStore", "/Users/qiangma/APItest180415/jssecacerts");

//        XmlPath xmlPath = new XmlPath(title).using(new XmlPathConfig("UTF-8"));

        String title =
                    given()
                            .queryParam("q", "appium")
                    .when()
                            .get("https://testerhome.com/search").prettyPeek()
                            //.get("https://testerhome.com/api/v3/topics.json").prettyPeek()
                    .then()
                            .statusCode(200)
//                            .body("html.head.title", equalTo("appium · 搜索结果 · TesterHome"))
//                            .extract().response()

                    .extract()
                            .path("html.head.title")
                            .toString() //解决报错：java.lang.ClassCastException: io.restassured.path.xml.XmlPath cannot be cast to java.lang.String

//                    .body(containsString(title))
                    ;

            System.out.println(title);
            // test passed: HTTP/1.1 200 OK
        }


}

