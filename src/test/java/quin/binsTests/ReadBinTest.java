package quin.binsTests;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import quin.service.ReadBinsService;
import quin.utils.BinsUtils;
import responses.ErrorRequestResponse;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static quin.data.BinData.EXAMPLE_BODY;
import static quin.data.BinData.INVALID_BIN_ID;
import static quin.data.BinData.INVALID_BIN_ID_MESSAGE;


public class ReadBinTest {

    private ReadBinsService readBinsService = new ReadBinsService();

    @Test
    public void canReadASpecificBin() throws IOException, ParseException {
        String binRead = readBinsService.getSpecificBin(BinsUtils.getBins(0));

        assertThat(binRead, equalTo(BinsUtils.convertJsonFileToString(EXAMPLE_BODY)));
    }

    // It's trowing a different message ("Invalid Record ID") and "success" parameter is null
    @Test
    public void cannotReadASpecificBin(){
        ErrorRequestResponse binRead = readBinsService.getSpecificBinErrorRequestResponse(INVALID_BIN_ID);

//        assertThat(binRead.getSuccess(), equalTo(false));
        assertThat(binRead.getMessage(), equalTo(INVALID_BIN_ID_MESSAGE));
    }
}
