package quin.utils;

import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BinsUtils {

    private static ObjectMapper mapper = new ObjectMapper();
    JSONParser jsonParser = new JSONParser();

    public BinsUtils() {
    }

    public JSONObject convertJsonFileToJsonObject(String jsonLocation) throws IOException, ParseException {
        Object obj = jsonParser.parse(new FileReader(jsonLocation));
        return (JSONObject) obj;
    }

    public String convertJsonFileToString(String jsonLocation) throws IOException, ParseException {
        Object obj = jsonParser.parse(new FileReader(jsonLocation));
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject.toJSONString();
    }
}
