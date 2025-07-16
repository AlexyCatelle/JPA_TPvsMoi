package TP.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.time.Duration;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder

public class ProductElectronic extends Product {
    private Duration batteryDuration;
}
