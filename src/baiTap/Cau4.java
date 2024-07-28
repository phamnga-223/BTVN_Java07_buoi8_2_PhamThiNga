package baiTap;

import java.util.List;

/**
 * Câu 4. Nhập 1 mảng và đếm số lượng số âm, số dương, số 0
 */
public class Cau4 {

	public static void main(String[] args) {
		// B1: Nhập mảng
		Input input = new Input();
		List<Integer> mang = input.nhapMang();
		if (mang == null || mang.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}

		// B2: Đếm số lượng số âm, số dương, số 0
		int countAm = 0;
		int countDuong = 0;
		int countKhong = 0;
		for (int i : mang) {
			if (i == 0) {
				countKhong++;
			} else if (i < 0) {
				countAm++;
			} else {
				countDuong++;
			}
		}

		// B3: In ra kết quả
		System.out.println("Số lượng số âm là: " + countAm);
		System.out.println("Số lượng số dương là: " + countDuong);
		System.out.println("Số lượng số không là: " + countKhong);

	}
}
