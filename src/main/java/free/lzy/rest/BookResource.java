package free.lzy.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import free.lzy.entity.bo.Code;
import free.lzy.entity.bo.JsonResult;
import free.lzy.service.BookService;

/**
 * Demo: Book Resource
 * @ClassName BookResources
 * @date 2015-10-15
 */
@Path("book")
@Component
public class BookResource {
	
	private static final Logger LOGGER = Logger.getLogger(BookResource.class);

	@Autowired
	private BookService bookService;
	
	@GET
	@Path("/queryBook/{id}")
	@Produces("application/json")
	public Response queryBook(@PathParam("id") int id) {
		JsonResult result = new JsonResult(false);
		try {
			result.setData(JSONObject.toJSONString(bookService.queryBook(id)));
			result.setCode(Code.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);

			result.setCode(Code.ERROR);
			result.setMsg("Error: " + e.getMessage());
		}
		
		return Response.status(200).entity(result.toString()).build();
	}
}
