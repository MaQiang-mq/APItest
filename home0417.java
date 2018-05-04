import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Created by qiangma on 2018/4/17.
 */

public class home0417 {

    @Test
    public void getTesterhome(){
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("limit", "1");
        parameters.put("offset", "0");
        parameters.put("type", "last_actived");
        System.setProperty("javax.net.ssl.trustStore", "/Users/qiangma/APItest180415/jssecacerts");


        given()
                .params(parameters)
                .get("https://testerhome.com/api/v3/topics.json")
                .prettyPeek()
        .then()
                .statusCode(200)
        ;

    }

}
