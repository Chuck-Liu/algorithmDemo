#include <iostream>
#include <vector>
#include <stdlib.h>
using namespace std;

class Solution {
public:
	void countingSort(vector<int>& A, vector<int>& B, int k){
		vector<int> C(k + 1, 0);
		for (int i = 0; i < A.size(); i++){
			C[A[i]]++;
		}
		cout << endl;
		for (int i = 1; i < C.size(); i++){
			C[i] += C[i - 1];
		}
		cout << endl;
		for (int i = 0; i < A.size(); i++){
			cout << C[A[i]] << endl;
			B[C[A[i]] - 1] = A[i];
			C[A[i]]--;
		}
	}
};
int main(){
	vector<int> A = { 2, 1, 4, 5, 7, 7, 8, 9, 1, 3 }; 
	vector<int> B(10);
	Solution s;
	s.countingSort(A, B, 10);
	system("pause");
	return 0;
}
