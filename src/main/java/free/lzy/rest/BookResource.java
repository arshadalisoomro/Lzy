package free.lzy.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import free.lzy.common.Code;
import free.lzy.common.FailResult;
import free.lzy.common.JSONFilter;
import free.lzy.entity.dto.Book;
import free.lzy.service.BookService;
import free.lzy.service.exception.ServiceException;

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
		HttpStatus status = HttpStatus.CREATED;
		
		String response = StringUtils.EMPTY;;
		if (!checkParam(book, false)) {
			status = HttpStatus.BAD_REQUEST;
			response = FailResult.toJson(Code.PARAM_ERROR, "数据验证失败");
		} else {
			bookService.add(book);
		}
		
		return Response.status(status.value()).entity(response).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		HttpStatus status = HttpStatus.OK;
		
		String repsonse = StringUtils.EMPTY;
		if (!checkParam(id)) {
			status = HttpStatus.BAD_REQUEST;
			repsonse = FailResult.toJson(Code.PARAM_ERROR, "Id有误");
		} else {
			bookService.delete(id);
		}
		
		return Response.status(status.value()).entity(repsonse).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Book book) throws Exception {
		HttpStatus status = HttpStatus.OK;
		
		String response = StringUtils.EMPTY;;
		if (!checkParam(book, true)) {
			status = HttpStatus.BAD_REQUEST;
			response = FailResult.toJson(Code.PARAM_ERROR, "数据验证失败");
		} else {
			bookService.update(book);
		}
		
		return Response.status(status.value()).entity(response).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response query(@PathParam("id") int id) throws ServiceException {
		HttpStatus status = HttpStatus.OK;
		
		String repsonse = StringUtils.EMPTY;
		if (!checkParam(id)) {
			status = HttpStatus.BAD_REQUEST;
			repsonse = FailResult.toJson(Code.PARAM_ERROR, "Id有误");
		} else {
			Book book = bookService.query(id);
			if (book != null) {
				repsonse = JSONObject.toJSONString(book, JSONFilter.NULLFILTER);
			} else {
				repsonse = FailResult.toJson(Code.PARAM_ERROR, "没有找到书籍");
				status = HttpStatus.NOT_FOUND;
			}
		}
		
		return Response.status(status.value()).entity(repsonse).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response queryAll() {
		HttpStatus status = HttpStatus.OK;
		String repsonse = JSONObject.toJSONString(bookService.queryAll(), JSONFilter.NULLFILTER);
		
		return Response.status(status.value()).entity(repsonse).build();
	}
	
	private boolean checkParam(Integer id) {
		return (id != null) && (id > 0);
	}
	
	private boolean checkParam(Book book, boolean isUpdate) {
		if (StringUtils.isEmpty(book.getName())) {
			return false;
		} 
		if (isUpdate) {
			return checkParam(book.getId());
		}
		
		return true;
	}
}