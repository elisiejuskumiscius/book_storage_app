package book.storage.app.repository;

import book.storage.app.model.AntiqueBook;
import book.storage.app.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AntiqueBookRepository extends Repository<AntiqueBook, Long> {

    void save(AntiqueBook antiqueBook);

    @Query("FROM Book book, AntiqueBook antique WHERE book.id = antique.id ORDER BY book.id")
    List<Book> findAllAntiqueBooks();

    @Modifying
    @Query("UPDATE AntiqueBook as book SET book.name = :name, book.quantity = :quantity, book.author = :author, book.price = :price, book.releaseYear = :releaseYear WHERE book.barcode = :barcode")
    void updateAntiqueBook(@Param("barcode") String barcode, @Param("name") String name, @Param("quantity") Integer quantity, @Param("author") String author, @Param("price") Double price, @Param("releaseYear") Integer releaseYear);

    void deleteAntiqueBookByBarcode(String barcode);

}
