package com.webmidtermhw.dataAccessObjects;

import com.webmidtermhw.model.Entities.Book;
import com.webmidtermhw.model.Entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryForBook extends CrudRepository<Book, Long> {
    Book findFirstByNameAndCategory(String bookName, Category category);
    Book findFirstByNameAndCategoryAndAuthor(String bookName, Category category, String author);
}
