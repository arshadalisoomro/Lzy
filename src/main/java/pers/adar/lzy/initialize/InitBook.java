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
package pers.adar.lzy.initialize;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pers.adar.lzy.entity.dto.Book;
import pers.adar.lzy.service.BookService;

@Component
public class InitBook {
	
	@Autowired
	private BookService bookService;
	
	@PostConstruct
	private void init() {
		bookService.deleteAll();
		bookService.add(books());
	}
	
	private List<Book> books() {
		List<Book> books = new ArrayList<Book>(5);
		
		Book book = new Book();
		book.setAuthor("Cay S.Horstmann");
		book.setName("JAVA核心技术 卷I:基础知识");
		book.setPrice(99f);
		books.add(book);
		
		book = new Book();
		book.setAuthor("Joshua Bloch");
		book.setName("Effective Java");
		book.setPrice(52f);
		books.add(book);
		
		book = new Book();
		book.setAuthor("Budi Kumiawan Paul Deck");
		book.setName("How Tomcat Works");
		book.setPrice(59f);
		books.add(book);
		
		book = new Book();
		book.setAuthor("Thomas H.cormen Charles E. Leiserson Ron");
		book.setName("Introduction to Algorithms");
		book.setPrice(128f);
		books.add(book);
		
		return books;
	}
}
