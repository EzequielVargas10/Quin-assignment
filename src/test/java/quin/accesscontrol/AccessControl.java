package quin.accesscontrol;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import quin.service.CreateBinsService;
import quin.utils.BinsUtils;
import responses.ErrorRequestResponse;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static quin.data.binData.EXAMPLE_BODY;
import static quin.data.binData.ERROR_MESSAGE_NO_API_KEY;

public class AccessControl {

    private CreateBinsService createBinsService = new CreateBinsService();
    private BinsUtils binsUtils = new BinsUtils();
    private JSONObject body;

    @Test
    public void cannotCreateBinWithoutApiKey() throws IOException, ParseException {
        body = binsUtils.convertJsonFileToJsonObject(EXAMPLE_BODY);
        ErrorRequestResponse errorRequestResponse = createBinsService.createBinWithoutApiKey(body);

        assertThat(errorRequestResponse.getSuccess(), equalTo(false));
        assertThat(errorRequestResponse.getMessage(), equalTo(ERROR_MESSAGE_NO_API_KEY));
    }
}
