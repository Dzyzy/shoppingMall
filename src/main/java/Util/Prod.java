package Util;

import java.math.BigDecimal;

public class Prod {
    private int prod_id;
    private String prod_name;
    private BigDecimal prod_price;
    private int shop_id;
    private int prod_num;
    private String prod_desc;
    private String prod_three_level;
    private String prod_statu;
    private String prod_img;
    private String prod_sale;
    private int prod_sale_num;
    private double prod_sale_amount;
    private int prod_pingjia;
    private int orders_id;
    private int prod_count;
    private int orders_statu;

    public Prod() {
    }

    public Prod(int prod_id, String prod_name, BigDecimal prod_price, int orders_statu, String prod_img, int prod_pingjia, int orders_id, int prod_count, double prod_sale_amount) {
        this.prod_id = prod_id;
        this.prod_name = prod_name;
        this.prod_price = prod_price;
        this.orders_statu = orders_statu;
        this.prod_img = prod_img;
        this.prod_pingjia = prod_pingjia;
        this.orders_id = orders_id;
        this.prod_count = prod_count;
        this.prod_sale_amount = prod_sale_amount;
    }

    public Prod(int prod_id, String prod_name, BigDecimal prod_price, int shop_id, int prod_num, String prod_desc, String prod_three_level, String prod_statu, String prod_img, String prod_sale) {
        this.prod_id = prod_id;
        this.prod_name = prod_name;
        this.prod_price = prod_price;
        this.shop_id = shop_id;
        this.prod_num = prod_num;
        this.prod_desc = prod_desc;
        this.prod_three_level = prod_three_level;
        this.prod_statu = prod_statu;
        this.prod_img = prod_img;
        this.prod_sale = prod_sale;
    }

    public double getProd_sale_amount() {
        return prod_sale_amount;
    }

    public int getProd_count() {
        return prod_count;
    }

    public void setProd_count(int prod_count) {
        this.prod_count = prod_count;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getProd_pingjia() {
        return prod_pingjia;
    }

    public void setProd_pingjia(int prod_pingjia) {
        this.prod_pingjia = prod_pingjia;
    }

    public void setProd_sale_amount(double prod_sale_amount) {
        this.prod_sale_amount = prod_sale_amount;
    }

    public int getProd_sale_num() {
        return prod_sale_num;
    }

    public void setProd_sale_num(int prod_sale_num) {
        this.prod_sale_num = prod_sale_num;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public void setProd_price(BigDecimal prod_price) {
        this.prod_price = prod_price;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public void setProd_num(int prod_num) {
        this.prod_num = prod_num;
    }

    public void setProd_desc(String prod_desc) {
        this.prod_desc = prod_desc;
    }

    public void setProd_three_level(String prod_three_level) {
        this.prod_three_level = prod_three_level;
    }

    public void setProd_statu(String prod_statu) {
        this.prod_statu = prod_statu;
    }

    public void setProd_img(String prod_img) {
        this.prod_img = prod_img;
    }

    public void setProd_sale(String prod_sale) {
        this.prod_sale = prod_sale;
    }

    public int getProd_id() {
        return prod_id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public BigDecimal getProd_price() {
        return prod_price;
    }

    public int getShop_id() {
        return shop_id;
    }

    public int getProd_num() {
        return prod_num;
    }

    public String getProd_desc() {
        return prod_desc;
    }

    public String getProd_three_level() {
        return prod_three_level;
    }

    public String getProd_statu() {
        return prod_statu;
    }

    public String getProd_img() {
        return prod_img;
    }

    public String getProd_sale() {
        return prod_sale;
    }
}
