package net.tylergrayson.market_tracker.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quotes")
public class Quote {

    @Id
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "companyname")
    private String companyName;
    @Column(name = "lastprice")
    private String lastPrice;
    @Column(name = "dayschange")
    private String daysChange;
    @Column(name = "volume")
    private String volume;
    @Column(name = "open")
    private String open;
    @Column(name = "high")
    private String high;
    @Column(name = "low")
    private String low;
    @Column(name = "changepercentage")
    private String changePercentage;
    @Column(name = "fiftytwoweekhigh")
    private String fiftyTwoWeekHigh;
    @Column(name = "fiftytwoweeklow")
    private String fiftyTwoWeekLow;

    public Quote() {

    }

    public Quote(String symbol, String companyName, String lastPrice, String daysChange, String volume,
                 String open, String high, String low, String changePercentage,
                 String fiftyTwoWeekHigh, String fiftyTwoWeekLow) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.lastPrice = lastPrice;
        this.daysChange = daysChange;
        this.volume = volume;
        this.open = open;
        this.high = high;
        this.low = low;
        this.changePercentage = changePercentage;
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String company_name) {
        this.companyName = company_name;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String last_price) {
        this.lastPrice = last_price;
    }

    public String getDaysChange() {
        return daysChange;
    }

    public void setDaysChange(String days_change) {
        this.daysChange = days_change;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open_price) {
        this.open = open_price;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String todays_high) {
        this.high = todays_high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String todays_low) {
        this.low = todays_low;
    }

    public String getChangePercentage() {
        return changePercentage;
    }

    public void setChangePercentage(String change_percentage) {
        this.changePercentage = change_percentage;
    }

    public String getFiftyTwoWeekHigh() {
        return fiftyTwoWeekHigh;
    }

    public void setFiftyTwoWeekHigh(String fiftyTwoWeekHigh) {
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
    }

    public String getFiftyTwoWeekLow() {
        return fiftyTwoWeekLow;
    }

    public void setFiftyTwoWeekLow(String fiftyTwoWeekLow) {
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;
    }

}
