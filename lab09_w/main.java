package lab09_w;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;

public class main {
    public static String getKey(String stockSymbol, String key) {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol="
                + stockSymbol + "&apikey=" + key;
    }

    public static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }

        return sb.toString();
    }

    public static JsonObject readJsonFromURL(String url) throws IOException, JsonParseException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(
                                    new InputStreamReader(
                                            is,
                                            Charset.forName("UTF-8")
                                    ));
            String jsonText = readAll(rd);
            JsonParser parser = new JsonParser();
            JsonObject json = parser.parse(jsonText).getAsJsonObject();
            is.close();
            return json;
        } catch (Exception e) {
            is.close();
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        JsonObject json = readJsonFromURL(getKey("AAPL", ""));
        JsonObject values = json.get("Monthly Time Series").getAsJsonObject();

        for (Map.Entry<String, JsonElement> entry : values.entrySet()) {
            String date = entry.getKey();
            float close = entry.getValue()
                                .getAsJsonObject()
                                .get("4. close")
                                .getAsFloat();
            System.out.printf("%s: $%.2f\r\n", date, close);
        }
    }
}
