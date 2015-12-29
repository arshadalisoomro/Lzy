package free.lzy.dao.base;

import java.util.List;

public interface BaseDao<T> {

	void add(T entity);
	
	void addBatch(List<T> entitys);
	
	void delete(int id);
	
	void update(T entity);
	
	T query(int id);
	
	List<T> queryMatch(T entity);
	
	List<T> queryAll();
}
