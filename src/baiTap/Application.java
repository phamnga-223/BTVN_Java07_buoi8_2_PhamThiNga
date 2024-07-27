package baiTap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1. Viết chương trình tính tổng các phần tử lẻ trong mảng các số nguyên
 * 2. Đếm số lần xuất hiện 1 phần tử trong mảng (giá trị phần tử để người dùng nhập)
 * 3. Xóa 1 phần tử khỏi mảng
 * 4. Nhập 1 mảng và đếm số lượng số âm, số dương, số 0
 * 5. Thêm, Xóa, Cập nhật giá trị của 1 mảng/danh sách (1. Thêm, 2. Xóa, 3. Cập nhật)
 * 6.7 => Class riêng
 * 8. Xóa các phần tử trùng lặp trong mảng các số nguyên
 * 9. Đếm số lượng phần tử trong mảng > giá trị cho trước
 * 10. Tính tổng các số nguyên tố < n trong mảng cho trruowcs
 */
public class Application {

	static int HAS_EXCEPTION = 1;
	static int NO_EXCEPTION = 0;
	static boolean COUNT_EQUAL = true;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//B1: Nhập mảng
		List<Integer> mang = nhapMang(scanner);
		if (mang == null || mang.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
		
		//1. Tính tổng các phần tử lẻ
		System.out.println("--------------------Câu 1-----------------------");
		tongLe(mang);
		
		//2. Đếm số lần xuất hiện 1 phần tử trong mảng
		System.out.println("--------------------Câu 2-----------------------");
		countNum(scanner, mang, COUNT_EQUAL);
		
		//3. Xóa 1 phần tử khỏi mảng
		System.out.println("--------------------Câu 3-----------------------");
		deleteNum(scanner, mang);
		
		//4. Nhập 1 mảng, đếm số lượng số âm, số dương, số 0
		System.out.println("--------------------Câu 4-----------------------");
		List<Integer> mang2 = nhapMang(scanner);
		if (mang2 == null || mang2.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
		countDau(mang2);
		
		//5. Thêm, xóa, cập nhật giá trị 1 mảng/danh sách 
		//	(1.Thêm, 2.Xóa, 3.Cập nhật)
		System.out.println("--------------------Câu 5-----------------------");
		addNum(scanner, mang2);
		deleteNum(scanner, mang2);
		updateNum(scanner, mang2);
		
		//8. Xóa các phần tử trùng lặp trong 1 mảng
		System.out.println("--------------------Câu 8-----------------------");
		xoaPhanTuLap(mang2);
		
		//9. Đếm số lượng phần tử trong mảng lớn hơn giá trị cho trước
		System.out.println("--------------------Câu 9-----------------------");
		countNum(scanner, mang2, !COUNT_EQUAL);
		
		//10. Tính tổng các số nguyên tố nhỏ hơn n bên trong mảng
		System.out.println("--------------------Câu 10-----------------------");
		tongNguyenTo(scanner, mang2);
	}
	
	public static List<Integer> nhapMang(Scanner scanner) {
		int n;
		
		try {
			//B1: Nhập số phần tử
			do {
				System.out.print("Xin vui lòng nhập số phần tử: ");
				n = scanner.nextInt();
			} while (n < 0);
			
			if (n == 0) {
				System.out.println("Mảng rỗng!");
				return null;
			}
			
			//B2: Nhập các phần tử mảng
			List<Integer> mang = new ArrayList<Integer>(); 
			int tongLe = 0;
			System.out.println("Xin vui lòng nhập các phần tử mảng: ");
			for (int i =0; i < n; i++) {
				System.out.print("mang[" + i + "] = ");
				mang.add(scanner.nextInt());
			}
			
			return mang;
		} catch (Exception ex) {
			System.out.println("Dữ liệu nhập vào không hợp lệ!");
			System.out.println(ex.getStackTrace());
			
			return null;
		}
	}

	public static void tongLe(List<Integer> mang) {
		int tongLe = 0;
		for (int i:mang) {
			if (i % 2 != 0) {
				tongLe += i;
			}
		}
		
		System.out.println("Tổng các phần tử lẻ trong mảng là: " + tongLe);
	}
	
	public static void countNum(Scanner scanner, List<Integer> mang, boolean countEqual) {
		//Kiểm tra mảng
		if (mang == null || mang.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
		
		//B1: Người dùng nhập số
		int[] ketQuaNhap = nhapSo(scanner);
		if (ketQuaNhap[1] == HAS_EXCEPTION) {
			System.out.println("Dữ liệu nhập vào không hợp lệ!");
			return;
		}
		
		int count = 0;
		if (countEqual == COUNT_EQUAL) {
			//B2: Đếm số lần xuất hiện của phần tử
			for (int i:mang) {
				if (i == ketQuaNhap[0]) count++; 
			}
		} else {
			//B2: Đếm số phần tử lớn hơn 1 giá trị cho trước
			for (int i:mang) {
				if (i > ketQuaNhap[0]) count++; 
			}
		}
		
		//B3: In ra kết quả
		if (countEqual == COUNT_EQUAL) {
			System.out.println("Số lần xuất hiện của phần tử trong mảng là: " + count + " lần.");
		} else {
			System.out.println("Số phần tử lớn hơn giá trị cho trước là: " + count + " phần tử.");			
		}
	}
	
	public static void deleteNum(Scanner scanner, List<Integer> mang) {
		System.out.println("Xóa 1 phần tử: ");
		//Kiểm tra mảng
		if (mang == null || mang.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
		
		//B1: Người dùng nhập số
		int[] ketQuaNhap = nhapSo(scanner);
		if (ketQuaNhap[1] == HAS_EXCEPTION) {
			System.out.println("Dữ liệu nhập vào không hợp lệ!");
			return;
		}
		
		//B2: Xóa phần tử
		while(mang.contains(ketQuaNhap[0])) {
			Object i = ketQuaNhap[0];
			mang.remove(i);
		}
		
		//B3: In ra kết quả
		System.out.println("Mảng sau khi xóa là: ");
		for (int i:mang) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
	
	public static void countDau(List<Integer> mang) {
		//B1: Kiểm tra mảng
		if (mang == null || mang.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
		
		//B2: Đếm số lượng số âm, số dương, số 0
		int countAm = 0; int countDuong = 0; int countKhong = 0;
		for (int i:mang) {
			if (i == 0) {
				countKhong++;
			} else if (i < 0) {
				countAm++;
			} else {
				countDuong++;
			}
		}
		
		//B3: In ra kết quả
		System.out.println("Số lượng số âm là: " + countAm);
		System.out.println("Số lượng số dương là: " + countDuong);
		System.out.println("Số lượng số không là: " + countKhong);
	}
	
	public static void addNum(Scanner scanner, List<Integer> mang) {	
		System.out.println("Thêm 1 phần tử: ");
		//Kiểm tra mảng
		if (mang == null) {
			mang = new ArrayList<Integer>();
		}
		
		//B1: Người dùng nhập số
		int[] ketQuaNhap = nhapSo(scanner);
		if (ketQuaNhap[1] == HAS_EXCEPTION) {
			System.out.println("Dữ liệu nhập vào không hợp lệ!");
			return;
		}
		
		//B2: Thêm phần tử
		mang.add(ketQuaNhap[0]);
		
		//B3: In ra kết quả
		System.out.println("Mảng sau khi thêm là: ");
		for (int i:mang) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
	
	public static void updateNum(Scanner scanner, List<Integer> mang) {
		System.out.println("Cập nhật 1 phần tử: ");
		//Kiểm tra mảng
		if (mang == null || mang.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
		
		//B1: Người dùng nhập số
		int index;
		do {
			System.out.println("Xin vui lòng nhập vị trí cần update: ");
			index = scanner.nextInt();
		} while (index < 0);
		int[] ketQuaNhap = nhapSo(scanner);
		if (ketQuaNhap[1] == HAS_EXCEPTION) {
			System.out.println("Dữ liệu nhập vào không hợp lệ!");
			return;
		}
		
		//B2: Update phần tử
		if (index >= mang.size()) {
			System.out.println("Vị trí cần Cập nhật vượt quá mảng!");
			return;
		}
		mang.remove(index);
		mang.add(index, ketQuaNhap[0]);
		
		//B3: In ra kết quả
		System.out.println("Mảng sau khi Cập nhật là: ");
		for (int i:mang) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
	
	public static int[] nhapSo(Scanner scanner) {		
		try {
			System.out.println("Xin vui lòng nhập 1 số: ");
			int n = scanner.nextInt();
			int[] result = {n, NO_EXCEPTION};
			
			return result;
		} catch (Exception ex) {
			System.out.println("Dữ liệu nhập vào không hợp lệ!");
			System.out.println(ex.getStackTrace());
			
			int[] result = {0, HAS_EXCEPTION};
			return result;
		}
	}

	public static void xoaPhanTuLap(List<Integer> mang) {	
		//Kiểm tra mảng
		if (mang == null || mang.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
		
		//B1: Xóa phần tử lặp
		for(int i = 0; i < mang.size(); i++) {
			for (int j = i+1; j < mang.size(); j++) {
				if (mang.get(i) == mang.get(j)) {
					mang.remove(j);
				}
			}
		}
		
		//B3: In ra kết quả
		System.out.println("Mảng sau khi xóa lặp là: ");
		for (int i:mang) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
	
	public static void tongNguyenTo(Scanner scanner, List<Integer> mang) {
		//Kiểm tra mảng
		if (mang == null || mang.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
		
		//B1: Người dùng nhập số
		int[] ketQuaNhap = nhapSo(scanner);
		if (ketQuaNhap[1] == HAS_EXCEPTION) {
			System.out.println("Dữ liệu nhập vào không hợp lệ!");
			return;
		}
		
		//B2: Tìm số nguyên tố nhỏ hơn n
		int tong = 0;
		for (int i:mang) {
			if (i >= ketQuaNhap[0] || i >= ketQuaNhap[0] || !soNguyenTo(i)) {
				break;
			}
			tong += i;
		}
		
		//B3: In ra kết quả
		System.out.println("Tổng các số nguyên tố nhỏ hơn n trong mảng là: " + tong);
	}
	
	public static boolean soNguyenTo(int n) {
		if (n <= 1) {
			return false;
		}
		
		for (int i = 3; i < n; i+=2) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
}
