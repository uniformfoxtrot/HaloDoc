package com.spacexdata.Utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Converter {
    public static JsonPath convertToJson(Response r) {
        String s = r.asString();
        JsonPath jp = new JsonPath(s);
        return jp;
    }
}
