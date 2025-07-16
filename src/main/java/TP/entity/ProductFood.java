package TP.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.Entity;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder

public class ProductFood extends Product {
    private LocalDate expiryDate;
}
