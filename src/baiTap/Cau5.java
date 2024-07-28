package baiTap;

import java.util.ArrayList;
import java.util.List;

/**
 * Câu 5. Thêm, Xóa, Cập nhật giá trị của 1 mảng/danh sách (1. Thêm, 2. Xóa, 3. Cập nhật)
 */
public class Cau5 {

	static final int THEM = 1;
	static final int XOA = 2;
	static final int CAP_NHAT = 3;
	
	public static void main(String[] args) {
		try {
			// B1: Nhập mảng
			Input input = new Input();
			List<Integer> mang = input.nhapMang();
			if (mang == null || mang.size() == 0) {
				System.out.println("Mảng rỗng!");
				return;
			}
	
			int stop;
			
			do {		
				// B2: Menu
				int menu = menu(input);
				
				// B3: Thực hiện thao tác 1. Thêm/2. Xóa/3. Cập nhật mảng
				switch (menu) {
				case THEM:
					addNum(mang, input);
					break;
				case XOA:
					deleteNum(mang, input);
					break;
				case CAP_NHAT:
					updateNum(mang, input);
					break;
				default:
					System.out.println("Menu không tồn tại!");
					break;
				}
				
				// B4: Người dùng có muốn dừng chương trinh? 0: Dừng/Khác 0: Tiếp tục
				System.out.println("Bạn có muốn Tiếp tục? \n 0: Dừng \n Khác 0: Tiếp tục");
				stop = input.scanner.nextInt();
			} while (stop != 0);
		} catch (Exception ex) {
			System.out.println("Đã có lỗi xảy ra!");
			ex.printStackTrace();
		}
	}

	public static int menu(Input input) {
		int menu = -1;
		
		try {	
			do {
				System.out.println("Xin vui lòng chọn 1 thao tác: ");
				System.out.println("1: Thêm");
				System.out.println("2: Xóa");
				System.out.println("3: Cập nhật");
				
				menu = input.scanner.nextInt();
			} while (menu != 1 && menu != 2 && menu != 3);			
		} catch (Exception ex) {
			System.out.println("Dữ liệu nhập vào không hợp lệ!");
			System.out.println(ex.getStackTrace());
		}
		
		return menu;
	}

	public static void addNum(List<Integer> mang, Input input) {
		System.out.println("Thêm 1 phần tử: ");
		// Kiểm tra mảng
		if (mang == null) {
			mang = new ArrayList<Integer>();
		}

		// B1: Người dùng nhập số
		int[] ketQuaNhap = input.nhapSo();
		if (ketQuaNhap[1] == Input.HAS_EXCEPTION) {
			System.out.println("a");
			System.out.println("Dữ liệu nhập vào không hợp lệ!");
			return;
		}

		// B2: Thêm phần tử
		mang.add(ketQuaNhap[0]);

		// B3: In ra kết quả
		System.out.println("Mảng sau khi thêm là: ");
		for (int i : mang) {
			System.out.print(i + "\t");
		}
	}

	public static void updateNum(List<Integer> mang, Input input) {
		System.out.println("Cập nhật 1 phần tử: ");
		
		// B1: Người dùng nhập số
		int index;
		do {
			System.out.println("Xin vui lòng nhập vị trí cần update: ");
			index = input.scanner.nextInt();			
		} while (index < 0);
		int[] ketQuaNhap = input.nhapSo();
		if (ketQuaNhap[1] == Input.HAS_EXCEPTION) {
			System.out.println("Dữ liệu nhập vào không hợp lệ!");
			return;
		}

		// B2: Update phần tử
		if (index >= mang.size()) {
			System.out.println("Vị trí cần Cập nhật vượt quá mảng!");
			return;
		}
		mang.remove(index);
		mang.add(index, ketQuaNhap[0]);

		// B3: In ra kết quả
		System.out.println("Mảng sau khi Cập nhật là: ");
		for (int i : mang) {
			System.out.print(i + "\t");
		}
	}

	public static void deleteNum(List<Integer> mang, Input input) {
		System.out.println("Xóa 1 phần tử: ");
		
		// B1: Người dùng nhập số
		int[] ketQuaNhap = input.nhapSo();
		if (ketQuaNhap[1] == Input.HAS_EXCEPTION) {
			System.out.println("Dữ liệu nhập vào không hợp lệ!");
			return;
		}

		// B2: Xóa phần tử
		while (mang.contains(ketQuaNhap[0])) {
			Object i = ketQuaNhap[0];
			mang.remove(i);
		}

		// B3: In ra kết quả
		System.out.println("Mảng sau khi xóa là: ");
		for (int i : mang) {
			System.out.print(i + "\t");
		}
	}
}
