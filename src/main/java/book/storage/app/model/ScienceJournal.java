package book.storage.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "science_journal")
public class ScienceJournal extends Book {

    @Column(name = "science_index", nullable = false)
    private byte index;

    public byte getIndex() {
        return index;
    }

    public void setIndex(byte index) {
        this.index = index;
    }
}
