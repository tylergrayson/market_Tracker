package net.tylergrayson.market_tracker;


import net.tylergrayson.market_tracker.Models.Quote;
import net.tylergrayson.market_tracker.Models.QuoteRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

    @Autowired
    private QuoteRepository quoteRepository;

    @RequestMapping("/")
    public ModelAndView doHome() {
        ModelAndView mv = new ModelAndView("index");

        return mv;
    }

    // Make request to API when search button is clicked
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView get(@RequestParam("ticker") String ticker) {
        ModelAndView mv = new ModelAndView("redirect:/");

        RestConnect connect = new RestConnect();
        String response = connect.requestData(ticker);

        // Parse JSONObject to get needed attributes
        try {
            JSONObject json = new JSONObject(response);
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

            // Data model to represent JSONObject
            Quote userQuote = new Quote();
            userQuote.setSymbol(json.getJSONObject("quotes").getJSONObject("quote").get("symbol").toString());
            userQuote.setCompanyName(json.getJSONObject("quotes").getJSONObject("quote").get("description").toString());
            userQuote.setLastPrice(json.getJSONObject("quotes").getJSONObject("quote").get("last").toString());
            userQuote.setDaysChange(json.getJSONObject("quotes").getJSONObject("quote").get("change").toString());
            userQuote.setVolume(json.getJSONObject("quotes").getJSONObject("quote").get("volume").toString());
            userQuote.setOpen(json.getJSONObject("quotes").getJSONObject("quote").get("open").toString());
            userQuote.setHigh(json.getJSONObject("quotes").getJSONObject("quote").get("high").toString());
            userQuote.setLow(json.getJSONObject("quotes").getJSONObject("quote").get("low").toString());
            userQuote.setChangePercentage(json.getJSONObject("quotes").getJSONObject("quote").get("change_percentage").toString());
            userQuote.setFiftyTwoWeekHigh(json.getJSONObject("quotes").getJSONObject("quote").get("week_52_high").toString());
            userQuote.setFiftyTwoWeekLow(json.getJSONObject("quotes").getJSONObject("quote").get("week_52_low").toString());
            quoteRepository.save(userQuote);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mv;
    }

    // Request to Database to display all results in table
    @RequestMapping ("/table")
    public ModelAndView loadTable() {
        ModelAndView mv = new ModelAndView("table");

        mv.addObject("quotesList", quoteRepository.findAll());
        return mv;
    }
}

