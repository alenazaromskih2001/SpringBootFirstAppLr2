package ru.zaromskih.SpringBootFirstAppLr2.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Systems {
    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System");

    private final String denotation;

    Systems(String denotation){
        this.denotation = denotation;
    }

    @JsonValue
    public  String getDenotation(){
        return denotation;
    }
}
