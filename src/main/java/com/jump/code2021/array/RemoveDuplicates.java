package com.jump.code2021.array;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int stageNum=-1;
        int stageLen=0;
        int stageIdx =-1;

        int curLen = nums.length;

        for(int i=0;i<curLen;i++){
            if(i==0){
                stageNum=nums[i];
            }

            if(nums[i]==stageNum){
                stageLen++;
                if(stageLen<2){
                    continue;
                }
                else if(stageLen==2){
                    stageIdx=i;
                }
                else{
                    continue;
                }
            }
            else{

                if(stageLen>2){


                    for(int j=i,k=stageIdx+1;j<curLen;j++,k++){
                        nums[k]=nums[j];
                    }

                    curLen = curLen - (i-stageIdx-1);
                    i= stageIdx+1;
                }
                stageNum=nums[i];
                stageLen=1;
            }

        }

        return curLen;
    }


    public static void main(String[] args){
        int[] n = new int[]{0,0,1,1,1,1,2,3,3};
        RemoveDuplicates r = new RemoveDuplicates();
        System.out.println(r.removeDuplicates(n));

    }
}
