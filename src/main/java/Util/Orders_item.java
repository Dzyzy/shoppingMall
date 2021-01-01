package Util;

import java.math.BigDecimal;

public class Orders_item {
    private int orders_id;
    private int prod_id;
    private int prod_count;
    private String prod_name;
    private String prod_img;
    private BigDecimal prod_price;
    private int prod_pingjia;

    public Orders_item(int orders_id, int prod_id, int prod_count, String prod_name, String prod_img, BigDecimal prod_price, int prod_pingjia) {
        this.orders_id = orders_id;
        this.prod_id = prod_id;
        this.prod_count = prod_count;
        this.prod_name = prod_name;
        this.prod_img = prod_img;
        this.prod_price = prod_price;
        this.prod_pingjia = prod_pingjia;
    }

    public int getProd_pingjia() {
        return prod_pingjia;
    }

    public void setProd_pingjia(int prod_pingjia) {
        this.prod_pingjia = prod_pingjia;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public int getProd_count() {
        return prod_count;
    }

    public void setProd_count(int prod_count) {
        this.prod_count = prod_count;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_img() {
        return prod_img;
    }

    public void setProd_img(String prod_img) {
        this.prod_img = prod_img;
    }

    public BigDecimal getProd_price() {
        return prod_price;
    }

    public void setProd_price(BigDecimal prod_price) {
        this.prod_price = prod_price;
    }
}
