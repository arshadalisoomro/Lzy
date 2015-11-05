

# Lzy
> A simple framework (Restful).


#####Base Component
	Maven

	Spring-3.2.0.RELEASE
	Jersey-1.4
	Mybatis-3.1.1
	
	Mysql-connector-5.1.6
	C3p0-0.9.1
	
	Fastjson-1.2.6
	Log4j-1.2.17
	
	...


####Run demo
	1. Exec "file/lzy_db.sql"
	
	2. Modify "filters/dev/jdbc.propertis"	
	
	3. Deployed to the server(Tomcat)
	
	4. Access path (Get):
			http://localhost:8080/Lzy/services/book
			http://localhost:8080/Lzy/services/book/1
			http://localhost:8080/Lzy/services/book/-1
			http://localhost:8080/Lzy/services/book/200
			...
			
	5. Open LoginFilter
			modify web.xml 
			
	6. Example rest code:
			free.lzy.rest.BookResource
				add(Post)
				delete(Delete)
				update(Put)
				query(Get)
				queryAll(Get)

