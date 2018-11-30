package com.yuanmaxinxi.service.persontype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanmaxinxi.dao.persontype.PersonTypeDAO;
import com.yuanmaxinxi.domain.person.PersonType;
@Service
public class PersonTypeService{
	@Autowired
	private PersonTypeDAO personTypeDAO;

	public PersonType selectOneById(Long id) {
		return personTypeDAO.selectOneById(id);
	}
	public List<PersonType> selectAll() {
		return personTypeDAO.selectAll();
	}
}
