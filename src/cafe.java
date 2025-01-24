import java.util.*;

public class cafe {
	
	static Scanner s1 = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<String> alName = new ArrayList<String>();				
		ArrayList<Integer> alPrice = new ArrayList<Integer>();	
		
		ArrayList<String> aMenu = new ArrayList<String>();
		ArrayList<Integer> aCount = new ArrayList<Integer>();
		ArrayList<Integer> aSum = new ArrayList<Integer>();
		
		ArrayList<String> acMenu = new ArrayList<String>();
		ArrayList<Integer> acCount = new ArrayList<Integer>();
		ArrayList<Integer> acSum = new ArrayList<Integer>();
		ArrayList<String> acMobile = new ArrayList<String>();

	
		while (true) {
			System.out.print("작업 선택[m:메뉴관리,o:주문관리,s:실적관리,x:종료] ");
			String ins = s1.nextLine();
			
			if(ins.equals("x")||ins.equals("x")) break;
			
			switch(ins) {
			case "m", "M":
				doMenu(alName, alPrice); // 호출부
			    break;
			
			case "o","O":
				doOrder(alName, alPrice, aMenu, aCount, aSum, acMenu, acCount, acSum, acMobile); // 호출부
                break;
			
                
			case "s","S":
				doSales(acMenu, acCount, acSum, acMobile);
                break;		

			}

		}
		System.out.println("프로그램 종료");

	}
	
	public static void doMenu(ArrayList<String> alName, ArrayList<Integer> alPrice) {
		
		while(true) {
			System.out.print("작업 선택[c:메뉴추가,u:메뉴수정,d:메뉴삭제,r:메뉴보기,x:종료]");
			String mOrder = s1.nextLine();
			if(mOrder.equals("x")|| mOrder.equals("x")) break;
			
			switch(mOrder){
			case "c","C":
				addMenu(alName, alPrice); 
				break;
			
			case "u","U":
				updateMenu(alName, alPrice);
				break;
			
			case "d","D":
				deleteMenu(alName, alPrice);
				break;
			
			case "r","R":
				System.out.println("메뉴보기");

			
			}
		}
	}

	public static void updateMenu(ArrayList<String> alName, ArrayList<Integer> alPrice) {
		
		int menuNum = 1;
		// 메뉴번호 읽기
		// 메뉴번호가 1보다 작으면 종료
		// 새 메뉴명 읽기
		// 새 값 읽기	
		for (int i=0; i<alName.size(); i++) {
			System.out.println((i+1)+", "+alName.get(i)+", "+alPrice.get(i));
		}
		
		String newMenu;
		int newValue;

		while(true) {
			System.out.print("수정할 메뉴의 번호 입력(0입력 시 종료): ");
			String strNum = s1.nextLine();
			if (strNum.equals("")) break;
			if(!isNumber(strNum)) break;
			menuNum = Integer.parseInt(strNum);
			
			
			if (menuNum<1) {
				break;
			}
			
			System.out.print("해당 메뉴의 새 이름을 입력: ");
			newMenu = s1.nextLine();
			
			System.out.print("해당 메뉴의 새 가격을 입력: ");
			String strValue = s1.nextLine();
			if (strValue.equals("")) break;
			if(!isNumber(strValue)) break;
			newValue = Integer.parseInt(strValue);
			
			
			alName.set(menuNum-1, newMenu);
			alPrice.set(menuNum-1, newValue);
			
			for (int i=0; i<alName.size(); i++) {
				System.out.println((i+1)+", "+alName.get(i)+", "+alPrice.get(i));
			}

		}
		
	}
	
	public static void deleteMenu(ArrayList<String> alName, ArrayList<Integer> alPrice) {
		
		int delNum;
		
		for (int i=0; i<alName.size(); i++) {
			System.out.println((i+1)+", "+alName.get(i)+", "+alPrice.get(i));
		}
		while(true) {
			System.out.print("삭제할 메뉴의 번호를 입력(0입력 시 종료): ");
			String strNum = s1.nextLine();
			if (strNum.equals("")) break;
			if(!isNumber(strNum)) break;
			delNum = Integer.parseInt(strNum);
			if (delNum<1) {
				break;
			}
			
			alName.remove(delNum-1);
			alPrice.remove(delNum-1);
			
			for (int i=0; i<alName.size(); i++) {
				System.out.println((i+1)+", "+alName.get(i)+", "+alPrice.get(i));
			}
		}
	}
	
	public static void doOrder(ArrayList<String> alName, ArrayList<Integer> alPrice
			,ArrayList<String> aMenu,ArrayList<Integer> aCount,ArrayList<Integer> aSum,
			ArrayList<String> acMenu,ArrayList<Integer> acCount,ArrayList<Integer> acSum,ArrayList<String> acMobile) {
		
		for (int i=0; i<alName.size(); i++) {
			System.out.println(alName.get(i)+", "+alPrice.get(i));
		}
		
		while(true) {
			System.out.print("작업 선택[c:주문추가,d:주문삭제,r:주문보기,x:주문종료]");
			String mOrder = s1.nextLine();
			if(mOrder.equals("x")|| mOrder.equals("X")) break;
			
			switch(mOrder){
			case "c","C":
				addOrder(alName,alPrice,aMenu,aCount,aSum,
						acMenu, acCount, acSum, acMobile);
		    	System.out.print("마일리지 적립 시, 모바일 번호 입력 (미적립 시 공백 따옴표): ");
		    	
		    	String mobile = s1.nextLine(); // 이번 고객 전화번호 받아 들여놓기
		    	
		    	for(int i=0; i<aMenu.size(); i++) {
		    		acMenu.add(aMenu.get(i)); // 매출 메뉴 추가
		    		acCount.add(aCount.get(i)); // 매출 개수 추가
		    		acSum.add(aSum.get(i));
		    		acMobile.add(mobile); 		
		    	} 

				break;
			
			case "d","D":
				aMenu.clear();aCount.clear();aSum.clear();
				break;
			
			case "r","R":
				showOrder(aMenu,aCount,aSum);

			
			}
		}	
		
	}

	public static void doSales(ArrayList<String> acMenu,ArrayList<Integer> acCount,
			ArrayList<Integer> acSum,ArrayList<String> acMobile) {
		
		while(true) {
			System.out.print("작업 선택[r:매출보기,x:완료]");
			String mOrder = s1.nextLine();
			if(mOrder.equals("x")|| mOrder.equals("X")) break;
			
			else if(mOrder.equals("r")|| mOrder.equals("R")) {
				System.out.println("*매출 현황*");
				int Total=0;
				for (int i=0; i<acMenu.size(); i++) {
					System.out.println(
							acMenu.get(i)+", "+ acCount.get(i)+", "+ acSum.get(i)+", "+acMobile.get(i)
					);
					
					Total += acSum.get(i);
				}
				
				System.out.println("현재 총 누적 판매액: "+Total);

			}

			
		}
	}	
		
	public static void addMenu(ArrayList<String> alName, ArrayList<Integer> alPrice) {
		// while문 안에서 alName/alPrice에 메뉴명/가격을 추가
		// 메뉴명이 빈 문자열이거나, 가격이 0원이면 while문 종료
		/*
  		ArrayList<String> alName = new ArrayList<String>();					
		ArrayList<Integer> alPrice = new ArrayList<Integer>();	// static void라는 메소드들 들어가지 전에 class 바로 다음에 static 붙여야
		*/

		System.out.println("**입력**(이름 공백 시 정지)");
		while (true) {
			System.out.print("메뉴명: ");
			String name = s1.nextLine();
			if (name.equals("")) {
				break;
			}
			else {
				alName.add(name);
			}
			
			System.out.print("가격: ");
			
			String strPrice = s1.nextLine();
			if (strPrice.equals("")) break;
			if(!isNumber(strPrice)) break;
			int price = Integer.parseInt(strPrice);
			
			
			if (price<1) {
				break;
			}
			else {
				alPrice.add(price);
			}
		}
		
		
	}

    public static boolean isNumber(String str) {
    	return str.matches("-?\\d*(\\.\\d+)?");
    	
    }

    public static void addOrder(ArrayList<String> alName, ArrayList<Integer> alPrice,
    		                   ArrayList<String> aMenu, ArrayList<Integer> aCount,
    		                   ArrayList<Integer> aSum, ArrayList<String> acMenu,
    		                   ArrayList<Integer> acCount,ArrayList<Integer> acSum,
    		                   ArrayList<String> acMobile) {
    	// 일단 보여주기
    	for (int i=0; i<alName.size(); i++) {
			System.out.println((i+1)+", "+alName.get(i)+", "+alPrice.get(i));
		}
    	
    	String takenNum = "start";
    	
    	while(takenNum !="") {
	    	// 여기에서 주문 받을 메뉴 번호 선택, 주문 개수 집어 넣기
	    	System.out.print("주문 받을 메뉴 번호를 입력하세요(공백 시 종료): ");
	    	takenNum = s1.nextLine();
	    	if (takenNum.equals("")) return;
	    	if (!isNumber(takenNum)) return; //이게 숫자가 아니니? -> 아니면 True / 숫자면 False
	    	int itakenNum = Integer.parseInt(takenNum); // 문자열 -> 정수
	    
	    	aMenu.add(alName.get(itakenNum-1)); // 주문 받은 메뉴명
	    	
	    	
	    	System.out.print("해당 메뉴의 개수를 입력하세요: ");
	    	String takenCount = s1.nextLine();
	    	if (takenCount.equals("")) return;
	    	if (!isNumber(takenCount)) return; //이게 숫자가 아니니? -> 아니면 True / 숫자면 False
	    	int itakenCount = Integer.parseInt(takenCount); // 문자열 -> 정수
	
	    	aCount.add(itakenCount); //해당 제품 개수
	    	
	    	aSum.add(alPrice.get(itakenNum-1) * itakenCount); // 합계 입력하기

    	}
    	

    }

    public static void showOrder( ArrayList<String> aMenu, 
    		ArrayList<Integer> aCount, ArrayList<Integer> aSum) {
    	
    	int Total = 0;
    	for (int i=0; i<aCount.size(); i++) {
    		Total += aSum.get(i);
			System.out.println(aMenu.get(i)+", "+aCount.get(i)+", "+aSum.get(i));
		}
    	System.out.println("총액: "+Total);
    	
    
	}

}
