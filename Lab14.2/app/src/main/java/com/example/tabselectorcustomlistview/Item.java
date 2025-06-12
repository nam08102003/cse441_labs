package com.example.tabselectorcustomlistview;

public class Item {
    private String code,title;
    private Integer favorite;
    public Item(String code, String title, Integer favorite) {
        this.code = code; this.title = title; this.favorite = favorite;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
   
    public Integer getFavorite() {
        return favorite;

    }
    
    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }

}
