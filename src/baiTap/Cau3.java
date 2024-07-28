package baiTap;

import java.util.List;

/**
 * Câu 3. Xóa 1 phần tử khỏi mảng
 */
public class Cau3 {

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

		// B3: Xóa phần tử
		while (mang.contains(ketQuaNhap[0])) {
			Object i = ketQuaNhap[0];
			mang.remove(i);
		}

		// B4: In ra kết quả
		System.out.println("Mảng sau khi xóa là: ");
		for (int i : mang) {
			System.out.print(i + "\t");
		}
	}
}
