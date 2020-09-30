package quin.service;

import io.restassured.response.ValidatableResponse;
import org.json.simple.parser.ParseException;
import quin.client.CreateBinRestClient;
import requests.CreateBinRequest;
import responses.BinResponse;
import responses.ErrorRequestResponse;

import java.io.IOException;

import static org.apache.http.HttpStatus.*;

public class CreateBinsService{

    private CreateBinRestClient createBinsRestClient = new CreateBinRestClient();

    public BinResponse createBin(Object body) throws IOException, ParseException {
        return createBinAndExpectStatus(body, SC_OK)
                .extract()
                .as(BinResponse.class);
    }

    public ErrorRequestResponse createBinErrorResponse(CreateBinRequest createBinRequest) throws IOException, ParseException {
        return createBinAndExpectStatus(createBinRequest, SC_BAD_REQUEST)
                .extract()
                .as(ErrorRequestResponse.class);
    }

    public ErrorRequestResponse createBinUnauthorized(Object body) throws IOException, ParseException {
        return createBinAndExpectStatus(body, SC_UNAUTHORIZED)
                .extract()
                .as(ErrorRequestResponse.class);
    }

    public ErrorRequestResponse createBinWithoutApiKey(Object body) throws IOException, ParseException {
        return createBinsRestClient.createBinWithoutApiKey(body)
                .then()
                .statusCode(SC_UNAUTHORIZED)
                .extract()
                .as(ErrorRequestResponse.class);
    }

    public BinResponse createPublicBinWithName(Object body, String name) throws IOException, ParseException {
        return createBinsRestClient.createPublicBinWithName(body, name)
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(BinResponse.class);
    }

    public ErrorRequestResponse createPublicBinWithNameErrorRequest(Object body, String name) throws IOException, ParseException {
        return createBinsRestClient.createPublicBinWithName(body, name)
                .then()
                .statusCode(SC_UNPROCESSABLE_ENTITY)
                .extract()
                .as(ErrorRequestResponse.class);
    }

    public ValidatableResponse createBinAndExpectStatus(Object body,
                                                        int httpStatus) throws IOException, ParseException {
        return createBinsRestClient
                .createBin(body)
                .then()
                .statusCode(httpStatus);
    }
}
