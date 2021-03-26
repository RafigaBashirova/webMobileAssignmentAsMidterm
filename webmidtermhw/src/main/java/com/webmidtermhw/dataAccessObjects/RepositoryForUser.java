package com.webmidtermhw.dataAccessObjects;

import com.webmidtermhw.model.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryForUser extends CrudRepository<User, Long> {
    User findByEmail(String email);
    Boolean existsByEmail(String email);
}
