package edu.mum.cs544;

import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Proxy(lazy=false)
public class Book implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    @SafeHtml
    private String ttile;
    private String ISBN;
    private double price;

    @NotBlank
    @SafeHtml
    private String author;

    public Book() {
    }

    public Book(String ttile, String ISBN, double price, String author) {
        this.ttile = ttile;
        this.ISBN = ISBN;
        this.price = price;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTtile() {
        return ttile;
    }

    public void setTtile(String ttile) {
        this.ttile = ttile;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                id.equals(book.id) &&
                ttile.equals(book.ttile) &&
                ISBN.equals(book.ISBN) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ttile, ISBN, price, author);
    }
}
