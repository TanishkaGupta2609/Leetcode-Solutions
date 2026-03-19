class Solution {
    public int[] sortArray(int[] nums) {
        MergeSort(nums,0,nums.length-1);
        return nums;
    }
    public void MergeSort(int[] nums,int low,int high){
        if(low>=high)return;
        int mid=low+(high-low)/2;
        MergeSort(nums,low,mid);
        MergeSort(nums,mid+1,high);
        Merge(nums,low,mid,high);
    }
    public void Merge(int[] nums,int low,int mid,int high){
       int n1=mid-low+1;
       int n2=high-mid;
       int[] left=new int[n1];
       int[] right=new int[n2];
       for(int i=0;i<n1;i++){
            left[i]=nums[low+i];
       }
       for(int j=0;j<n2;j++){
        right[j]=nums[mid+j+1];
       }
       int i=0,j=0,k=low;
       while(i<n1 && j<n2){
        if(right[j]<left[i]){
            nums[k++]=right[j++];
        }
        else{
           nums[k++]= left[i++];
        }

       }
        while(i<n1){
            nums[k++]=left[i++];
        }
         while(j<n2){
            nums[k++]=right[j++];
        }
        }
    }

