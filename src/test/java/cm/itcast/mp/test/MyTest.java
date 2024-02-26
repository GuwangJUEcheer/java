package cm.itcast.mp.test;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.itcast.mp.MyApplication;
import cn.itcast.mp.mapper.UserMapper;
import cn.itcast.mp.model.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class})
public class MyTest {

	@Autowired
	private UserMapper userMapper;
	
    @Test
    public void testSomething() {
         //测试逻辑
    	 //创建一个 UserInfo 对象
        UserInfo userInfo = new UserInfo();
        userInfo.setId(UUID.randomUUID().toString());
        userInfo.setCreateTime(LocalDateTime.now(ZoneId.of("Asia/Tokyo")).toString());
        userInfo.setUpdateTime(LocalDateTime.now(ZoneId.of("Asia/Tokyo")).toString());
        userInfo.setUsername("JohnDoe");
        userInfo.setAge(30);
        userInfo.setTelephone("1234567890");
        userInfo.setEmail("adada@example.com");
        userInfo.setSex("Male");
        userInfo.setAddress("123 Main Street");
        userMapper.insertUser(userInfo);
    }
    
//    public static void main(String[] args) {
//		
//    	try {
//			TimerUtils.newSchedule(()->{
//				System.out.println("run time" + new Date().toLocaleString());
//			}, "2024-02-06 14:54:00", (long) 2000);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}

