package quin.client;

import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import quin.RestClient;
import quin.utils.BinsUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.internal.support.PathSupport.getPath;

public class DeleteBinsRestClient extends RestClient {

    BinsUtils binsUtils = new BinsUtils();

    public Response deleteBin(String binId) throws IOException, ParseException {
        return given().
                spec(requestSpecification()).
                header("secret-key", binsUtils.getApiKey().get("Api Key")).
                        delete(getPath(String.format(DELETE_BIN, binId)));
    }

}
