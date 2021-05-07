package de.netempire.movie_library.jpa;

import de.netempire.movie_library.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}