package com.webmidtermhw.dataAccessObjects;

import com.webmidtermhw.model.Entities.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryForCourse extends CrudRepository<Course, Long> {
}
