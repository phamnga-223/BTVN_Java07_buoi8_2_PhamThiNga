package baiTap;

import java.util.List;

/**
 * Câu 10. Tính tổng các số nguyên tố < n trong mảng cho trước
 */
public class Cau10 {

	public static void main(String[] args) {
		// B1: Nhập mảng
		Input input = new Input();
		List<Integer> mang = input.nhapMang();
		if (mang == null || mang.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}

		// B2: Người dùng nhập số
		int[] ketQuaNhap = input.nhapSo();
		if (ketQuaNhap[1] == Input.HAS_EXCEPTION) {
			System.out.println("Dữ liệu nhập vào không hợp lệ!");
			return;
		}

		// B3: Tìm số nguyên tố nhỏ hơn n
		int tong = 0;
		for (int i : mang) {
			if (i >= ketQuaNhap[0] || i >= ketQuaNhap[0] || !soNguyenTo(i)) {
				break;
			}
			tong += i;
		}

		// B4: In ra kết quả
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
