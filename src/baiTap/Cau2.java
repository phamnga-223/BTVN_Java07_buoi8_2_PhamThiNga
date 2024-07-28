package baiTap;

import java.util.List;

/**
 * Câu 2. Đếm số lần xuất hiện 1 phần tử trong mảng (giá trị phần tử để người dùng nhập)
 */
public class Cau2 {

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

		// B3: Đếm số lần xuất hiện của phần tử
		int count = 0;
		for (int i : mang) {
			if (i == ketQuaNhap[0])
				count++;
		}

		// B4: In ra kết quả
		System.out.println("Số lần xuất hiện của phần tử trong mảng là: " + count + " lần.");
	}
}
