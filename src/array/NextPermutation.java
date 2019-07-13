package array;

import java.util.ArrayList;

public class NextPermutation {
	public void nextPermutation(ArrayList<Integer> a) {
	int i = a.size() - 2;
        while (i >= 0 && a.get(i+1) <= a.get(i)) {
            i--;
        }
        if (i >= 0) {
            int j = a.size() - 1;
            while (j >= 0 && a.get(j) <= a.get(i)) {
                j--;
            }
            swap(a, i, j);
        }
        reverse(a, i + 1);
    }

    private void reverse(ArrayList<Integer> a, int start) {
        int i = start, j = a.size() - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }

    private void swap(ArrayList<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i,a.get(j));
        a.set(j,temp);
    }
}
