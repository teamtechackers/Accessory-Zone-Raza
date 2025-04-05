package com.example.accessory_zone_app;

import android.net.Uri;

public class rowModel {
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDescripition() {
        return Descripition;
    }

    public void setDescripition(String descripition) {
        Descripition = descripition;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public rowModel(String productName, String price, String descripition) {
        this.productName = productName;
        Price = price;
        Descripition = descripition;
    }

    String productName,Price,Descripition;
    Uri uri;

    public rowModel(String productName, String price, String descripition, Uri uri) {
        this.productName = productName;
        Price = price;
        Descripition = descripition;
        this.uri = uri;
    }
}
