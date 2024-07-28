package baiTap;

import java.util.List;

/**
 * Câu 9. Đếm số lượng phần tử trong mảng > giá trị cho trước
 */
public class Cau9 {

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

		// B3: Đếm số phần tử lớn hơn 1 giá trị cho trước
		int count = 0;
		for (int i : mang) {
			if (i > ketQuaNhap[0])
				count++;
		}

		// B4: In ra kết quả
		System.out.println("Số phần tử lớn hơn giá trị cho trước là: " + count + " phần tử.");
	}
}
