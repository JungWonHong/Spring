package report_0417;

import java.util.Scanner;

public class IDNmber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("주민등록번호 입력(exit=e)>>");
			String IDNum = sc.nextLine();
		
			if(IDNum.equals("e"))
				break;
			
			if (checkNumbers(IDNum)) { //14개가 입력됐는지 확인
				String[] tkn = tokenizeIDNumbers(IDNum);
				if(tkn==null){ //7번째 문자가 "-"가 아니면 
					System.out.println("\"-\"를 기준으로 주민등록번호 앞자리, 뒷자리를 입력하세요.");
					continue;  //다시 입력받기 위해 반복문 처음으로
				}
				
				if(!(checkFrontPart(tkn[0]) && checkBackPart(tkn[1])))
					continue; //어느 한쪽이라도 숫자 아닌 값이 있으면 반복문 처음으로
					
				checkGender(IDNum); //모든 조건을 충족시 성별,외국인 판별 후 출력
				
				break;  //반복문 빠져나간다.
			} else 
				continue;  //입력된 문자열의 길이가 14가 아니면 다시 입력받기 위해 반복문 처음으로.
		}
		System.out.println("끝");
		sc.close();
	}

	// 1.주민등록번호가 14개인지 판별하는 메서드
	static boolean checkNumbers(String IDNum) {
		if (IDNum.length() != 14) {
			System.out.println("주민등록번호는 14자리 입니다.");
			return false;
		} else
			return true;
	}

	// 2.7번째문자가 "-"인지 판별하는 메서드
	static boolean check7thNumbers(String IDNum) {
		if (IDNum.substring(6, 7).equals("-"))
			return true;
		else {
			System.out.println("주민등록번호가 형식에 맞지 않습니다.(-위치)");
			return false;
		}
	}

	// 3.주민등록번호를 "-"를 기준으로 분리
	static String[] tokenizeIDNumbers(String IDNum){
		if (!check7thNumbers(IDNum))
			return null;

		String[] str_tok = IDNum.split("-");
		return str_tok;
	}

	// 4.3번에서 분리한 앞자리가 숫자인지 판별하는 메서드
	static boolean checkFrontPart(String FrontIDNum) {
		for (int i = 0; i < FrontIDNum.length(); i++) {
			if (FrontIDNum.charAt(i) < '0' || FrontIDNum.charAt(i) > '9') {
				System.out.println("숫자를 입력하세요.");
				return false;
			}
		}
		return true;
	}

	// 5.3번에서 분리한 뒷자리가 숫자인지 판별하는 메서드
	static boolean checkBackPart(String BackIDNum) {
		for (int i = 0; i < BackIDNum.length(); i++) {
			if (BackIDNum.charAt(i) < '0' || BackIDNum.charAt(i) > '9') {
				System.out.println("숫자를 입력하세요.");
				return false;
			}
		}
		return true;
	}

	// 남자,여자,외국인 판별.
	static void checkGender(String IDNum) {
		String gender = IDNum.substring(7, 8);
		if (gender.equals("1") || gender.equals("3"))
			System.out.println("남자입니다.");
		else if (gender.equals("2") || gender.equals("4"))
			System.out.println("여자입니다.");
		else
			System.out.println("외국인입니다.");
	}
}
