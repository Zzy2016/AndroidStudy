package com.example.imageloader;

public class Image {
    private int size;
    private String key;

    public Image(int size, String key) {
        this.size = size;
        this.key = key;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Image{" +
                "size=" + size +
                ", key='" + key + '\'' +
                "} ";
    }
}
