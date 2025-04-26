package just.CA225DEMO;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    Map<Long , Book> books  = new ConcurrentHashMap<>();

    private AtomicLong autoId = new AtomicLong();

    //operations
    //get all books
    public Collection<Book> getAllBooks(){
        return books.values();
    }

    //get book by id
    public Book getBookById(Long id){
        return books.get(id);
    }

    //save book
    public void saveBook(Book newBook){
        //check if the id is null
        Long bookId = newBook.getId() != null
                ? newBook.getId()
                : autoId.incrementAndGet();
        newBook.setId(bookId);
        books.put(bookId, newBook);
    }

    //update
    public void update(Long id , Book newBook){
        if(books.containsKey(id)){
            Book oldbook = getBookById(id);

            oldbook.setTitle(newBook.getTitle());
            oldbook.setAuthor(newBook.getAuthor());

            books.put(id , oldbook);
        }
    }

    //delete
    public void deleteBook(Long id){
        books.remove(id);
    }
}
