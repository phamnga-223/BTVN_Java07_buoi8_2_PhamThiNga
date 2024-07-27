package baiTap;

/**
 * Câu 7: In bảng nhân từ 1 đến 10
 */
public class Cau7 {

	public static void main(String[] args) {
		System.out.println("Bảng nhân từ 1 đến 10: ");
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				System.out.println(i + " x " + j + " = " + (i * j));
			}
		}
	}
}
