#include <iostream>
#include <vector>
#include <stdlib.h>
using namespace std;

class Solution {
public:
	int randomSelect(vector<int>& A, int p, int r, int i){
		if (p == r) return A[p];
		int q = partition(A, p, r);
		int k = q - p + 1;
		if (k == i) return A[q];
		else if (k > i) {
			return randomSelect(A, p, q - 1, i);
		}
		else{
			return randomSelect(A, q + 1, r, i - k);
		}
	}

	int partition(vector<int>& A, int p, int r){
		int pivot = A[r];
		int i = p - 1;
		for (int j = p; j < r; j++){
			if (A[j] <= pivot){
				i++;
				swap(A[i], A[j]);
			}
		}
		swap(A[r], A[i + 1]);
		return i + 1;
	}
};
int main(){
	vector<int> A = { 2, 1, 4, 5, 7, 7, 8, 9, 1, 3 }; 
	Solution s;
	cout << s.randomSelect(A, 0, 9, 9);
	system("pause");
	return 0;
}
