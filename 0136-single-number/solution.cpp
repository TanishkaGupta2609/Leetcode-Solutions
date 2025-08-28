class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int nas=0;
        for(int i=0;i<nums.size();i++){
            nas=nas^nums[i];
        }
        return nas;
    }
};
