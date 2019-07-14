package test;

import lombok.*;
import test.AuthorityType;

import javax.persistence.*;


@Data
@Entity
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private AuthorityType name;

    public Authority(AuthorityType name) {
        this.name = name;
    }

}