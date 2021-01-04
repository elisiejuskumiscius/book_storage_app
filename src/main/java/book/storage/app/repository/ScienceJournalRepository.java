package book.storage.app.repository;

import book.storage.app.model.Book;
import book.storage.app.model.ScienceJournal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScienceJournalRepository extends Repository<ScienceJournal, Long> {

    void save(ScienceJournal scienceJournal);

    @Query("FROM Book book, ScienceJournal sc WHERE book.id = sc.id ORDER BY book.id")
    List<Book> findAllScienceJournals();

    @Modifying
    @Query("UPDATE ScienceJournal as book SET book.name = :name, book.quantity = :quantity, book.author = :author, book.price = :price, book.index = :index WHERE book.barcode = :barcode")
    void updateAntiqueBook(@Param("barcode") String barcode, @Param("name") String name, @Param("quantity") Integer quantity, @Param("author") String author, @Param("price") Double price, @Param("index") Byte index);

    void deleteScienceJournalByBarcode(String barcode);

}
