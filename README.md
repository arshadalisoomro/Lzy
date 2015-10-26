

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
	1. Modify "jdbc.propertis"
	2. Exec "file/demo_db.sql"
	3. Deployed to the server(Tomcat)
	4. Access path:
			http://localhost:8080/Lzy/services/book/queryBook/1
			http://localhost:8080/Lzy/services/book/queryBook/-1
			http://localhost:8080/Lzy/services/book/queryBook/2
	5. Open Authentication & Access log
			modify web.xml 


