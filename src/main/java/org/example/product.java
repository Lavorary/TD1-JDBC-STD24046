package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString

public class product {
    private int id;
    private String name;
    private double price;
    private LocalDate creationDateTime;

    public product(int id, String name, double price, LocalDate creationDateTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.creationDateTime = creationDateTime;
    }
}
