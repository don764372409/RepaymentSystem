package com.yuanmaxinxi.service.user;
import com.yuanmaxinxi.domain.user.User;
import com.yuanmaxinxi.util.MD5Util;
import com.yuanmaxinxi.dao.user.UserDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class UserService{
	@Autowired
	private UserDAO userDAO;
	@Transactional
	public int insert(User obj){
		return userDAO.insert(obj);
	}


	@Transactional
	public void updatePhone(User obj){
		if (obj.getId()==null||obj.getId()<=0) {
			throw new RuntimeException("非法访问");
		}
		int i = userDAO.updatePhone(obj);
		if (i!=1) {
			throw new RuntimeException("密码修改失败!");
		}
	}


	@Transactional
	public int delete(Long id){
		return userDAO.delete(id);
	}


	public User selectOneById(Long id){
		return userDAO.selectOneById(id);
	}


	public List<User> selectAll(){
		return userDAO.selectAll();
	}
	/**
	 * 登录业务
	 * @param user
	 */
	public User login(User user) {
		User sysUser = userDAO.selectOneByUsername(user.getUsername());
		if (sysUser==null) {
			throw new RuntimeException("账号不存在.");
		}
		String password = MD5Util.encode(user.getPassword());
		if (!sysUser.getPassword().equals(password)) {
			throw new RuntimeException("密码错误.");
		}
		return sysUser;
	}
	@Transactional
	public User updatePassword(User loginUser, User user) {
		if (loginUser.getPassword().equals(user.getPassword())) {
			throw new RuntimeException("新旧密码不能一致!");
		}
		String password = MD5Util.encode(user.getPassword());
		loginUser.setPassword(password);
		int i = userDAO.updatePassword(loginUser);
		if (i!=1) {
			throw new RuntimeException("密码修改失败!");
		}
		return loginUser;
	}
}