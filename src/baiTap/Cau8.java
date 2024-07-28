package baiTap;

import java.util.List;

/**
 * Câu 8. Xóa các phần tử trùng lặp trong mảng các số nguyên
 */
public class Cau8 {

	public static void main(String[] args) {
		// B1: Nhập mảng
		Input input = new Input();
		List<Integer> mang = input.nhapMang();
		if (mang == null || mang.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}

		// B2: Xóa phần tử lặp
		for (int i = 0; i < mang.size(); i++) {
			for (int j = i + 1; j < mang.size(); j++) {
				if (mang.get(i) == mang.get(j)) {
					mang.remove(j);
				}
			}
		}

		// B3: In ra kết quả
		System.out.println("Mảng sau khi xóa lặp là: ");
		for (int i : mang) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
}
