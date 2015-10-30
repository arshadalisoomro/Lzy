package free.lzy.dao.base;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * 新增Entity
	 * @Title: add 
	 * @param entity
	 */
	public void add(T entity);
	
	/**
	 * 删除Entity
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 修改Entity
	 * @param book
	 */
	public void update(T entity);
	
	/**
	 * 根据ID查询Entity
	 * @Title: queryById 
	 * @param id
	 * @return Entity
	 */
	public T query(int id);
	
	/**
	 * 查询所有Entity
	 * @Title: queryAll 
	 * @param id
	 * @return lstEntity
	 */
	public List<T> queryAll();
	
}
