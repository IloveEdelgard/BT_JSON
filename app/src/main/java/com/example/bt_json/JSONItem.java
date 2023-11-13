package com.example.bt_json;

public class JSONItem {
    private String title;
    private String rating;
    private String price;
    private String thumbnail;
    private String stock;
    private String category;
    private String brand;

    public JSONItem(String title, String rating, String price, String thumbnail, String stock, String category, String brand) {
        this.title = title;
        this.rating = rating;
        this.price = price;
        this.thumbnail = thumbnail;
        this.stock = stock;
        this.category = category;
        this.brand = brand;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }

    public String getPrice() {
        return price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }
}
