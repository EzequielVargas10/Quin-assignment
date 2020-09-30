package quin.client;

import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import quin.RestClient;
import quin.utils.BinsUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CreateBinRestClient extends RestClient {

    BinsUtils binsUtils = new BinsUtils();

    public Response createBin(Object body) throws IOException, ParseException {
        return given().spec(requestSpecification()).
                contentType(CONTENT_TYPE).
                header("secret-key",binsUtils.getApiKey().get("Api Key")).
                body(body).
                post(CREATE_BIN);
    }

    public Response createBinWithoutApiKey(Object body) throws IOException, ParseException {
        return given().spec(requestSpecification()).
                contentType(CONTENT_TYPE).
                body(body).
                post(CREATE_BIN);
    }

    public Response createPublicBinWithName(Object body, String name) throws IOException, ParseException {
        return given().spec(requestSpecification()).
                contentType(CONTENT_TYPE).
                header("secret-key",binsUtils.getApiKey().get("Api Key")).
                header("private", false).
                header("name", name).
                body(body).
                post(CREATE_BIN);
    }
}
