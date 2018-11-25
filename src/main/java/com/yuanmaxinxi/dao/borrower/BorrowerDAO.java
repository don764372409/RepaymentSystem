package com.yuanmaxinxi.dao.borrower;
import com.yuanmaxinxi.domain.borrower.Borrower;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface BorrowerDAO{
	int insert(Borrower obj);

	int update(Borrower obj);

	int delete(Long id);

	Borrower selectOneById(Long id);

	List<Borrower> selectAll();

}