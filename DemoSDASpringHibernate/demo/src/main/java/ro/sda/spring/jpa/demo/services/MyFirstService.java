package ro.sda.spring.jpa.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ro.sda.spring.jpa.demo.persistance.Books;
import ro.sda.spring.jpa.demo.persistance.BooksRepository;

import java.util.Optional;

@Service
public class MyFirstService implements CommandLineRunner {

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public void run(String... args) throws Exception {
        Optional<Books> searchedBook= booksRepository.findById(1L);
        if (searchedBook.isEmpty()) {
            Books newBook = new Books(1L, "Abcd", "Popescu");
            booksRepository.save(newBook);
        }
        else {
           Books updateBook = searchedBook.get();
           updateBook.setTitle("Updated Book " + System.currentTimeMillis());
           if(updateBook.getAuthor()==null){

               updateBook.setAuthor("Popescu");
           }
           booksRepository.save(updateBook);
        }



    }
}
