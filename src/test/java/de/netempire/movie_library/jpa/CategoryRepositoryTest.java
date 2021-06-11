package de.netempire.movie_library.jpa;

import de.netempire.movie_library.actor.Actor;
import de.netempire.movie_library.category.Category;
import de.netempire.movie_library.movie.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    private Category category;

    @BeforeEach
    public void setUp() {

        categoryRepository.deleteAll();
        category = new Category();
        category.setDesignation("Action");
        categoryRepository.save(category);
    }

    @AfterEach
    public void tearDown() {
        categoryRepository.deleteAll();
    }

    @Test
    void findAll() {

        List<Category> categoryList = categoryRepository.findAll();

        assertNotNull(categoryList);
        assertEquals(1, categoryList.size());
        assertEquals(category, categoryList.get(0));

    }
}