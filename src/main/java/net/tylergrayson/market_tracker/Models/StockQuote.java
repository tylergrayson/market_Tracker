package net.tylergrayson.market_tracker.Models;

public class StockQuote {

    private String symbol = "";
    private String company_name = "";
    private double last_price;
    private double days_change;
    private long volume;
    private double open_price;
    private double todays_high;
    private double todays_low;
    private double change_percentage;
    private double fiftyTwoWeekHigh;
    private double fiftyTwoWeekLow;

    public StockQuote(String symbol) {
        this.symbol = symbol;
    }

    public StockQuote() {

    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public double getLast_price() {
        return last_price;
    }

    public void setLast_price(double last_price) {
        this.last_price = last_price;
    }

    public double getDays_change() {
        return days_change;
    }

    public void setDays_change(double days_change) {
        this.days_change = days_change;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public double getOpen_price() {
        return open_price;
    }

    public void setOpen_price(double open_price) {
        this.open_price = open_price;
    }

    public double getTodays_high() {
        return todays_high;
    }

    public void setTodays_high(double todays_high) {
        this.todays_high = todays_high;
    }

    public double getTodays_low() {
        return todays_low;
    }

    public void setTodays_low(double todays_low) {
        this.todays_low = todays_low;
    }

    public double getChange_percentage() {
        return change_percentage;
    }

    public void setChange_percentage(double change_percentage) {
        this.change_percentage = change_percentage;
    }

    public double getFiftyTwoWeekHigh() {
        return fiftyTwoWeekHigh;
    }

    public void setFiftyTwoWeekHigh(double fiftyTwoWeekHigh) {
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
    }

    public double getFiftyTwoWeekLow() {
        return fiftyTwoWeekLow;
    }

    public void setFiftyTwoWeekLow(double fiftyTwoWeekLow) {
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;
    }

}
