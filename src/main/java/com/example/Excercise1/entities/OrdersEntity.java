package com.example.Excercise1.entities;

import com.example.Excercise1.persistence.CommonEntities;
import com.example.Excercise1.persistence.Database;
import com.example.Excercise1.valueObject.ValueObject;
import lombok.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class OrdersEntity implements ValueObject {
    private int orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private String comments;
    private int customerNumber;

    private int resultCode = 101;

    private String resultCodeMessage = null;

    public boolean isDirty;

    public OrdersEntity(int orderNumber, Date orderDate, Date requiredDate, Date shippedDate, String status, String comments, int customerNumber) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;
    }

    @Override
    public void parseSql(ResultSet rs) throws SQLException {
        this.clear();
        CommonEntities.processesParseSql(this, rs);
    }

    @Override
    public void setResultCode(int var1) {

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
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
    public void clear() {
        CommonEntities.processClear(this);
    }

    @Override
    public String getSelectSql() {
        return Database.generatedSqlQuery().get("orders").get(1);
    }

    @Override
    public String getDeleteSql() {
        return Database.generatedSqlQuery().get("orders").get(2);
    }

    @Override
    public String getUpdateSql() {
        return Database.generatedSqlQuery().get("orders").get(3);
    }

    @Override
    public String getInsertSql() {
        return Database.generatedSqlQuery().get("orders").get(4);
    }

}
