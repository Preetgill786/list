package com.example.myapplicationmylist;

public class listItem {
    private String itemName;
    private String itemImage;

    public listItem() {
    }

    public listItem(String itemName, String itemImage) {
        this.itemName = itemName;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;

    }
}
