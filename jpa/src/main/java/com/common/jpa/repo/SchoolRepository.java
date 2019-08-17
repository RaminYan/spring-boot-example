package com.common.jpa.repo;

import com.common.jpa.entity.School;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends CrudRepository<School, Integer> {
}
