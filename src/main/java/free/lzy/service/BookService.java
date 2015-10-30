package free.lzy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import free.lzy.dao.BookDao;
import free.lzy.entity.dto.Book;

/**
 * Demo: BookService
 */
@Service
public class BookService {

	@Resource
	private BookDao bookDao;
	
	public void add(Book book) {
		bookDao.add(book);
	}

	public void delete(int id) {
		bookDao.delete(id);
	}

	public void update(Book book) {
		bookDao.update(book);
	}
	
	public Book query(int id) {
		return bookDao.query(id);
	}
	
	public List<Book> queryAll() {
		return bookDao.queryAll();
	}
}
