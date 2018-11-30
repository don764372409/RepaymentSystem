package com.yuanmaxinxi.dao.persontype;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.yuanmaxinxi.domain.person.PersonType;
@Mapper
@Repository
public interface PersonTypeDAO {
	PersonType selectOneById(Long id);
	List<PersonType> selectAll();
}
