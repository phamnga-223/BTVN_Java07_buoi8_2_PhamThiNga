package baiTap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

	static int HAS_EXCEPTION = 1;
	static int NO_EXCEPTION = 0;
	
	Scanner scanner;
	
	Input() {
		this.scanner = new Scanner(System.in);
	}
	
	List<Integer> nhapMang() {
		int n;
		
		try {
			//B1: Nhập số phần tử
			do {
				System.out.print("Xin vui lòng nhập số phần tử: ");
				n = this.scanner.nextInt();
			} while (n < 0);
			
			if (n == 0) {
				System.out.println("Mảng rỗng!");
				return null;
			}
			
			//B2: Nhập các phần tử mảng
			List<Integer> mang = new ArrayList<Integer>(); 
			System.out.println("Xin vui lòng nhập các phần tử mảng: ");
			for (int i =0; i < n; i++) {
				System.out.print("mang[" + i + "] = ");
				mang.add(this.scanner.nextInt());
			}
						
			return mang;
		} catch (Exception ex) {
			System.out.println("Dữ liệu nhập vào không hợp lệ!");
			System.out.println(ex.getStackTrace());
			
			return null;
		}
	}

	int[] nhapSo() {
		try {
			System.out.println("Xin vui lòng nhập 1 số: ");
			int n = this.scanner.nextInt();
			int[] result = {n, NO_EXCEPTION};
			
			return result;
		} catch (Exception ex) {
			System.out.println("Dữ liệu nhập vào không hợp lệ!");
			ex.printStackTrace();			
			int[] result = {0, HAS_EXCEPTION};
			
			return result;
		}
	}
}
