<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 회원가입 : 이메일 도메인
	String[] email = {"daum.net", "nate.com", 
			"naver.com", "hotmail.net", "gmail.com", };
	request.setAttribute("email", email);
	
	// 회원가입 : 휴대폰번호
	String[] phone = {"010", "011", "019"};
	request.setAttribute("phone", phone);
	
	// 마이페이지 : 운전면허증 지역코드
	String[] licenceNum = {"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
							"21", "22", "23", "24", "25", "26"};
	request.setAttribute("licenceNum", licenceNum);
	
	// 마이페이지 : 결제카드 등록 유효기간 월, 년
	String[] expiryMonth = {"01월", "02월", "03월", "04월", "05월", "06월", 
							"07월", "08월", "09월", "10월", "11월", "12월"};
	
	String[] expiryYear = {"2017년", "2018년", "2019년", "2020년", "2021년", 
							"2022년", "2023년", "2024년", "2025년", "2026년", 
							"2027년", "2028년", "2029년", "2030년", "2031년", 
							"2032년", "2033년", "2034년", "2035년", "2036년"};
	request.setAttribute("expiryMonth", expiryMonth);
	request.setAttribute("expiryYear", expiryYear);
%>