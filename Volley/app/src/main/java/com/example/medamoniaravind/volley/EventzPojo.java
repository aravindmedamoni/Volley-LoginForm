package com.example.medamoniaravind.volley;

public class EventzPojo {
    String p_title;
    String p_image;
    String p_price;

    public EventzPojo(String title, String price, String image, String date, String venue) {
        this.p_title = title;
        this.p_image = image;
        this.p_price = price;

    }

    public String getP_title() {
        return p_title;
    }

    public void setP_title(String p_title) {
        this.p_title = p_title;
    }

    public String getP_image() {
        return p_image;
    }

    public void setP_image(String p_image) {
        this.p_image = p_image;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public String getP_date() {
        return p_date;
    }

    public void setP_date(String p_date) {
        this.p_date = p_date;
    }

    public String getP_venue() {
        return p_venue;
    }

    public void setP_venue(String p_venue) {
        this.p_venue = p_venue;
    }

    String p_date;
    String p_venue;
}
