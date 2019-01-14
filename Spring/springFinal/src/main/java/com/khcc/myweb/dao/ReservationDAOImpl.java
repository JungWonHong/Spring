package com.khcc.myweb.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.khcc.myweb.model.CarBean;

@Repository
public class ReservationDAOImpl {
	@Autowired
	SqlSessionTemplate sqlsession;
	
	public List<CarBean> selectCar(String title) {
		return sqlsession.selectList("select_car", title);
	}

	public CarBean payCar(String c_model) {
		return sqlsession.selectOne("pay_car", c_model);
	}

	public void insertPay(Map res) {
		sqlsession.insert("insert_pay", res);
	}
}
