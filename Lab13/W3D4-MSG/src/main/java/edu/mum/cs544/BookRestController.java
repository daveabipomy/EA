package edu.mum.cs544;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BookRestController {

    @Resource
    BookService bookService;

    @GetMapping("/Books")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/Books/{id}")
    public Book get(@PathVariable int id) {
        return bookService.get(id);
    }

    @PostMapping("/Books/")
    public RedirectView add(@RequestBody Book book) {
        int id = bookService.add(book);
        return new RedirectView("/Books/" + id);
    }

    @PutMapping("/Books/{id}")
    public void update(@PathVariable int id, @RequestBody Book book) {
        if (id != book.getId()) {
            throw new IllegalArgumentException();
        }
        bookService.update(book);
    }

    @DeleteMapping(value = "/Books/{id}")
    public void delete(@PathVariable int id) {
        bookService.delete(id);
    }
}
