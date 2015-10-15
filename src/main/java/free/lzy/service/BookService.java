package free.lzy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import free.lzy.dao.BookDao;
import free.lzy.entity.dto.Book;

/**
 * Demo: BookService
 * @ClassName BookService
 * @date 2015-10-15
 */
@Service
public class BookService {

	@Resource
	private BookDao bookDao;
	
	public Book queryBook(int id) {
		return bookDao.queryBook(id);
	}
}
