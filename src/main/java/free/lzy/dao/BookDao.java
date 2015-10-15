package free.lzy.dao;

import free.lzy.entity.dto.Book;

/**
 * Demo: Book Dao
 * @ClassName BookDao
 * @date 2015-10-15
 */
public interface BookDao {

	/**
	 * 新增书籍
	 * @Title: addBook 
	 * @param book
	 * @Date 2015-10-15
	 */
	public void addBook(Book book);
	
	/**
	 * 根据ID查询书籍
	 * @Title: queryBook 
	 * @param id
	 * @return Book
	 * @Date 2015-10-15
	 */
	public Book queryBook(int id);
}
