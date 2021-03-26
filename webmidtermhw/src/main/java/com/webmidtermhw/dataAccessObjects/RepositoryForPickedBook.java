package com.webmidtermhw.dataAccessObjects;

import com.webmidtermhw.model.Entities.Book;
import com.webmidtermhw.model.Entities.PickedBook;
import com.webmidtermhw.model.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryForPickedBook extends CrudRepository<PickedBook, Long> {
    PickedBook findByBookAndUserAndDroppedOff(Book book, User user, boolean droppedOff);
    List<PickedBook> findByUser(User book);
    List<PickedBook> findByUserAndDroppedOff(User book, boolean droppedOff);
}
