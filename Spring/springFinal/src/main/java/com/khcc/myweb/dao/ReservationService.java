package com.khcc.myweb.dao;

import java.util.List;
import java.util.Map;

import com.khcc.myweb.model.CarBean;

public interface ReservationService {

	/* 자동차 정보 불러오기 */
	public List<CarBean> selectCar(String title) throws Exception;

	/* 결제할 차 정보 */
	public CarBean payCar(String c_model) throws Exception;

	/* 결제 정보 등록 */
	public void insertPay(Map res) throws Exception;
}
