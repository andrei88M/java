package database.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class People {
    private int id;
    private String name;
    private String surname;
    private int age;
}
