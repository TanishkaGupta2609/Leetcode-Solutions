class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # nums=list(map(int,input().split()))
        # target=int(input())
        n=len(nums)
        num_1=[]
        for i in range(n):
            for j in range(n):
                if(i!=j and nums[i]+nums[j]==target):
                    return i,j
                #     break
                # else:
                #     continue
            
    
