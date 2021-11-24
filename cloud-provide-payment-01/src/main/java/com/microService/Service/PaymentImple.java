package com.microService.Service;


import com.SpringCloud.pojo.PayMent;
import com.microService.DAO.PaymentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentImple implements  PaymentService {

    @Autowired
    PaymentDAO paymentDao;
    @Override
    public int create(PayMent payment) {
        paymentDao.save(payment);
        return 1;
    }

    @Override
    public PayMent queryById(long id) {
        return paymentDao.findById(id);
    }
    @Override
     public String PaymentFeignTimeOut()
    {
        return "timeout";
    }

}
