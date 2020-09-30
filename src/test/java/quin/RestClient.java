package quin;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class RestClient{

    public static final String APP_BASE_URI = ("https://api.jsonbin.io");
    public static final String CREATE_BIN = ("/b");
    public static final String GET_BIN = CREATE_BIN + "/%s";
    public static final String DELETE_BIN = CREATE_BIN + "/%s";
    public static final String UPDATE_BIN = CREATE_BIN + "/%s";
    public static final String GET_LATEST_BIN = CREATE_BIN + "/%s/latest";
    public static final String CONTENT_TYPE = ("application/json");

    public RequestSpecification requestSpecification(){

        RequestSpecification requestSpec = new RequestSpecBuilder().
                setBaseUri(APP_BASE_URI).
                build();
        return requestSpec;
    }

}
