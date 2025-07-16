package TP.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Product {
    @Id
    @GeneratedValue
    protected Long id;
    protected String name;
    protected double price;
}
