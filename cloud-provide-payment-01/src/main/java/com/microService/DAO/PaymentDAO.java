package com.microService.DAO;


import com.SpringCloud.pojo.PayMent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Mapper
//@Repository
public interface PaymentDAO extends CrudRepository<PayMent,Long> {

   PayMent findById(long id);
//
//    @Override
//    <S extends PayMent> S save(S s);
}