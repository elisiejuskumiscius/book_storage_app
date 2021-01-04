package book.storage.app.service;

import book.storage.app.model.Book;
import book.storage.app.model.ScienceJournal;
import book.storage.app.repository.ScienceJournalRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ScienceJournalService {

    private final ScienceJournalRepository scienceJournalRepository;

    public ScienceJournalService(ScienceJournalRepository scienceJournalRepository) {
        this.scienceJournalRepository = scienceJournalRepository;
    }

    public List<Book> getAllJournals() {
        return scienceJournalRepository.findAllScienceJournals();
    }

    public void saveScienceJournal(ScienceJournal scienceJournal) { scienceJournalRepository.save(scienceJournal);}

    @Transactional
    public void updateScienceJournal(Book book, ScienceJournal scienceJournal) {
        scienceJournalRepository.updateAntiqueBook(book.getBarcode(), book.getName(), book.getQuantity(),
                book.getAuthor(), book.getPrice(), scienceJournal.getIndex());
    }

    @Transactional
    public void deleteByBarcode(String barcode) {
        scienceJournalRepository.deleteScienceJournalByBarcode(barcode);
    }
}
