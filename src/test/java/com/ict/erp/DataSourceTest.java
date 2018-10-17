//package com.ict.erp;
// import java.util.List;
// import org.apache.ibatis.session.SqlSession;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// import com.ict.erp.vo.LevelInfo;
// @RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//public class DataSourceTest {
// 	@Autowired
//	private SqlSession ss;
//	
//	@Test
//	public void test() {
//		LevelInfo li = new LevelInfo();
//		li.setLidesc("일반사용자");
//		li.setLiname("일반");
//		li.setLilevel(1);
//		List<LevelInfo> liList = ss.selectList("SQL.LEVELINFO.selectLevelInfo",li);
//		
//		for(LevelInfo li2 : liList) {
//			System.out.println(li2);
//		}
//	}
// }