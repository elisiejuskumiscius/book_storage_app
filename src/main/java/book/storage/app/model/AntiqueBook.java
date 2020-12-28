package book.storage.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "antique_book")
public class AntiqueBook extends Book {

    @Column(name = "release_year", nullable = false)
    private java.sql.Date releaseYear;

    public Date getReleaseYear() { return releaseYear; }

    public void setReleaseYear(Date releaseYear) { this.releaseYear = releaseYear; }
}
