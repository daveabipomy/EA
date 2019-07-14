package test;

import lombok.Data;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@Data
@Proxy(lazy=false)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    @org.hibernate.validator.constraints.ISBN(message="Invalid ISBN")
    private String ISBN;

    @NotBlank(message="required")
    @SafeHtml
    private  String title;

    @NotBlank(message="required")
    @SafeHtml
    private String author;

    @Positive
    private double price;
}
