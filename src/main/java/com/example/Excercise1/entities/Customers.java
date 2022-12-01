package com.example.Excercise1.entities;

import com.example.Excercise1.persistence.CommonEntities;
import com.example.Excercise1.persistence.Database;
import com.example.Excercise1.valueObject.ValueObject;
import lombok.*;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Customers implements ValueObject {
    private int customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private Integer salesRepEmployeeNumber;
    private BigDecimal creditLimit;
    private int resultCode = 101;
    private String resultCodeMessage = null;
    public boolean isDirty;

    public Customers(int customerNumber, String customerName, String contactLastName, String contactFirstName, String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, Integer salesRepEmployeeNumber, BigDecimal creditLimit) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
        this.creditLimit = creditLimit;
    }

    @Override
    public void clear() {
        CommonEntities.processClear(this);
    }

    @Override
    public void parseSql(ResultSet rs) {
        this.clear();
        CommonEntities.processesParseSql(this, rs);
    }

    @Override
    public void setResultCode(int var1) {

    }

    @Override
    public String getExecuteSql() {
        return CommonEntities.getExecuteSql(this.getResultCode());
    }

    @Override
    public List<Object> getParams() {
        return CommonEntities.getParams(this);
    }

    @Override
    public String getSelectSql() {
        return Database.generatedSqlQuery().get("customers").get(0);
    }

    @Override
    public String getDeleteSql() {
        return Database.generatedSqlQuery().get("customers").get(1);
    }

    @Override
    public String getUpdateSql() {
        return Database.generatedSqlQuery().get("customers").get(2);
    }

    @Override
    public String getInsertSql() {
        return Database.generatedSqlQuery().get("customers").get(3);
    }
}