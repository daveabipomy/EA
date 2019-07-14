package test;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Proxy(lazy=false)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    private String ISBN;

    private  String title;

    private String publisher;
}
