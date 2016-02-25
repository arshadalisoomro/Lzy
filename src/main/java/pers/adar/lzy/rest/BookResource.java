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
package pers.adar.lzy.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pers.adar.lzy.common.Code;
import pers.adar.lzy.common.FailResult;
import pers.adar.lzy.entity.dto.Book;
import pers.adar.lzy.service.BookService;
import pers.adar.lzy.service.exception.ServiceException;

/**
 * Demo: Book Resource
 */
@Path("book")
@Component
public class BookResource {

	@Autowired
	private BookService bookService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Book book) throws Exception {
		if (!checkParam(book, false)) {
			return Response.status(Status.BAD_REQUEST).build();
		} else {
			bookService.add(book);
			return Response.status(Status.CREATED).build();
		}
	}

	@DELETE
	@Path("{id: [1-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		bookService.delete(id);
		
		return Response.status(Status.ACCEPTED).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Book book) throws Exception {
		if (!checkParam(book, true)) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		bookService.update(book);
			
		return Response.status(Status.ACCEPTED).build();
	}

	@GET
	@Path("{id: [1-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response query(@PathParam("id") int id) throws ServiceException {
		Book book = bookService.query(id);
		if (book == null) {
			return Response.status(Status.NOT_FOUND).entity(FailResult.toJson(Code.NOT_EXSIT, "没有找到相关书籍")).build();
		}

		return Response.ok(book).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> queryAll() {
		return bookService.queryAll();
	}

	private boolean checkParam(Book book, boolean isUpdate) {
		if (StringUtils.isEmpty(book.getName())) {
			return false;
		}
		if (isUpdate) {
			return (book.getId() != null) && (book.getId() > 0);
		}

		return true;
	}
}