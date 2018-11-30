package com.yuanmaxinxi.service.person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.person.PersonDAO;
import com.yuanmaxinxi.dao.persontype.PersonTypeDAO;
import com.yuanmaxinxi.domain.person.Person;
import com.yuanmaxinxi.domain.person.PersonType;
import com.yuanmaxinxi.domain.user.User;
import com.yuanmaxinxi.util.StringUtil;
@Service
public class PersonService{
	@Autowired
	private PersonDAO personDAO;
	@Autowired
	private PersonTypeDAO personTypeDAO;
	@Transactional
	public void insert(Person obj) {
		if (!StringUtil.isNotNullAndEmpty(obj.getName())) {
			throw new RuntimeException("姓名不能为空");
		}
		if (!StringUtil.isNotNullAndEmpty(obj.getPhone())) {
			throw new RuntimeException("电话不能为空");
		}
		if (obj.getTypeId()==null||obj.getTypeId()<0) {
			throw new RuntimeException("请选择一个类别");
		}
		int i = personDAO.insert(obj);
		if (i!=1) {
			throw new RuntimeException("用户添加失败,请稍后重试.");
		}
	}
	@Transactional
	public void delete(Long id) {
		if (id==null||id<0) {
			throw new RuntimeException("非法访问.");
		}
		int i = personDAO.delete(id);
		if (i!=1) {
			throw new RuntimeException("用户删除失败,请稍后重试.");
		}
	}

	public Person selectOneById(Long id) {
		return personDAO.selectOneById(id);
	}

	public List<Person> selectAll() {
		List<Person> list = personDAO.selectAll();
		Map<Long,PersonType> cash = new HashMap<>();
		for (Person person : list) {
			Long typeId = person.getTypeId();
			PersonType pt= cash.get(typeId);
			if (pt==null) {
				pt = personTypeDAO.selectOneById(typeId);
				cash.put(typeId, pt);
			}
			person.setType(pt);
		}
		return list;
	}
	@Transactional
	public void update(Person obj) {
		if (obj.getId()==null||obj.getId()<0) {
			throw new RuntimeException("非法访问");
		}
		if (!StringUtil.isNotNullAndEmpty(obj.getName())) {
			throw new RuntimeException("姓名不能为空");
		}
		if (!StringUtil.isNotNullAndEmpty(obj.getPhone())) {
			throw new RuntimeException("电话不能为空");
		}
		if (obj.getTypeId()==null||obj.getTypeId()<0) {
			throw new RuntimeException("请选择一个类别");
		}
		int i = personDAO.update(obj);
		if (i!=1) {
			throw new RuntimeException("用户添加修改失败,请稍后重试.");
		}
	}

}
