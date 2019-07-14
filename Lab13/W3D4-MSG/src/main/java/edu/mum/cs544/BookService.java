package edu.mum.cs544;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {
    @Resource
    private IBookDao BookDao;
    
    public List<Book> getAll() {
        return BookDao.findAll();
    }

    public int add(Book Book) {
        return BookDao.save(Book).getId();
    }

    public Book get(int id) {
        return BookDao.findById(id).get();
    }

    public void update(Book Book) {
        BookDao.save(Book);
    }

    public void delete(Integer id) {
        BookDao.deleteById(id);
    }
}