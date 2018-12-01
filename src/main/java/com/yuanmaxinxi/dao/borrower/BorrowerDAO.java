package com.yuanmaxinxi.dao.borrower;
import com.yuanmaxinxi.domain.borrower.Borrower;
import com.yuanmaxinxi.domain.person.Person;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface BorrowerDAO{
	int insert(Borrower obj);

	int update(Borrower obj);

	int delete(Long id);

	Borrower selectOneById(Long id);

	List<Borrower> selectAll();

	int insertPerson(Map<String, Long> map);

	List<Person> selectPersonsByBrrId(Long bId);

	void deleteBorrPersonByBId(Long bId);

}