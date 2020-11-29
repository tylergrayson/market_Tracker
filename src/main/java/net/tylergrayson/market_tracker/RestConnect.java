package net.tylergrayson.market_tracker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class RestConnect {

    public String requestData(String name) {
        try {
            // Make request to API
            URL url = new URL("https://sandbox.tradier.com/v1/markets/quotes?symbols=" + name);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", "Bearer UhKJjaXbWBOWtqk9mHTuWI6Gg2A9");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.connect();

            // Input stream from response
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));

            // Turning binary into string object
            StringBuilder json = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                json.append(line);
            }
            br.close();
            return json.toString();


        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
