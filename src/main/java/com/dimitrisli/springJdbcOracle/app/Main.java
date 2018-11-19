package com.dimitrisli.springJdbcOracle.app;

import com.dimitrisli.springJdbcOracle.dao.LocationDao;
import com.dimitrisli.springJdbcOracle.model.Location;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/context/applicationContext.xml");
        BasicDataSource bds = (BasicDataSource) context.getBean("dataSource");


        LocationDao personDAO = context.getBean(LocationDao.class);

        Location person = new Location();
        //personDAO.save(person);
        System.out.println("Person::"+person);

         List<String> list = personDAO.getLocations();
          for(String p : list){
               System.out.println("Person List::"+p);
            }
        //close resources
        context.close();
    }



}
