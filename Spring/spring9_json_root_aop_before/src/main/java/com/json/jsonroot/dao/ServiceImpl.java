package com.json.jsonroot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.json.jsonroot.model.BoardVO;

//Ÿ��
@Service
public class ServiceImpl implements jsonService{

	@Autowired
	private DAO dao;
	
	//�����ΰ��� �����ϱ����� ���������� �����ؾ��ϴ� ����� ����(ȣ��).
	//�̷������� �ϴ°��� ������������ ���ϴ�.
	//������������ ���ֱ� ���ؼ��� xml���� �Ǵ� ������̼�����
	//Ȱ���ؾ� �Ѵ�.
	private LogAdvice log;
	
	public ServiceImpl() {
		log = new LogAdvice();
	}
	
	//��� �޼���(�� ���α׷������� 4��) -> ��������Ʈ
	//get���� �����ϴ� �޼���(2��) -> ����Ʈ ��
	
	@Override
	public int getMaxid() {
		log.beforeLog(); //�������� �ڵ�
		//get�޼��忡�� ����ǰ� �ϴ°� -> ����Ʈ ��
		return dao.getMaxid();
	}

	@Override
	public BoardVO get_whereid(int id) {
		log.beforeLog();
		return dao.get_whereid(id);
	}

	@Override
	public void setInsert(BoardVO b) {
       dao.setInsert(b);		
	}

	@Override
	public List<BoardVO> selectall() {
		return dao.selectall();
	}

}
