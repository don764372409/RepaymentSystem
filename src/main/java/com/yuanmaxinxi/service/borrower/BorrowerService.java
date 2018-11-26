package com.yuanmaxinxi.service.borrower;
import com.yuanmaxinxi.domain.borrower.Borrower;
import com.yuanmaxinxi.util.StringUtil;
import com.yuanmaxinxi.dao.borrower.BorrowerDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class BorrowerService{
	@Autowired
	private BorrowerDAO borrowerDAO;
	@Transactional
	public void insert(Borrower obj){
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
			throw new RuntimeException("短信用户添加失败,请稍后重试.");
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
		return borrowerDAO.selectOneById(id);
	}


	public List<Borrower> selectAll(){
		return borrowerDAO.selectAll();
	}

}