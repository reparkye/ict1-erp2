package com.ict.erp;
 import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
 import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 import javax.sql.DataSource;
 import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 import com.ict.erp.vo.LevelInfo;

 @RunWith(SpringJUnit4ClassRunner.class)

 @ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

 public class DBTest {

 @Autowired

 @Qualifier("dataSourceProxy")

 private DataSource ds;

 @Autowired

 private SqlSessionFactory ssf;

 @Autowired

 private SqlSession ss;

 @Test

 public void test() {

 try {

 Connection con=ds.getConnection();

 System.out.println("DB test ok");

 assertNotNull(con);

 } catch (SQLException e) {

 fail(e.getMessage());

 }    }



 @Test

 public void ssfTest() {

 try(SqlSession ss= ssf.openSession()) {

 System.out.println("Sql Session test ok");

 } catch (Exception e) {

 fail(e.getMessage());

 }    }

 @Test

 public void ssTest() {

 assertNotNull(ss);

 List<LevelInfo> liList= ss.selectList("SQL.LEVELINFO.selectLevelInfoList");

 assertEquals(liList.size(),3);

 }    }
 
 
 