package com.example.accessory_zone_app;

import android.net.Uri;

public class rowModel {
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
