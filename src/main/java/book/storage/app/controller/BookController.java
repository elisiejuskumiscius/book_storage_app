package book.storage.app.controller;

import book.storage.app.exception.ResourceNotFoundException;
import book.storage.app.model.AntiqueBook;
import book.storage.app.model.Book;
import book.storage.app.model.ScienceJournal;
import book.storage.app.service.AntiqueBookService;
import book.storage.app.service.BookService;
import book.storage.app.service.ScienceJournalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookstore/")
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final BookService bookService;
    private final AntiqueBookService antiqueBookService;
    private final ScienceJournalService scienceJournalService;

    public BookController(BookService bookService, AntiqueBookService antiqueBookService,
                          ScienceJournalService scienceJournalService) {
        this.bookService = bookService;
        this.antiqueBookService = antiqueBookService;
        this.scienceJournalService = scienceJournalService;
    }

    @GetMapping("main")
    public String showMain() {
        return "main";
    }

    @GetMapping("book-list")
    public String showUpdate(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "book-list";
    }

    @GetMapping("antique-list")
    public String showAntique(Model model) {
        model.addAttribute("books", antiqueBookService.getAllAntique());
        return "antique-list";
    }

    @GetMapping("journal-list")
    public String showJournal(Model model) {
        model.addAttribute("books", scienceJournalService.getAllJournals());
        return "journal-list";
    }

    @GetMapping(value = {"book-add"})
    public String showAddBook(Model model) {
        Book book = new Book();
        model.addAttribute("add", true);
        model.addAttribute("book", book);
        return "book-add";
    }

    @PostMapping(value = {"book-add"})
    public String addBook(Model model, @ModelAttribute("book") Book book) {

        try {
            bookService.save(book);
            return "redirect:/bookstore/book-list";

        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);
            return "book-add";
        }
    }

    @GetMapping(value = {"antique-add"})
    public String showAddAntiqueBook(Model model) {
        AntiqueBook antiqueBook = new AntiqueBook();
        model.addAttribute("add", true);
        model.addAttribute("antique", antiqueBook);
        return "antique-add";
    }

    @PostMapping(value = "antique-add")
    public String addAntiqueBook(Model model, @ModelAttribute("antique") AntiqueBook antiqueBook, Book book) {

        try {
            antiqueBookService.saveAntiqueBook(antiqueBook);
            return "redirect:/bookstore/antique-list";

        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);
            return "antique-add";
        }
    }

    @GetMapping(value = {"journal-add"})
    public String showAddScienceJournal(Model model) {
        ScienceJournal scienceJournal = new ScienceJournal();
        model.addAttribute("add", true);
        model.addAttribute("journal", scienceJournal);
        return "journal-add";
    }

    @PostMapping(value = "journal-add")
    public String addScienceJournal(Model model, @ModelAttribute("journal") ScienceJournal scienceJournal) {

        try {
            scienceJournalService.saveScienceJournal(scienceJournal);
            return "redirect:/bookstore/journal-list";

        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);
            return "journal-add";
        }
    }

    @GetMapping("book/edit/{barcode}")
    public String showEditBook(Model model, @PathVariable String barcode) {
        Book book = null;
        try {
            book = bookService.getBookByBarcode(barcode);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Book not found");
        }
        model.addAttribute("add", false);
        model.addAttribute("book", book);
        return "update-book";
    }

    @PostMapping("book/update/{barcode}")
    public String updateBook(Model model, @PathVariable String barcode, @ModelAttribute("book") Book book) {

        try {
            book.setBarcode(barcode);
            bookService.update(book);
            return "redirect:/bookstore/book-list/";

        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);
            return "update-book";
        }
    }

    @GetMapping("antique/edit/{barcode}")
    public String showEditAntiqueBook(Model model, @PathVariable String barcode) {
        Book book = null;
        try {
            book = bookService.getBookByBarcode(barcode);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Antique book not found");
        }
        model.addAttribute("add", false);
        model.addAttribute("book", book);
        return "update-journal";
    }

    @PostMapping("antique/update/{barcode}")
    public String updateAntiqueBook(Model model, @PathVariable String barcode, @ModelAttribute("book") Book book,
                                    AntiqueBook antiqueBook) {
        try {
            book.setBarcode(barcode);
            antiqueBookService.updateAntiqueBook(book, antiqueBook);
            return "redirect:/bookstore/antique-list/";

        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);
            return "update-antique";
        }
    }

    @GetMapping("journal/edit/{barcode}")
    public String showEditScienceJournal(Model model, @PathVariable String barcode) {
        Book book = null;
        try {
            book = bookService.getBookByBarcode(barcode);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Journal not found");
        }
        model.addAttribute("add", false);
        model.addAttribute("book", book);
        return "update-journal";
    }

    @PostMapping("journal/update/{barcode}")
    public String updateScienceJournal(Model model, @PathVariable String barcode, @ModelAttribute("book") Book book,
                                       ScienceJournal scienceJournal) {
        try {
            book.setBarcode(barcode);
            scienceJournalService.updateScienceJournal(book, scienceJournal);
            return "redirect:/bookstore/journal-list/";

        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);
            return "update-journal";
        }
    }


    @GetMapping("delete/{barcode}")
    public String deleteBook(@PathVariable("barcode") String barcode, Model model) {
        bookService.delete(barcode);
        model.addAttribute("books", bookService.getBooks());
        return "redirect:/bookstore/book-list";
    }

    @GetMapping("antique/delete/{barcode}")
    public String deleteAntiqueBook(@PathVariable("barcode") String barcode, Model model) {
        antiqueBookService.deleteByBarcode(barcode);
        model.addAttribute("books", antiqueBookService.getAllAntique());
        return "redirect:/bookstore/antique-list";
    }

    @GetMapping("journal/delete/{barcode}")
    public String deleteScienceJournal(@PathVariable("barcode") String barcode, Model model) {
        scienceJournalService.deleteByBarcode(barcode);
        model.addAttribute("books", scienceJournalService.getAllJournals());
        return "redirect:/bookstore/journal-list";
    }

}
