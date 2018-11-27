package com.yuanmaxinxi.dao.sms;
import com.yuanmaxinxi.domain.sms.Sms;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface SmsDAO{
	int insert(Sms obj);

	int update(Sms obj);

	int delete(Long id);

	Sms selectOneById(Long id);

	List<Sms> selectAll();

}