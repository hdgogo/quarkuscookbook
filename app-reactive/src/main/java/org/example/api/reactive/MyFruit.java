package org.example.api.reactive;


import javax.persistence.*;

@Entity
@Table(name="my_fruit")
public class MyFruit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;



    public String name;
}
