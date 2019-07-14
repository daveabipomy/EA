package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping("/")
    public String redirectRoot() {
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getAll(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "bookList";    }

//    @PostMapping("/books")
//    public String add(@ModelAttribute("book") @Valid Book book, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
//        if(result.hasErrors()){
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.Book", result);
//            redirectAttributes.addFlashAttribute("book", book);
//            model.addAttribute("msg", "Add");
//            return "redirect:/books/add";
//        }
//        bookService.add(book);
//        return "redirect:/books";
//    }

    @PostMapping("/books/add")
    public String add(@Valid Book Book, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.Book", result);
            redirectAttributes.addFlashAttribute("book", Book);
            model.addAttribute("msg", "Add");
            return "redirect:/books/add";
        }
        bookService.add(Book);
        return "redirect:/books";
    }


    @GetMapping("/books/add")
    public String viewAdd(@ModelAttribute("book") Book book, Model model) {
        model.addAttribute("msg", "Add");
        return "bookDetail";
    }
    @GetMapping("/books/{id}")
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.get(id));
        model.addAttribute("msg", "Update");
        return "bookDetail";
    }

    @PostMapping("/books/{id}")
    public String update(@Valid Book book, BindingResult result, @PathVariable int id, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.Book", result);
            redirectAttributes.addFlashAttribute("Book", book);
            return "redirect:/books/{id}";
        }
        bookService.update(book);
        return "redirect:/books";
    }

    @PostMapping(value="/books/delete")
    public String delete(int bookId) {
        bookService.delete(bookId);
        return "redirect:/books";
    }
}
