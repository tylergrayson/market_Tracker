package net.tylergrayson.market_tracker;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;


@Controller
public class MainController {


    @RequestMapping("/")
    public ModelAndView doHome() {
        ModelAndView mv = new ModelAndView("index");

        return mv;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView get(@RequestParam("ticker") String ticker) throws JSONException {
        ModelAndView mv = new ModelAndView("redirect:/");

        String quote = getCompanyByName(ticker);
        try {
            JSONObject json = new JSONObject(quote);
            System.out.println(json);
            mv.addObject("symbol", json.getJSONObject("quotes").getJSONObject("quote").get("symbol").toString());
            mv.addObject("description", json.getJSONObject("quotes").getJSONObject("quote").get("description").toString());
            mv.addObject("last", json.getJSONObject("quotes").getJSONObject("quote").get("last").toString());
            mv.addObject("change", json.getJSONObject("quotes").getJSONObject("quote").get("change").toString());
            mv.addObject("volume", json.getJSONObject("quotes").getJSONObject("quote").get("volume").toString());
            mv.addObject("open", json.getJSONObject("quotes").getJSONObject("quote").get("open").toString());
            mv.addObject("high", json.getJSONObject("quotes").getJSONObject("quote").get("high").toString());
            mv.addObject("low", json.getJSONObject("quotes").getJSONObject("quote").get("low").toString());
            mv.addObject("change_percentage", json.getJSONObject("quotes").getJSONObject("quote").get("change_percentage").toString());
            mv.addObject("week_52_high", json.getJSONObject("quotes").getJSONObject("quote").get("week_52_high").toString());
            mv.addObject("week_52_low", json.getJSONObject("quotes").getJSONObject("quote").get("week_52_low").toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mv;
    }


    private String getCompanyByName(String name) {

        try {
            // MAKE REQUEST TO API
            URL url = new URL("https://sandbox.tradier.com/v1/markets/quotes?symbols=" + name);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", "Bearer UhKJjaXbWBOWtqk9mHTuWI6Gg2A9");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.connect();

            // GET INPUT STREAM RESPONSE FROM REQUEST
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));

            // TAKING BITS AND BYTES FROM BUFFERED READER TO BUILD IT INTO A STRING OBJECT
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

