package Util;

public class orders {
    private int orders_id;
    private int orders_total_amount;
    private int user_id;
    private int orders_statu;

    public orders(int orders_id, int orders_total_amount, int user_id, int orders_statu) {
        this.orders_id = orders_id;
        this.orders_total_amount = orders_total_amount;
        this.user_id = user_id;
        this.orders_statu = orders_statu;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getOrders_total_amount() {
        return orders_total_amount;
    }

    public void setOrders_total_amount(int orders_total_amount) {
        this.orders_total_amount = orders_total_amount;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOrders_statu() {
        return orders_statu;
    }

    public void setOrders_statu(int orders_statu) {
        this.orders_statu = orders_statu;
    }
}
