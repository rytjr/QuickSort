package quickSort;

import java.util.*;
import java.io.*;

public class quickSort {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[num];
		
		for(int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		quickSort(arr, 0, num - 1);
		
		for(int i : arr) {
			bw.write(i + " ");
		}
		bw.flush();
		bw.close();
	}
	//quickSort를 재귀적 호출하며 pivot기준으로 정렬한다
	public static void quickSort(int[] arr, int left, int right) {
		if(left < right) {
			
			int pivot = position(arr, left, right);
			
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot + 1, right);
		}
	}
	public static int position(int[] arr, int left, int right) {
		
		int pivot = arr[right];
		int begin = left - 1;
		//pivot보다 작은 수를 가장 작은 쪽으로 보내 pivot보다 더 작은 배열과 더 큰 배열로 나눈다
		for(int i = left; i < right; i++) {
			if(arr[i] < pivot) {
				begin++;
				
				int temp = arr[i];
				arr[i] = arr[begin];
				arr[begin] = temp;
			}
		}
		//pivot을 마지막으로 정했기 떄문에 pivot보다 작은 배열 + 1자리에 저장한다
		int temp = arr[right];
		arr[right] = arr[begin + 1];
		arr[begin + 1] = temp;
		
		return begin + 1;
			
	}
}