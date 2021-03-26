package com.webmidtermhw.dataAccessObjects;

import com.webmidtermhw.model.Entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryForBookCategory extends CrudRepository<Category, Long> {
}
