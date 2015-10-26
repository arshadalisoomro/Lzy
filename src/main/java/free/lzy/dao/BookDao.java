package free.lzy.dao;

import free.lzy.entity.dto.Book;

/**
 * Demo: Book Dao
 */
public interface BookDao {

	/**
	 * 新增书籍
	 * @Title: addBook 
	 * @param book
	 */
	public void addBook(Book book);
	
	/**
	 * 根据ID查询书籍
	 * @Title: queryBook 
	 * @param id
	 * @return Book
	 */
	public Book queryBook(int id);
}
