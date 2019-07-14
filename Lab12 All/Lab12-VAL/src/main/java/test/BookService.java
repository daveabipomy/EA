package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    private IBookDao bookDao;
    public List<Book> getAll() {
        return bookDao.findAll();
    }

    public void add(Book book) {

        bookDao.save(book);
    }

    public Book get(int id) {
        Book book=bookDao.getOne(id);
        return  book;
    }

    public void update(Book book) {
        bookDao.save(book);
    }

    public void delete(int id) {
        bookDao.deleteById(id);
    }
}
