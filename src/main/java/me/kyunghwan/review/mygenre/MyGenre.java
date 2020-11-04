package me.kyunghwan.review.mygenre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kyunghwan.review.account.Account;
import me.kyunghwan.review.genre.Genre;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class MyGenre {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MYGENRE_ID")
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "GENRE_ID")
    private Genre genre;

    @Builder
    public MyGenre(Long idx, Account account, Genre genre) {
        this.idx = idx;
        this.account = account;
        this.genre = genre;
    }
}
