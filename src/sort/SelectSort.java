package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
	//选择排序的时间复杂度为O(n^2),比冒泡排序快
	public static void main(String[] args) {
//		int[] arr= {101,34,119,1};
//		System.out.println("排序前为");
//		System.out.println(Arrays.toString(arr));
//		selectSort(arr);
//		System.out.println("排序后为");
//		System.out.println(Arrays.toString(arr));
		
		int[] arr = new int[80000];
		for(int i=0;i<80000;i++) {
			arr[i]=(int) (Math.random()*80000);
		}
		Date date1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		System.out.println("排序前时间="+simpleDateFormat.format(date1));
		selectSort(arr);
		Date date2 = new Date();
		System.out.println("排序后时间="+simpleDateFormat.format(date2));

	}
	
	public static void selectSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int minIndex=i;
			int min=arr[i];
			for(int j=i+1;j<arr.length;j++) {
				if(min>arr[j]) {
					min=arr[j];
					minIndex=j;
				}
			}
			if(minIndex!=i) {
				arr[minIndex]=arr[i];
				arr[i]=min;
			}
			//System.out.println("第"+(i+1)+"轮后为");
			//System.out.println(Arrays.toString(arr));
		}
	}

}
