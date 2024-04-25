package org.jsp.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
   @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private long phone;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Product> products;
}
