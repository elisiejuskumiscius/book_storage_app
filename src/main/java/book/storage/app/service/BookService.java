package book.storage.app.service;

import book.storage.app.exception.BadResourceException;
import book.storage.app.exception.ResourceAlreadyExistsException;
import book.storage.app.exception.ResourceNotFoundException;
import book.storage.app.model.AntiqueBook;
import book.storage.app.model.Book;
import book.storage.app.repository.AntiqueBookRepository;
import book.storage.app.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void save(Book book) throws BadResourceException, ResourceAlreadyExistsException {

        if (!StringUtils.isEmpty(book.getName())) {

            if (book.getBarcode() != null && existsByBarcode(book.getBarcode())) {
                throw new ResourceAlreadyExistsException("Book with barcode: " + book.getBarcode() + " already exists");
            }
             bookRepository.save(book);
        } else {
            BadResourceException exc = new BadResourceException("Failed to save book");
            exc.addErrorMessage("Book is null or empty");
            throw exc;
        }
    }

    public Book getBookByBarcode(String barcode) throws ResourceNotFoundException {

        Book book = bookRepository.findBookByBarcode(barcode);
        if (book == null) {
            throw new ResourceNotFoundException("Cannot find Book with barcode: " + barcode);
        } else return book;
    }

    private boolean existsByBarcode(String barcode) {
        return bookRepository.existsBookByBarcode(barcode);
    }

    @Transactional
    public void update(Book book) throws BadResourceException, ResourceNotFoundException {
        if (!StringUtils.isEmpty(book.getName())) {

            if (!existsByBarcode(book.getBarcode())) {
                throw new ResourceNotFoundException("Cannot find Book with barcode: " + book.getBarcode());
            }
            bookRepository.update(book.getBarcode(), book.getName(), book.getQuantity(), book.getAuthor(), book.getPrice());
        } else {
            BadResourceException exc = new BadResourceException("Failed to save contact");
            exc.addErrorMessage("Book is null or empty");
            throw exc;
        }
    }

    @Transactional
    public void delete(String barcode) {
        bookRepository.deleteByBarcode(barcode);
    }

}

