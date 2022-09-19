package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class GuitarForm {
    private int id;
    private String name;

    private Long price;
    private static MultipartFile img;

    public GuitarForm() {
    }

    public GuitarForm(int id, String name, Long price, MultipartFile img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public static MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
