package com.yuanmaxinxi.service.borrower;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.borrower.BorrowerDAO;
import com.yuanmaxinxi.dao.person.PersonDAO;
import com.yuanmaxinxi.dao.persontype.PersonTypeDAO;
import com.yuanmaxinxi.domain.borrower.Borrower;
import com.yuanmaxinxi.domain.person.Person;
import com.yuanmaxinxi.domain.person.PersonType;
import com.yuanmaxinxi.util.StringUtil;
@Service
public class BorrowerService{
	@Autowired
	private BorrowerDAO borrowerDAO;
	@Autowired
	private PersonDAO personDAO;
	@Autowired
	private PersonTypeDAO personTypeDAO;
	@Transactional
	public void insert(Borrower obj, Long[] pIds){
		if (!StringUtil.isNotNullAndEmpty(obj.getName())) {
			throw new RuntimeException("姓名不能为空.");
		}
		if (!StringUtil.isNotNullAndEmpty(obj.getPhone())) {
			throw new RuntimeException("手机号码不能为空.");
		}
		if (obj.getLoanTime()==null) {
			throw new RuntimeException("借款时间不能为空.");
		}
		if (obj.getRepaymentTime()==null) {
			throw new RuntimeException("还款时间不能为空.");
		}
		int i = borrowerDAO.insert(obj);
		if (i!=1) {
			throw new RuntimeException("借款人添加失败,请稍后重试.");
		}
		for (Long pId : pIds) {
			Map<String,Long> map  = new HashMap<>();
			map.put("pId", pId);
			map.put("bId", obj.getId());
			int j = borrowerDAO.insertPerson(map);
			if (j!=1) {
				throw new RuntimeException("相关联系人添加失败,请稍后重试.");
			}

		}
	}


	@Transactional
	public void update(Borrower obj){
		if (obj.getId()==null||obj.getId()<=0) {
			throw new RuntimeException("非法访问.");
		}
		if (!StringUtil.isNotNullAndEmpty(obj.getName())) {
			throw new RuntimeException("姓名不能为空.");
		}
		if (!StringUtil.isNotNullAndEmpty(obj.getPhone())) {
			throw new RuntimeException("手机号码不能为空.");
		}
		if (obj.getLoanTime()==null) {
			throw new RuntimeException("借款时间不能为空.");
		}
		if (obj.getRepaymentTime()==null) {
			throw new RuntimeException("还款时间不能为空.");
		}
		int i = borrowerDAO.update(obj);
		if (i!=1) {
			throw new RuntimeException("短信用户修改失败,请稍后重试.");
		}
	}


	@Transactional
	public void delete(Long id){
		if (id==null||id<=0) {
			throw new RuntimeException("非法访问.");
		}
		int i = borrowerDAO.delete(id);
		if (i!=1) {
			throw new RuntimeException("短信用户删除失败,请稍后重试.");
		}
	}


	public Borrower selectOneById(Long id){
		Borrower brr = borrowerDAO.selectOneById(id);
		Map<Long,PersonType> cash = new HashMap<>();
		if (brr!=null) {
			Long typeId = brr.getTypeId();
			PersonType py= cash.get(typeId);
			if (py==null) {
				py = personTypeDAO.selectOneById(typeId);
				cash.put(typeId, py);
			}
			brr.setType(py);
		}
		return brr;
	}
	public List<Person> selectPersonsByBrrId(Long id){
		List<Person> list = borrowerDAO.selectPersonsByBrrId(id);
		Map<Long,PersonType> cash = new HashMap<>();
		for (Person p : list) {
			Long typeId = p.getTypeId();
			PersonType py= cash.get(typeId);
			if (py==null) {
				py = personTypeDAO.selectOneById(typeId);
				cash.put(typeId, py);
			}
			p.setType(py);
		}
		return list;
	}


	public List<Borrower> selectAll(){
		List<Borrower> list = borrowerDAO.selectAll();
		for (Borrower brr : list) {
			brr.setPs(selectPersonsByBrrId(brr.getId()));
		}
		return list;
	}

}