package com.leon.portfolio.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.leon.portfolio.types.OrderStatus;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_order")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    @Enumerated(EnumType.STRING)
    @NotNull
    private OrderStatus orderStatus;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

}
