import java.util.*;

public class DayChange {
	public static int[] change(int[] cells, int days) {
		if (cells.length <= 0 || days <= 0) {
			return null;
		}
		else if (cells.length == 1) {
			cells[0] = 0;
			return cells;
		}

		for (int i = 0; i < days; ++i) {
			int[] temp = new int[cells.length];
			temp[0] = cells[1];
			for (int j = 1; j < cells.length - 1; ++j) {
				if (cells[j - 1] != cells[j + 1]) {
					temp[j] = 1;
				}
				else {
					temp[j] = 0;
				}
			}
			temp[cells.length - 1] = cells[cells.length - 2];
			cells = temp;
		}
		return cells;
	}

	public static void main(String[] args) {
		int[] cells = {1, 0, 0, 0, 0, 1, 0, 0};
		int days = 2;
		cells = DayChange.change(cells, days);
		for (int n : cells) {
			System.out.printf("%d ", n);
		}
		System.out.println("");
	}
}