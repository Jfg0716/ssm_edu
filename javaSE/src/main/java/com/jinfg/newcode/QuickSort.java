package com.jinfg.newcode;

import org.junit.Test;

/**
 * @author jinfg
 * @date 2021/6/5 10:51
 */
public class QuickSort {
    /*
    *   题目要求：给定一个数组，请你编写一个函数，返回该数组排序后的形式。
    *       解法：使用快速排序：属于比较类交换排序，不稳定、时间复杂度O(nlogn)
    *           选一个作为基数，用剩下的依次对比
    * */



    private void quickSort2(int[] arr, int start,int end){
        if (start >= end) return;
        int standard = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && arr[j] > standard) j--;
            while (i < j && arr[i] <= standard) i--;
            swap(arr, i, j);
        }
        swap(arr,start,i);
        quickSort2(arr,start,i-1);
        quickSort2(arr,i+1,end);
    }

    @Test
    public void sort(){
        int[] arr={5,6,3,7,4,1,9,2,8};
//        int[] arr={5,2,3,1,4};
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
    }


    private void quickSort(int[] arr, int start, int end){
        //首先排除只有一个元素或者空数组的情况
        if (start >= end) return;
        //每次都以start处的元素值为标准
        int standard = arr[start];
        int i = start;
        int j = end;
        //这个过程是每次循环，保证最大的数在后面，此时还没交换start出的元素
        while (i < j){
            while (i < j && arr[j] > standard) j--;
            while (i < j && arr[i] <= standard) i++;
            swap(arr,i,j);
        }
        //交换start处和无序元素部分较小的数（不一定是最小的），但是这一次交换后standard后面的元素都比它大，前面的元素都比他小
        swap(arr,i,start);
        //第一次交换后，再对standard之前的元素进行排序，保证前面元素的有序
        quickSort(arr,start,i-1);
        //第一次交换后，再对standard之后的元素进行排序，保证元素的有序
        quickSort(arr,i+1,end);
        
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
