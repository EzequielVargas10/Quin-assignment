package quin.client;

import quin.RestClient;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;
import static io.restassured.internal.support.PathSupport.getPath;

public class ReadBinsRestClient extends RestClient{

    public Response GetBin(String binId) {
        return given()
                .spec(requestSpecification())
                .get(getPath(String.format(GET_BIN, binId)));
    }

    public Response GetLatestBin(String binId) {
        return requestSpecification().
                get(getPath(String.format(GET_LATEST_BIN, binId)));
    }

    public Response GetBin(String binId, String version) {
        return requestSpecification().
                get(getPath(String.format(GET_BIN, binId) + "/" + version));
    }

}
