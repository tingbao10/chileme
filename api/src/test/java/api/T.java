package api;

import static org.junit.Assert.*;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.chilema.api.util.Request;

public class T {

	@Test
	public void test() {
		User us=new User();
		us.setAge(1);
		us.setName("yxy");
		
		Request q=new Request();
		try {
			q.setRequestObject(us);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			User u= (User) q.getRequestObject(User.class);
//			System.out.println(u);
//		} catch (IllegalAccessException | InstantiationException | InvocationTargetException
//				| IntrospectionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
