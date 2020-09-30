package quin.service;

import io.restassured.response.ValidatableResponse;
import org.json.simple.parser.ParseException;
import quin.client.ReadBinsRestClient;
import responses.ErrorRequestResponse;

import java.io.IOException;

import static org.apache.http.HttpStatus.*;

public class ReadBinsService {

    private ReadBinsRestClient readBinsRestClient = new ReadBinsRestClient();

    public String getSpecificBin(String binId) throws IOException, ParseException {
        return readBinAndExpectStatus(binId, SC_OK)
                .extract()
                .asString();
    }

    public ErrorRequestResponse getSpecificBinErrorRequestResponse(String binId) {
        return readBinAndExpectStatus(binId, SC_UNPROCESSABLE_ENTITY)
                .extract()
                .as(ErrorRequestResponse.class);
    }

    public ValidatableResponse readBinAndExpectStatus(String binId,
                                                        int httpStatus) {
        return readBinsRestClient
                .GetBin(binId)
                .then()
                .statusCode(httpStatus);
    }
}
