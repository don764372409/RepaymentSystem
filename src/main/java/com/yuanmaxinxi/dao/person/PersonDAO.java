package com.yuanmaxinxi.dao.person;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.yuanmaxinxi.domain.person.Person;
@Mapper
@Repository
public interface PersonDAO {
	int insert(Person obj);
	int delete(Long id);

	Person selectOneById(Long id);

	List<Person> selectAll();
	int update(Person obj);
}
