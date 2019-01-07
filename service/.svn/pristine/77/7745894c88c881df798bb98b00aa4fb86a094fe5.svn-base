import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 不要再这里面写测试
 * @author Administrator
 *
 */
public class Start {

	public static void main(String[] args) throws IOException {
		System.out.println("进入MAIN");
		ClassPathXmlApplicationContext  context=new ClassPathXmlApplicationContext("spring/spring-service.xml","spring/spring-dao.xml","spring/spring-redis.xml","spring/spring-dubbo.xml");
		System.out.println("准备启动");
		context.start();
		System.out.println("启动成功");
		System.in.read();
		
	}
}
