package just.CA225DEMO;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/books/")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    //requests
    //get all books
    @GetMapping("all")
    public Collection<Book> getbooks() {
        return service.getAllBooks();
    }

    //get book by id
    @GetMapping("{id}")
    public Book getbook(@PathVariable Long id) {
        return service.getBookById(id);
    }

    //save book
    @PostMapping
    public void save(@RequestBody Book newBook) {
        service.saveBook(newBook);
    }

    //update
    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public void update(@PathVariable Long id,
                       @RequestBody Book newBook) {
        service.update(id, newBook);
    }

    //delete
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.deleteBook(id);
    }
}
