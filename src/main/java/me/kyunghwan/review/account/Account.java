package me.kyunghwan.review.account;

import lombok.*;
import me.kyunghwan.review.mygenre.MyGenre;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Entity
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    private Long idx;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    @Column(nullable = false)
    private Boolean isVerified;

    // @Builder.Default
    @OneToMany(mappedBy = "account")
    private final Set<MyGenre> myGenres = new HashSet<>();

    public void add(MyGenre myGenre) {
        getMyGenres().add(myGenre);
    }

    @Builder
    public Account(Long idx, String email, String password, LoginType loginType, Boolean isVerified) {
        this.idx = idx;
        this.email = email;
        this.password = password;
        this.loginType = loginType;
        this.isVerified = isVerified;
    }
}
