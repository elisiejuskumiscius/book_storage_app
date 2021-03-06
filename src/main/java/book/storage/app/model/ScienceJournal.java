package book.storage.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "science_journal", schema = "book_store")
public class ScienceJournal extends Book {

    @Min(value = 1)
    @Max(value = 10)
    @NotNull(message = "Science Index is required")
    @Column(name = "science_index")
    private Integer index;

    public Integer getIndex() { return index; }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public double getTotalPrice() {
        return getQuantity() * getPrice() * this.index;
    }

}
