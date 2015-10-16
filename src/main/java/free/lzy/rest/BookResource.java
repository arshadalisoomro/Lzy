package free.lzy.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import free.lzy.common.Code;
import free.lzy.common.FailResult;
import free.lzy.entity.dto.Book;
import free.lzy.service.BookService;
import free.lzy.service.exception.ServiceException;

/**
 * Demo: Book Resource
 * @ClassName BookResources
 * @date 2015-10-15
 */
@Path("book")
@Component
public class BookResource {
	
	@Autowired
	private BookService bookService;
	
	@GET
	@Path("/queryBook/{id}")
	@Produces("application/json")
	public Response queryBook(@PathParam("id") int id) throws ServiceException {
		HttpStatus status = HttpStatus.OK;

		String repsonse = null;
		// 参数验证
		if (!checkParam(id)) {
			status = HttpStatus.BAD_REQUEST;
			repsonse = FailResult.toJson(Code.PARAM_ERROR, "Id有误");
		} else {
			// 调用业务层处理
			Book book = bookService.queryBook(id);
			if (book != null) {
				repsonse = JSONObject.toJSONString(book);
			} else {
				repsonse = FailResult.toJson(Code.PARAM_ERROR, "没有找到书籍");
				status = HttpStatus.NOT_FOUND;
			}
		}
		
		return Response.status(status.value()).entity(repsonse).build();
	}
	
	/**
	 * 参数验证
	 * @Title: checkParam 
	 * @param id
	 * @return true/false 通过/不通过
	 * @Date 2015-10-16
	 */
	private boolean checkParam(int id) {
		return id > 0;
	}
}