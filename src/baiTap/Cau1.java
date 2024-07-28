package baiTap;

import java.util.List;

/**
 * Câu 1. Viết chương trình tính tổng các phần tử lẻ trong mảng các số nguyên
 */
public class Cau1 {
	
	public static void main(String[] args) {
		//B1: Nhập mảng
		Input input = new Input();		
		List<Integer> mang = input.nhapMang();
		if (mang == null || mang.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
		
		//B2. Tính tổng các phần tử lẻ
		int tongLe = 0;
		for (int i:mang) {
			if (i % 2 != 0) {
				tongLe += i;
			}
		}
		
		System.out.println("Tổng các phần tử lẻ trong mảng là: " + tongLe);
	}

}
