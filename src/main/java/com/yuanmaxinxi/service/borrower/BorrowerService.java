package com.yuanmaxinxi.service.borrower;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.borrower.BorrowerDAO;
import com.yuanmaxinxi.domain.borrower.Borrower;
import com.yuanmaxinxi.util.StringUtil;
@Service
public class BorrowerService{
	@Autowired
	private BorrowerDAO borrowerDAO;
//	@Autowired
//	private PersonTypeDAO personTypeDAO;
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
//		for (Long pId : pIds) {
//			Map<String,Long> map  = new HashMap<>();
//			map.put("pId", pId);
//			map.put("bId", obj.getId());
//			int j = borrowerDAO.insertPerson(map);
//			if (j!=1) {
//				throw new RuntimeException("相关联系人添加失败,请稍后重试.");
//			}
//		}
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
		//先删除中间表数据,再重新加
//		borrowerDAO.deleteBorrPersonByBId(obj.getId());
//		for (Long pId : pIds) {
//			Map<String,Long> map  = new HashMap<>();
//			map.put("pId", pId);
//			map.put("bId", obj.getId());
//			int j = borrowerDAO.insertPerson(map);
//			if (j!=1) {
//				throw new RuntimeException("相关联系人添加失败,请稍后重试.");
//			}
//
//		}
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
		if (brr!=null) {
			List<Map<String,String>> ps = new ArrayList<>();
			Map<String,String> map = new HashMap<>();
			map.put("name","借款人："+brr.getName());
			map.put("phone",brr.getPhone());
			ps.add(map);
			if (StringUtil.isNotNullAndEmpty(brr.getName11())&&StringUtil.isNotNullAndEmpty(brr.getPhone11())) {
				Map<String,String> map11 = new HashMap<>();
				map11.put("name","紧联人："+brr.getName11());
				map11.put("phone",brr.getPhone11());
				ps.add(map11);
			}
			if (StringUtil.isNotNullAndEmpty(brr.getName12())&&StringUtil.isNotNullAndEmpty(brr.getPhone12())) {
				Map<String,String> map12 = new HashMap<>();
				map12.put("name","紧联人："+brr.getName12());
				map12.put("phone",brr.getPhone12());
				ps.add(map12);
			}
			if (StringUtil.isNotNullAndEmpty(brr.getName21())&&StringUtil.isNotNullAndEmpty(brr.getPhone21())) {
				Map<String,String> map21 = new HashMap<>();
				map21.put("name","担保人："+brr.getName21());
				map21.put("phone",brr.getPhone21());
				ps.add(map21);
			}
			if (StringUtil.isNotNullAndEmpty(brr.getName22())&&StringUtil.isNotNullAndEmpty(brr.getPhone22())) {
				Map<String,String> map22 = new HashMap<>();
				map22.put("name","担保人："+brr.getName22());
				map22.put("phone",brr.getPhone22());
				ps.add(map22);
			}
			if (StringUtil.isNotNullAndEmpty(brr.getName23())&&StringUtil.isNotNullAndEmpty(brr.getPhone23())) {
				Map<String,String> map23 = new HashMap<>();
				map23.put("name","担保人："+brr.getName23());
				map23.put("phone",brr.getPhone23());
				ps.add(map23);
			}
			
			brr.setPs(ps);
		}
//		Map<Long,PersonType> cash = new HashMap<>();
//		if (brr!=null) {
//			Long typeId = brr.getTypeId();
//			PersonType py= cash.get(typeId);
//			if (py==null) {
//				py = personTypeDAO.selectOneById(typeId);
//				cash.put(typeId, py);
//			}
//			brr.setType(py);
//			brr.setPs(selectPersonsByBrrId(brr.getId()));
//		}
		return brr;
	}
//	public List<Person> selectPersonsByBrrId(Long id){
//		List<Person> list = borrowerDAO.selectPersonsByBrrId(id);
//		Map<Long,PersonType> cash = new HashMap<>();
//		for (Person p : list) {
//			Long typeId = p.getTypeId();
//			PersonType py= cash.get(typeId);
//			if (py==null) {
//				py = personTypeDAO.selectOneById(typeId);
//				cash.put(typeId, py);
//			}
//			p.setType(py);
//		}
//		return list;
//	}


	public List<Borrower> selectAll(){
		List<Borrower> list = borrowerDAO.selectAll();
		for (Borrower brr : list) {
			List<Map<String,String>> ps = new ArrayList<>();
			if (StringUtil.isNotNullAndEmpty(brr.getName11())&&StringUtil.isNotNullAndEmpty(brr.getPhone11())) {
				Map<String,String> map11 = new HashMap<>();
				map11.put("key","紧联人："+brr.getName11()+" 电话："+brr.getPhone11());
				ps.add(map11);
			}
			if (StringUtil.isNotNullAndEmpty(brr.getName12())&&StringUtil.isNotNullAndEmpty(brr.getPhone12())) {
				Map<String,String> map12 = new HashMap<>();
				map12.put("key","紧联人："+brr.getName12()+" 电话："+brr.getPhone12());
				ps.add(map12);
			}
			if (StringUtil.isNotNullAndEmpty(brr.getName21())&&StringUtil.isNotNullAndEmpty(brr.getPhone21())) {
				Map<String,String> map21 = new HashMap<>();
				map21.put("key","担保人："+brr.getName21()+" 电话："+brr.getPhone21());
				ps.add(map21);
			}
			if (StringUtil.isNotNullAndEmpty(brr.getName22())&&StringUtil.isNotNullAndEmpty(brr.getPhone22())) {
				Map<String,String> map22 = new HashMap<>();
				map22.put("key","担保人："+brr.getName22()+" 电话："+brr.getPhone22());
				ps.add(map22);
			}
			if (StringUtil.isNotNullAndEmpty(brr.getName23())&&StringUtil.isNotNullAndEmpty(brr.getPhone23())) {
				Map<String,String> map23 = new HashMap<>();
				map23.put("key","担保人："+brr.getName23()+" 电话："+brr.getPhone23());
				ps.add(map23);
			}
			brr.setPs(ps);
		}
//		for (Borrower brr : list) {
//			brr.setPs(selectPersonsByBrrId(brr.getId()));
//		}
		return list;
	}

}