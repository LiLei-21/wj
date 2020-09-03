package com.ll.wj.service;

import com.ll.wj.dao.BookDao;
import com.ll.wj.dao.CategoryDao;
import com.ll.wj.pojo.Book;
import com.ll.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10162496
 */
@Service
public class BookService {
    @Autowired
    BookDao bookDao;
    @Autowired
    CategoryService  categoryService;

    public List<Book> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return bookDao.findAll(sort);
    }

    public void addOrUpdate(Book book) {
        //当主键存在时更新数据，当主键不存在时插入数据。
        bookDao.save(book);
    }

    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

    public List<Book> listByCategory(int cid) {
        //通过分类查出书籍
        Category category = categoryService.get(cid);
        return bookDao.findAllByCategory(category);
    }

    public List<Book> Search(String keywords) {
        return bookDao.findAllByTitleIsLikeOrAuthorLike('%' + keywords + '%', '%' + keywords + '%');
    }


}
