/**
 * Copyright (c) 2015, adar.w (adar.w@outlook.com) 
 * 
 * http://www.adar-w.me
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pers.adar.lzy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.adar.lzy.entity.dto.Book;
import pers.adar.lzy.repository.BookRepository;

/**
 * Demo: BookService
 */
@Service
public class BookService {

	@Resource
	private BookRepository bookDao;
	
	public void add(Book book) {
		bookDao.save(book);
	}

	public void delete(int id) {
		bookDao.delete(id);
	}

	public void update(Book book) {
		bookDao.save(book);
	}
	
	public Book query(int id) {
		return bookDao.findOne(id);
	}
	
	public List<Book> queryAll() {
		return bookDao.findAll();
	}
}
