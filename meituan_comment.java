import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

/**
 * Created by qiangma on 2018/4/17.
 */

//get(String path, Map<String,?> pathParams)方法实践180417
    //从美团地址copy出路径，然后分解到Map里面。http://www.meituan.com/meishi/api/poi/getMerchantComment?uuid=40297ae9a7fb4514a1cc.1523978292.1.0.0&platform=1&partner=126&originUrl=http%3A%2F%2Fwww.meituan.com%2Fmeishi%2F4395153%2F&riskLevel=1&optimusCode=1&id=4395153&userId=&offset=10&pageSize=10&sortType=1

public class meituan_comment {
    @Test
    public void getmeituan()
    {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("uuid", "40297ae9a7fb4514a1cc.1523978292.1.0.0");
        parameters.put("platform", "1");
        parameters.put("partner", "126");
        parameters.put("originUrl", "http%3A%2F%2Fwww.meituan.com%2Fmeishi%2F4395153%2F");
        parameters.put("riskLevel","1");
        parameters.put("optimusCode","1");
        parameters.put("id","4395153");
        parameters.put("useId",null);
        parameters.put("offset","10");
        parameters.put("pageSize","10");
        parameters.put("sortType","1");

    //System.setProperty("javax.net.ssl.trustStore", "/Users/qiangma/APItest180415/jssecacerts");


    given().params(parameters).get("http://www.meituan.com/meishi/api/poi/getMerchantComment").prettyPeek();

    }

}
