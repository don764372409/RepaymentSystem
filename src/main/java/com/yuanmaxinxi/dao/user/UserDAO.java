package com.yuanmaxinxi.dao.user;
import com.yuanmaxinxi.domain.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface UserDAO{
	int insert(User obj);

	int update(User obj);

	int delete(Long id);

	User selectOneById(Long id);

	List<User> selectAll();
	
	User selectOneByUsername(String username);

	int updatePassword(User loginUser);


}