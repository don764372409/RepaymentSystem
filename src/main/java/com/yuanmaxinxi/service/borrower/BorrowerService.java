package com.yuanmaxinxi.service.borrower;
import com.yuanmaxinxi.domain.borrower.Borrower;
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
	public int insert(Borrower obj){
		return borrowerDAO.insert(obj);
	}


	@Transactional
	public int update(Borrower obj){
		return borrowerDAO.update(obj);
	}


	@Transactional
	public int delete(Long id){
		return borrowerDAO.delete(id);
	}


	public Borrower selectOneById(Long id){
		return borrowerDAO.selectOneById(id);
	}


	public List<Borrower> selectAll(){
		return borrowerDAO.selectAll();
	}

}