class Solution {
public:
    void quickSort(vector<int>& nums, int p, int r){
        if (p < r){
            int len = nums.size() - 1;
            int q = partition(nums, 0, len);
            quickSort(nums, p, q - 1);
            quickSort(nums, q + 1, r);
        }
    }
    int partition(vector<int>& nums, int p, int r){
        // choose a pivot
        int pivot = nums[r];
        int i = p - 1;
        for (int j = p; j < r; j++){
            if (nums[j] <= pivot){
                i++;
                swap(nums[i], nums[j]);
            }
        }
        swap(nums[i + 1], nums[r]);
        return i + 1;
    }
};
