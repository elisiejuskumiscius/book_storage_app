package book.storage.app.repository;

import book.storage.app.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends Repository<Book, Long> {

    @Query("FROM Book WHERE id NOT IN (SELECT id FROM AntiqueBook) AND id NOT IN (SELECT id FROM ScienceJournal)")
    List<Book> findAll();

    @Modifying
    @Query("UPDATE Book book SET book.name = :name, book.quantity = :quantity, book.author = :author, book.price = :price WHERE book.barcode = :barcode")
    void update(@Param("barcode") String barcode, @Param("name") String name, @Param("quantity") Integer quantity, @Param("author") String author, @Param("price") Double price);

    void save(Book book);

    Book findBookByBarcode(String barcode);

    void deleteByBarcode(String barcode);

    boolean existsBookByBarcode(String barcode);
}
