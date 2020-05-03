package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
	//冒泡排序的时间复杂度为O(n^2)
	public static void main(String[] args) {
//		int[] arr= {3,9,-1,10,20};
//		System.out.println("排序前的数组为");
//		System.out.println(Arrays.toString(arr));
//		bubbleSort(arr);
//		System.out.println("排序后的数组为");
//		System.out.println(Arrays.toString(arr));
		
		int[] arr = new int[80000];
		for(int i=0;i<80000;i++) {
			arr[i]=(int) (Math.random()*80000);
		}
		Date date1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		System.out.println("排序前时间:"+simpleDateFormat.format(date1));
		bubbleSort(arr);
		Date date2 = new Date();
		System.out.println("排序后时间："+simpleDateFormat.format(date2));
		
	}
	
	public static void bubbleSort(int[] arr) {
		int temp;
		boolean flag=false;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					flag=true;
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			if(!flag) {
				break;
			}else {
				flag=false;
			}
		}
	}

}
