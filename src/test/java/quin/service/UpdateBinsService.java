package quin.service;

import io.restassured.response.ValidatableResponse;
import org.json.simple.parser.ParseException;
import quin.client.UpdateBinsRestClient;
import responses.BinResponse;
import responses.ErrorRequestResponse;

import java.io.IOException;

import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNPROCESSABLE_ENTITY;

public class UpdateBinsService {

    private UpdateBinsRestClient updateBinsRestClient = new UpdateBinsRestClient();

    public BinResponse updateBin(Object body, String binId) throws IOException, ParseException {
        return updateBinAndExpectStatus(body, binId, SC_OK)
                .extract()
                .as(BinResponse.class);
    }

    public ErrorRequestResponse updateBinErrorRequestResponse(Object body, String binId) throws IOException, ParseException {
        return updateBinAndExpectStatus(body, binId, SC_UNPROCESSABLE_ENTITY)
                .extract()
                .as(ErrorRequestResponse.class);
    }

    public ValidatableResponse updateBinAndExpectStatus(Object body, String binId,
                                                        int httpStatus) throws IOException, ParseException {
        return updateBinsRestClient
                .UpdateBin(body, binId)
                .then()
                .statusCode(httpStatus);
    }
}
