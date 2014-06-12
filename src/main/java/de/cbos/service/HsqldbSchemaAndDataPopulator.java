package de.cbos.service;

import javax.sql.DataSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Populates the configured datasource
 */
@Transactional
public class HsqldbSchemaAndDataPopulator implements InitializingBean {

	private JdbcTemplate template;
	
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(template, "dataSource required");

		template
			.execute("CREATE TABLE IF NOT EXISTS USERS(USERNAME VARCHAR(30) NOT NULL PRIMARY KEY,"
	                + "PASSWORD VARCHAR(50) NOT NULL,"
	                + "ENABLED BOOLEAN NOT NULL,"
	                + "EMAIL VARCHAR_IGNORECASE(50) NOT NULL,"
	                + "CITY VARCHAR(50) NOT NULL,"
	                + "BIRTHDAY DATETIME NOT NULL);");
		template
			.execute("CREATE TABLE IF NOT EXISTS AUTHORITIES(USERNAME VARCHAR_IGNORECASE(50) NOT NULL,AUTHORITY VARCHAR_IGNORECASE(50) NOT NULL,CONSTRAINT FK_AUTHORITIES_USERS FOREIGN KEY(USERNAME) REFERENCES USERS(USERNAME));");
        template
        	.execute("CREATE UNIQUE INDEX IX_AUTH_USERNAME ON AUTHORITIES(USERNAME,AUTHORITY);");
        
		template
		.execute("CREATE TABLE IF NOT EXISTS MODULES(MODULEID INTEGER NOT NULL PRIMARY KEY,"
				+ "MODULENAME VARCHAR(50) NOT NULL,"
                + "TYPE VARCHAR_IGNORECASE(50),"
				+ "PAGE INTEGER REFERENCES PAGE(PAGENAME));");
		
		template
		.execute("CREATE TABLE IF NOT EXISTS TEXTCONTAINERS(MODULEID INTEGER NOT NULL PRIMARY KEY,"
				+"HEADLINE VARCHAR(50)"
				+"CONSTRAINT FK_MODULES FOREIGN KEY REFERENCES MODULES(MODULEID));");
		
		template
		.execute("CREATE TABLE IF NOT EXISTS GUESTBOOKS(MODULEID INTEGER NOT NULL PRIMARY KEY,"
				+"CONSTRAINT FK_GUESTBOOKENTRIES FOREIGN KEY(MODULEID) REFERENCES GUESTBOOKENTRIES(MODULEID),"
				+"CONSTRAINT FK_MODULES FOREIGN KEY(MODULEID) REFERENCES MODULES(MODULEID));");
	
		template
		.execute("CREATE TABLE IF NOT EXISTS CONTENTS(CONTENTID INTEGER NOT NULL PRIMARY KEY,"
				+ "CONTENTNAME VARCHAR(50) NOT NULL,"
                + "CONTENTTYPE VARCHAR_IGNORECASE(50));");
		
		template
		.execute("CREATE TABLE IF NOT EXISTS GUESTBOOKENTRIES(CONTENTID INTEGER NOT NULL PRIMARY KEY,"
				+"GUESTBOOK INTEGER NOT NULL REFERENCES GUESTBOOK(MODULEID),"
				+"CONSTRAINT FK_CONTENTS FOREIGN KEY(CONTENTID) REFERENCES CONTENTS(CONTENTID));");
		
		template
		.execute("CREATE TABLE IF NOT EXISTS PARAGRAPHS(CONTENTID INTEGER NOT NULL PRIMARY KEY,"
				+"TEXT VARCHAR(50) NOT NULL,"
				+"CONSTRAINT FK_CONTENTS FOREIGN KEY(CONTENTID) REFERENCES CONTENTS(CONTENTID));");
		
		template
		.execute("CREATE TABLE IF NOT EXISTS PAGES(PAGENAME VARCHAR(50) NOT NULL PRIMARY KEY,"
				+"CONSTRAINT FK_MODULES FOREIGN KEY(MODULEID) REFERENCES MODULES(MODULEID));");
        /**
         *  hard coded admin
         */
        template
        	.execute("INSERT INTO USERS(USERNAME,PASSWORD,ENABLED,EMAIL,CITY,BIRTHDAY) VALUES ('admin','admin',TRUE,'Admin@sample.de','Adminhausen','31.12.1992');");
        template
    		.execute("INSERT INTO AUTHORITIES(USERNAME,AUTHORITY) VALUES ('admin','ROLE_ADMIN');");
        
        /**
         *  hard coded default page
         */
        template
        	.execute("INSERT INTO PAGES(PAGENAME) VALUES ('default')");
	}
	
	/**
	 * Load external dataSource
	 * @param dataSource
	 */
	public void setDataSource(final DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
}

