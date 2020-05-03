package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

	public static void main(String[] args) {
		//int[] arr = {101,34,119,1,-1,89};
		//insertSort(arr);
		
		int[] arr = new int[80000];
		for(int i=0;i<80000;i++) {
			arr[i]=(int) (Math.random()*80000);
		}
		Date date1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("排序前时间="+simpleDateFormat.format(date1));
		insertSort(arr);
		Date date2 = new Date();
		System.out.println("排序后时间="+simpleDateFormat.format(date2));
	}
	
	public static void insertSort(int[] arr) {
		int insertVal, insertIndex;
		for (int i=1;i<arr.length;i++) {
			insertVal=arr[i];
			insertIndex=i-1;
			while(insertIndex>=0 && insertVal<arr[insertIndex]) {
				arr[insertIndex+1]=arr[insertIndex];
				insertIndex--;
			}
			if(insertIndex+1 != i) {
				arr[insertIndex+1]=insertVal;
			}
			//System.out.println("第"+i+"轮插入后为");
			//System.out.println(Arrays.toString(arr));
		}
	}

}
