int singleNumber(int* nums, int numsSize) {
    int n=numsSize;
    int num;
    for(int i=0;i<n;i++){
        int count=0;
        for(int j=0;j<n;j++){
           if(nums[i]==nums[j]){
                count++;
           } 
        }
        if(count==1){
            num=nums[i];
            break;
        }
    }
    return num;
}
