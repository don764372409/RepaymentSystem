package com.yuanmaxinxi.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.yuanmaxinxi.util.MD5Util;
import org.springframework.util.ResourceUtils;

/**
 * 当前项目的基本数据工具类
 * @author HOME
 *1.创建  t_user,t_borrower,t_content
 *2.t_user表添加一条基础数据 账号admin   密码:useradmin9527
 */
public class DBUtil {

	public static void createTableBaseData() {
		try {
			Class.forName("org.apache.derby.jdbc.AutoloadedDriver");
			File file = ResourceUtils.getFile("classpath:database");
			String databasePath = file.getPath()+"/repayment";
			System.err.println(databasePath);
			Connection conn = DriverManager.getConnection("jdbc:derby:C:\\Users\\Administrator\\Desktop\\database\repayment;create=true;");
			String sql = "CREATE TABLE t_user (\r\n" + 
					"  id bigint NOT NULL generated by default as identity,\r\n" + 
					"  username varchar(12) NOT NULL,\r\n" + 
					"  password varchar(100) NOT NULL,\r\n" + 
					"  PRIMARY KEY (id)\r\n" + 
					")";
			PreparedStatement state = conn.prepareStatement(sql);
			state.execute();
			sql = "CREATE TABLE t_borrower (\r\n" + 
					"  id bigint NOT NULL generated by default as identity,\r\n" + 
					"  name varchar(255) DEFAULT NULL,\r\n" + 
					"  phone varchar(255) NOT NULL,\r\n" + 
					"  loanTime date NOT NULL,\r\n" + 
					"  repaymentTime date NOT NULL," + 
					"  PRIMARY KEY (id)\r\n" + 
					")";
			state = conn.prepareStatement(sql);
			state.execute();
			sql = "CREATE TABLE t_content (\r\n" + 
					"  id bigint NOT NULL generated by default as identity,\r\n" + 
					"  content varchar(255) NOT NULL,\r\n" + 
					"  defaultUse int NOT NULL," + 
					"  PRIMARY KEY (id)\r\n" + 
					")";
			state = conn.prepareStatement(sql);
			state.execute();
			sql = "CREATE TABLE t_sms (\r\n" + 
					"  id bigint NOT NULL generated by default as identity,\r\n" + 
					"  phone varchar(255) NOT NULL,\r\n" + 
					"  sendTime TIMESTAMP NOT NULL," + 
					"  brrId bigint NOT NULL," + 
					"  status int NOT NULL," + 
					"  PRIMARY KEY (id)\r\n" + 
					")";
//			sql = "drop table t_sms";
			state = conn.prepareStatement(sql);
			state.execute();
			sql = "insert into t_user(username,password)values(?,?)";
			state = conn.prepareStatement(sql);
			state.setObject(1, "admin");
			state.setObject(2,MD5Util.encode("useradmin9527"));
			state.executeUpdate();
			System.err.println("sql执行成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
