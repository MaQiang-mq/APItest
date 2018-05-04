import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Created by qiangma on 2018/4/17.
 */
public class search_doc {
    @Test
    public void getTest(){
        Map<String, String> parameters = new HashMap<String, String>();
        //parameters.put("limit", "1");
        //parameters.put("offset", "0");
        //parameters.put("type", "last_actived");
        //System.setProperty("javax.net.ssl.trustStore", "/Users/qiangma/APItest180415/jssecacerts");
        parameters.put("barCode","6940078800390");
        parameters.put("desc","反反复复反反复复方法");
        parameters.put("factoryCode","908048");
        parameters.put("factoryName","厂家A");
        parameters.put("id","5a6ec6820dd25d4515bd2a56");
        //parameters.put("images",["FsY6-IOAKSFtAIsHl6cM6CeWDvb5"]);
        //parameters.put("0","FgtaHaR8l3LUbF_k5Kn0t392S_Bh");
        parameters.put("medicineApprovalNo","1234");
        parameters.put("name","厂家A的药品");
        parameters.put("packageInfo","12");

        //given().cookie("cookieName", "value1", "value2").
        given().
                header("Content-Type","application/json").header("userToken", "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MjQwNDM4NDUsInN1YiI6IntcInVzZXJOYW1lXCI6XCIxODg2NzUzNzM3M1wifSIsImV4cCI6MTUyNDY0ODY0NX0.1OSWMbWKHjK5NNVrUlLeuKhK_SJ1DnuY6Htevi-Z7_vvRysgTbeLZe-HpYnViprYGOps_krjsOLdKtoU8vP9Rw").
                params(parameters).post("http://182.92.106.199:8090/api/medicine/update").
                prettyPeek();
        //given().params(parameters).post("http://182.92.106.199:8090/api/medicine/update").prettyPeek();
    }
}

//本条是测试药品编辑，postman是可以请求成功的，在这里    "message": "验证失败!","status": "500"
//而且已经加入了cookie，不知道为什么不成功

//180430： 这条case需要通过id传递来做update