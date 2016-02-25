

# Lzy
> A simple web framework (Restful).


#####Base Component
	Maven
	
	Jetty-9.0.0.RC0

	Spring-3.2.0.RELEASE
	Jersey-1.4
	Spring-data-JPA-1.3.0.RELEASE
	
	Mysql-connector-5.1.6
	C3p0-0.9.1
	
	Slf4j-1.7.0
	Fastjson-1.2.6
	
	...


####Run demo
	1. Create database	

	2. Modify "filters/dev/jdbc.propertis"	
	
	3. Maven build: jetty:run
	
	4. Access path (Get):
			http://localhost:8080/Lzy/services/book
			http://localhost:8080/Lzy/services/book/1
			http://localhost:8080/Lzy/services/book/-1
			http://localhost:8080/Lzy/services/book/200
			...
			
	5. Example rest code:
			pers.adar.lzy.rest.BookResource
				add(Post)
				delete(Delete)
				update(Put)
				query(Get)
				queryAll(Get)

