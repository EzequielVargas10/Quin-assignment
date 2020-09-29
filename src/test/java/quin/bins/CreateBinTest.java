package quin.bins;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import quin.service.CreateBinsService;
import quin.utils.BinsUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static quin.data.binData.EXAMPLE_BODY;
import static org.hamcrest.core.IsEqual.equalTo;
import org.json.simple.JSONObject;
import responses.CreateBinResponse;

import java.io.IOException;

public class CreateBinTest {

    private CreateBinsService createBinsService = new CreateBinsService();
    private BinsUtils binsUtils = new BinsUtils();
    private JSONObject body;

    @Test
    public void canCreateBin() throws IOException, ParseException {
        body = binsUtils.convertJsonFileToJsonObject(EXAMPLE_BODY);
        CreateBinResponse binResponse = createBinsService.createBin(body);

        assertThat(binResponse.getSuccess(), equalTo(true));
        assertThat(binResponse.getData().get("sample"), equalTo("Hello World"));
    }

    @Test
    public void canCreateAPublicBinWithName() throws IOException, ParseException {
        body = binsUtils.convertJsonFileToJsonObject(EXAMPLE_BODY);
        CreateBinResponse binResponse = createBinsService.createPublicBinWithName(body);

        System.out.print(binResponse.getId());

        assertThat(binResponse.getSuccess(), equalTo(true));
        assertThat(binResponse.getData().get("sample"), equalTo("Hello World"));
        assertThat(binResponse.getPrivateStatus(), equalTo(false));
    }
}
