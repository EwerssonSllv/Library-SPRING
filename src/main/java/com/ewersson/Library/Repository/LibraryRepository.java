package com.ewersson.Library.Repository;

import com.ewersson.Library.Model.Library.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
}
