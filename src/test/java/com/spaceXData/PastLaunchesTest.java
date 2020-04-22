package com.spaceXData;

import com.spacexdata.Utils.Converter;
import com.spacexdata.Utils.PropReader;
import com.spacexdata.Utils.StringUtil;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PastLaunchesTest extends BaseTest {
    @Test
    public void getPastLaunchData() {
    RestAssured.baseURI = "https://api.spacexdata.com";
    Response res = given()
            .param("start", PropReader.getValue("startDate"))
            .param("end",PropReader.getValue("endDate"))
            .when()
            .get("/v3/launches/past")
            .then().assertThat().statusCode(200).extract().response();
    JsonPath jsonPath = Converter.convertToJson(res);
    String missionName = jsonPath.getString(missonNamePath);
    String rocketName = StringUtil.stringReplace(jsonPath.getString(rocketNamePath));
    String coreSerial = StringUtil.stringReplace(jsonPath.getString(coreSerialPath));
    String payload = StringUtil.stringReplace(jsonPath.getString(payloadPath));
    String reuse = StringUtil.stringReplace(jsonPath.getString(coreResuePath));

    System.out.println(missionName);
    System.out.println(rocketName);
    if(reuse.equalsIgnoreCase("true")) {
        System.out.println(coreSerial);
        System.out.println(payload);
    }
}

}
