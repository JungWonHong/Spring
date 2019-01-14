package com.khcc.myweb.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khcc.myweb.model.CarBean;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
	private ReservationDAOImpl carDAO;

	@Override
	public List<CarBean> selectCar(String title) throws Exception {
		return carDAO.selectCar(title);
	}

	@Override
	public CarBean payCar(String c_model) throws Exception {
		return carDAO.payCar(c_model);
	}

	@Override
	public void insertPay(Map res) throws Exception {
		carDAO.insertPay(res);
	}

}
