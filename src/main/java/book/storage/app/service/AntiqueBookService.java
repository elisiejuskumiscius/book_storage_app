package book.storage.app.service;

import book.storage.app.model.AntiqueBook;
import book.storage.app.model.Book;
import book.storage.app.repository.AntiqueBookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AntiqueBookService {

    private final AntiqueBookRepository antiqueBookRepository;

    public AntiqueBookService(AntiqueBookRepository antiqueBookRepository) {
        this.antiqueBookRepository = antiqueBookRepository;
    }

    public List<Book> getAllAntique() { return antiqueBookRepository.findAllAntiqueBooks(); }

    public void saveAntiqueBook(AntiqueBook antiqueBook) { antiqueBookRepository.save(antiqueBook);}

    @Transactional
    public void updateAntiqueBook(Book book, AntiqueBook antiqueBook) {
            antiqueBookRepository.updateAntiqueBook(book.getBarcode(), book.getName(), book.getQuantity(),
                    book.getAuthor(), book.getPrice(), antiqueBook.getReleaseYear());
    }

    @Transactional
    public void deleteByBarcode(String barcode) {
        antiqueBookRepository.deleteAntiqueBookByBarcode(barcode);
    }
}
