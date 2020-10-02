package quin.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static quin.data.BinData.API_KEY;

public class BinsUtils {

    public BinsUtils(){

    }

    private static ObjectMapper mapper = new ObjectMapper();
    static JSONParser jsonParser = new JSONParser();
    private static List<String> list = new ArrayList<String>();

    public static JSONObject convertJsonFileToJsonObject(String jsonLocation) throws IOException, ParseException {
        Object obj = jsonParser.parse(new FileReader(jsonLocation));
        return (JSONObject) obj;
    }

    public static String convertJsonFileToString(String jsonLocation) throws IOException, ParseException {
        Object obj = jsonParser.parse(new FileReader(jsonLocation));
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject.toJSONString();
    }

    public JSONObject getApiKey() throws IOException, ParseException {
        return convertJsonFileToJsonObject(API_KEY);
    }

    public static void fillBins(String binId){
        list.add(binId);
    }

    public static String getBins(Integer index){
        return list.get(index);
    }

    public static void deleteBins(){
        list.remove(1);
    }
}
