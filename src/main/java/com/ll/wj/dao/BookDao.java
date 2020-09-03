package com.ll.wj.dao;

import com.ll.wj.pojo.Book;
import com.ll.wj.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 10162496
 */
public interface BookDao extends JpaRepository<Book,Integer> {
    /**
     *
     * @param category
     * @return
     */
    List<Book> findAllByCategory(Category category);

    /**
     *
     * @param keyword1
     * @param keyword2
     * @return
     */
    List<Book> findAllByTitleIsLikeOrAuthorLike(String keyword1, String keyword2);
}
