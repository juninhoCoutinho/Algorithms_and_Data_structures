#include <iostream>
using namespace std;
int LowerBound(int value, int *mas,int number_of_elements) {
	int l = 0;
	int r = number_of_elements;
	while (l < r) {
		int k = (l + r) / 2;
		if (value <= mas[k])
			r = k;
		else
			l = k + 1;
		

	}
	return l;	
}
int UpperBound(int value, int* mas, int number_of_elements) {
	int l = 0;
	int r = number_of_elements;
	while (l < r) {
		int k = (l + r) / 2;
		if (value < mas[k])
			r = k;
		else
			l = k + 1;


	}
	return l;
}
int bin_search(int value, int *mas, int number_of_elements) {
	int l = 0;
	int r = number_of_elements;
	while (l < r) {
		int k = (l + r) / 2;
		if (mas[k] == value)
			return 1;
		else if (value < mas[k])
			r = k;
		else l = k + 1;

	}
	return 0;
	
}
void main() {
	int n;
	cin >> n;
	


	int *A = new int[n];
	for (int i = 0; i < n; i++){
		cin >> A[i];
	}
	int k;
	cin >> k;
	int* requests = new int[k];
	for (int i = 0; i < k; i++) {
		cin >> requests[i];
		cout << bin_search(requests[i], A, n);
		cout << " " << LowerBound(requests[i], A, n) << " " << UpperBound(requests[i], A, n)<<"\n";
	}	
}