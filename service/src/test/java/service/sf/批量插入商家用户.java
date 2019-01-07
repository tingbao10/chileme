package service.sf;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.chilema.util.MD5Util;
import com.chilema.util.UUIDUtil;

public class 批量插入商家用户 {
	public static void main(String[] args) throws UnsupportedEncodingException {

		/**
		 * 往数据库批量添加数据
		 */

		// 加载数据库驱动，注册到去送管理器 0-
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/chilema?useUnicode=true&characterEncoding=UTF-8";

		String username = "root";

		String password = "123456789";

		try {
			Connection conn = DriverManager.getConnection(url, username, password);

			// 批量插入商家 用户
			for (int i = 1; i < 100; i++) {
				String ret = "";
				for (int sb = 0; sb < 2; sb++) {
					String str = null;
					int hightPos, lowPos; // 定义高低位
					Random random = new Random();
					hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
					lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
					byte[] b = new byte[2];
					b[0] = (new Integer(hightPos).byteValue());
					b[1] = (new Integer(lowPos).byteValue());
					try {
						str = new String(b, "GBk"); // 转成中文

					} catch (UnsupportedEncodingException ex) {
						ex.printStackTrace();
					}
					ret += str;

				}
				System.out.println(ret);

				String dianp2 = ret + "咖喱";

				String dianp = dianp2;
				// dianp = new String(dianp2.getBytes("iso-8859-1"),"utf-8");
				// //改变编码

				String tupian = "shefengpage/img/dianpu.jpg";
				Statement stmt = conn.createStatement(); // 创建Statement对象

				// MD5Util.encrypt16(i);
				String sb = i + "";
				String pass = MD5Util.encrypt16(sb);

				String uuid = UUIDUtil.getUUID();// 用户
				String uuid2 = UUIDUtil.getUUID();// 商家
				String uuid3 = UUIDUtil.getUUID();// 菜单ID

				String sql2 = "insert into user (loginUser,password,userId) values(" + "'" + i + "'" + "," + "'" + pass
						+ "'" + "," + "'" + uuid + "'" + ")";
				System.out.println(sql2);
				String sql = "insert into shop (shopId,userId,shopName,trademark) values(" + "'" + uuid2 + "'" + ","
						+ "'" + uuid + "'" + "," + "'" + dianp + "'" + "," + "'" + tupian + "'" + ")";

				System.out.println(sql);

				stmt.executeUpdate(sql2);
				stmt.executeUpdate(sql);

				// 根据菜单ID 添加一大推废物菜品
				for (int j = 1; j < 30; j++) {
					String uuid4 = UUIDUtil.getUUID();// 菜单ID
					String maocai = "冒菜";
					String jiage = "77";
					String tupian1 = "图片别管 就是用上面的";
					String uiuajsdhjashdaklsdhajsd = "insert into menu (menuId,name,price,img) values(" + "'" + uuid4
							+ "'" + "," + "'" + maocai + i + "'" + "," + "'" + jiage + i + "'" + "," + "'" + tupian
							+ "'" + ")";

					stmt.executeUpdate(uiuajsdhjashdaklsdhajsd);

					// 妈卖批. 必须中间表添加数据
					/*
					 * menuId 菜单ID shopId 商店ID
					 */
					String sql3 = "insert into shop_menu (menuId,shopId) values(" + "'" + uuid4 + "'" + "," + "'"
							+ uuid2 + "'" + ")";
					System.out.println(sql3);

					stmt.executeUpdate(sql3);
				}

				/*
				 * //这里是添加商家上传的菜品 for(int o=1;o<10;o++){ String sql3 =
				 * "insert into menu (shopId,userId,shopName,trademark) values("
				 * + "'" + uuid2 + "'" + "," + "'" + uuid + "'" + "," + "'" +
				 * dianp + "'" + "," + "'" + tupian + "'" + ")"; }
				 */

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getChinese() {
		String str = null;
		int highPos, lowPos;
		Random random = new Random();
		highPos = (176 + Math.abs(random.nextInt(71)));// 区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字
		random = new Random();
		lowPos = 161 + Math.abs(random.nextInt(94));// 位码，0xA0打头，范围第1~94列

		byte[] bArr = new byte[2];
		bArr[0] = (new Integer(highPos)).byteValue();
		bArr[1] = (new Integer(lowPos)).byteValue();
		try {
			str = new String(bArr, "utf-8"); // 区位码组合成汉字
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
}
