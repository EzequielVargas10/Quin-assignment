package quin.client;

import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import quin.RestClient;
import quin.utils.BinsUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.internal.support.PathSupport.getPath;

public class UpdateBinsRestClient extends RestClient {

    BinsUtils binsUtils = new BinsUtils();

    public Response UpdateBin(Object body, String binId) throws IOException, ParseException {
        return given()
                .spec(requestSpecification())
                .contentType(CONTENT_TYPE)
                .header("secret-key",binsUtils.getApiKey().get("Api Key"))
                .body(body)
                .put(getPath(String.format(UPDATE_BIN, binId)));
    }

    public Response UpdateBinWithVersion(String binId) {
        return given()
                .spec(requestSpecification())
                .contentType(CONTENT_TYPE)
                .header("versioning", false)
                .put(getPath(String.format(UPDATE_BIN, binId)));
    }

}
