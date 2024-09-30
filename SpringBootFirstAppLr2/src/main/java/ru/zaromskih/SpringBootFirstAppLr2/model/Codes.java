package ru.zaromskih.SpringBootFirstAppLr2.model;


import com.fasterxml.jackson.annotation.JsonValue;

public enum Codes {
    SUCCESS ("success"),
    FAILED("failed");

    private final String name;

    Codes(String name){
        this.name = name;
    }

    @JsonValue//аннотация, чтобы в ответе было маленькими буквами success и failed
    public String getName(){
        return  name;
    }
    @Override
    public String toString(){
        return  name;

    }
}
