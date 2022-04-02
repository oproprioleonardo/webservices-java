package com.leon.portfolio.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_category")
@EqualsAndHashCode
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Setter(AccessLevel.NONE)
    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private List<Product> products = Lists.newArrayList();
}
