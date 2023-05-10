package com.leonardo.webservices.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leonardo.webservices.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_items")
public class OrderItem implements Serializable {
    @EmbeddedId
    private OrderItemPK orderItemPK;
    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(OrderItemPK orderItemPK, Integer quantity, Double price) {
        this.orderItemPK = orderItemPK;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        this.orderItemPK = new OrderItemPK(order, product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder() {
        return this.orderItemPK.getOrder();
    }

    public void setOrder(Order order) {
        this.orderItemPK.setOrder(order);
    }

    public Product getProduct() {
        return this.orderItemPK.getProduct();
    }

    public void setProduct(Product product) {
        this.orderItemPK.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubTotal() {
        return this.price * this.quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(orderItemPK, orderItem.orderItemPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemPK);
    }
}