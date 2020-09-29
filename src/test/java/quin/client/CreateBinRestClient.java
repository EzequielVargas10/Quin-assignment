package quin.client;

import static quin.data.binData.API_KEY;
import static quin.data.binData.NAME;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import quin.RestClient;
import quin.utils.BinsUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CreateBinRestClient extends RestClient {

    BinsUtils binsUtils = new BinsUtils();

    public JSONObject getApiKey() throws IOException, ParseException {
        return binsUtils.convertJsonFileToJsonObject(API_KEY);
    }

    public Response createBin(Object body) throws IOException, ParseException {
        return given().spec(requestSpecification()).
                contentType(CONTENT_TYPE).
                header("secret-key",getApiKey().get("Api Key")).
                body(body).
                post(CREATE_BIN);
    }

    public Response createBinWithoutApiKey(Object body) throws IOException, ParseException {
        return given().spec(requestSpecification()).
                contentType(CONTENT_TYPE).
                body(body).
                post(CREATE_BIN);
    }

    public Response createPublicBinWithName(Object body) throws IOException, ParseException {
        return given().spec(requestSpecification()).
                contentType(CONTENT_TYPE).
                header("secret-key",getApiKey().get("Api Key")).
                header("private", false).
                header("name", NAME).
                body(body).
                post(CREATE_BIN);
    }
}
