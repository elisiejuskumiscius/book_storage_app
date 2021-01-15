package book.storage.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "antique_book", schema = "book_store")

public class AntiqueBook extends Book {

    @Min(value = 1900)
    @Max(value = 2021)
    @NotNull(message = "Year is required")
    @Column(name = "release_year")
    private Integer releaseYear;

    public Integer getReleaseYear() { return releaseYear; }

    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }

    @Override
    public double getTotalPrice() {

        LocalDate localDate = LocalDate.now();

        return getPrice() * getQuantity() * (localDate.getYear() - getReleaseYear()) / 10;
    }

}
