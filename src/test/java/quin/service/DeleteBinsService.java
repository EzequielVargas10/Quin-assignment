package quin.service;

import io.restassured.response.ValidatableResponse;
import org.json.simple.parser.ParseException;
import quin.client.DeleteBinsRestClient;
import responses.BinResponse;
import responses.ErrorRequestResponse;

import java.io.IOException;

import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNPROCESSABLE_ENTITY;

public class DeleteBinsService {

    private DeleteBinsRestClient deleteBinsRestClient = new DeleteBinsRestClient();

    public BinResponse deleteBin(String binId) throws IOException, ParseException {
        return deleteBinAndExpectStatus(binId, SC_OK)
                .extract()
                .as(BinResponse.class);
    }

    public ErrorRequestResponse deleteBinErrorRequestResponse(String binId) throws IOException, ParseException {
        return deleteBinAndExpectStatus(binId, SC_UNPROCESSABLE_ENTITY)
                .extract()
                .as(ErrorRequestResponse.class);
    }

    public ValidatableResponse deleteBinAndExpectStatus(String binId,
                                                        int httpStatus) throws IOException, ParseException {
        return deleteBinsRestClient
                .deleteBin(binId)
                .then()
                .statusCode(httpStatus);
    }
}
