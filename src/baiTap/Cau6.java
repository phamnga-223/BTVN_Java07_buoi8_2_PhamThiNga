package baiTap;

import java.util.Scanner;

/**
 * Câu 6: Tính lãi suất đơn giản với công thức: A = P(1 + rt)
 */
public class Cau6 {

	static double LAI_SUAT = 6.0;
	
	public static void main(Scanner scanner) {
		double r = LAI_SUAT / 100;

		try {
			// B1: Người dùng nhập P, t
			System.out.println("Xin vui lòng nhập số tiền gốc: ");
			long p = scanner.nextLong();
			System.out.println("Xin vui lòng nhập số tháng gửi: ");
			int t = scanner.nextInt();

			// B2: Tính số tiền nhận được
			long tienLai = (long) (p * (r * t / 12));
			long a = p + tienLai;

			// B3: In kết quả
			System.out.println("Số tiền nhận được là: " + a);
		} catch (Exception ex) {
			System.out.println("Dữ liệu nhập vào không hợp lệ!");
			System.out.println(ex.getStackTrace());
		}
	}
}
