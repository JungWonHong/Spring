package _1.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @�� annotation���� �ڹ� �ּ���ó�� �ҽ��ȿ� @��ȣ�� �Բ� ���˴ϴ�.
 * �ּ���ó�� �����Ϸ��� ������ �˷��ִ� ��� �Ǵ� �ڹ� ���α׷� ���࿡ ���� ������ �����ϴ�
 * �뵵�� ���˴ϴ�.
 * @WebServlet ������ ���� ������ ���� ����� ������ 3.0���� �����մϴ�.
   /LifeCycle2�� �ǹ̴�
   "http://localhost:8088/JspProject/LifeCycle2"�� ��û�� ������
       ������ �������̶�� �ǹ� �Դϴ�.
 */
@WebServlet("/LifeCycle2")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycle() {
    	System.out.println("���� ������ �Դϴ�.~~");
    }

    /*
     * �ݹ� �޼ҵ�(callback method) - � ��ü���� � ��Ȳ�� �߻��ϸ�
     * �����̳ʰ� �ڵ����� ȣ���Ͽ� ����Ǵ� �޼ҵ带 �ǹ��մϴ�.
     * �̷� �ݹ� �޼ҵ���� �������� �����մϴ�.
     * - init(), service(), destroy()
     *   init()->service()->destroy()
     */
    // init()�޼ҵ�� ������ ��ü�� ������ ������ ȣ��Ǵ� �޼ҵ�� Ŭ���̾�Ʈ�κ���
    // ���ʷ� ������ ��û�� ���� �� �� �� ����˴ϴ�.
    // ������ �ʱ�ȭ �۾��� ���˴ϴ�.
    public void init() throws ServletException{
    	System.out.println("���� init() �Դϴ�.");
    }
    
    //�� �޼����� ��� ����� ���� ���ؼ��� �� ������ ������ �� �����ϰ� �ܼ��� �ٶ󺸸�
    //��� ��ٷ� ������.
    //�Ǵ� ������ ���� �� ������
    //������ ��ü�� �޸𸮿��� ������ �� ����˴ϴ� - �ڿ� ���� �۾� � ���˴ϴ�.
    public void destroy(){
    	System.out.println("���� destroy() �Դϴ�.");
    }
    
    //Ŭ���̾�Ʈ�� ��û�� ���� ������ ����˴ϴ�.
    //service()�޼ҵ尡 ������ ���������� ������ �����ϴ�.
    //���� ���α׷� ������ �Ϸ�� �Ŀ��� ������ �����̳ʰ� �������� �� ������ �����ϰ�
    //�� ������ ���񽺸� ��û�� Ŭ���̾�Ʈ�� �����մϴ�.
    //�̷ν� ������ �ϳ��� ��û�� ���� ó���� �Ϸ�˴ϴ�.
    //���������� ���ΰ�ħ�� �غ�����
    public void service(HttpServletRequest request, 
    		HttpServletResponse response) throws ServletException, IOException{
    	System.out.println("���� service() �Դϴ�. ~");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}