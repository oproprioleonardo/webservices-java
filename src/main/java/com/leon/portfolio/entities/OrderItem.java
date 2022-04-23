package com.leon.portfolio.entities;

import com.leon.portfolio.entities.pk.OrderItemPK;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_order_item")
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrderItemPK id;
    private Integer quantity;
    private Double price;

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        this.id.setOrder(order);
        this.id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public void setOrder(Order order) {
        this.id.setOrder(order);
    }

    public Order getOrder() {
        return this.id.getOrder();
    }

    public void setProduct(Product product) {
        this.id.setProduct(product);
    }

    public Product getProduct() {
        return this.id.getProduct();
    }
}
