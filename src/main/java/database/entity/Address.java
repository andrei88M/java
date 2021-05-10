package database.entity;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Address {
    private int id;
    private String street;
    private int house;
}
