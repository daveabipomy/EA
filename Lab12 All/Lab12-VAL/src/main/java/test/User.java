package test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import  test.Authority;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "username cannot be empty")
    @Column(nullable = false, unique = true)
    private String username;

    @NotEmpty(message = "{myuser.pwd}")
    private String password;

    private LocalDateTime dateCreated;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id")})
    private Set<Authority> authorities = new HashSet<>();

    public void addAutority(Authority authority){
        authorities.add(authority);
    }


}
