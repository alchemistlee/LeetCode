package com.jump.code2021.array;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        return searchBetRows(matrix, 0, matrix.length-1, target);

    }

    private boolean searchBetRows(int[][] m, int startRow, int endRow, int target){


        if(startRow==endRow){
            return binarySearch(m[startRow],0, m[startRow].length-1,target);
        }

        int midRow = (startRow+endRow)/2;
        int midLen = m[midRow].length;

        if(m[midRow][midLen-1]<target){
            return searchBetRows(m,midRow+1,endRow,target);
        }
        else if(m[midRow][midLen-1]>target){
            return searchBetRows(m,startRow,midRow,target);
        }
        else{
            return true;
        }

    }

    private boolean binarySearch(int[] r, int s, int e, int target){
        if(s>e){
            return false;
        }
        else if(s==e){
            if(r[s]==target){
                return true;
            }
            return false;
        }

        int mid = (s+e)/2;
        if(r[mid]>target){
            return binarySearch(r,s,mid-1,target);
        }
        else if(r[mid]<target){
            return binarySearch(r,mid+1,e,target);
        }
        else{
            return true;
        }

    }


    public static void main(String[] args){
        int[][] a = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        SearchMatrix s = new SearchMatrix();
        System.out.println(s.searchMatrix(a,13));
    }
}
