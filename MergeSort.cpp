#include<iostream>
using namespace std;
// ¹é²¢ÅÅĞò

void mergeArray(int a[], int first, int mid, int last, int temp[]){
	int i = first;
	int m = mid;
	int j = mid + 1;
	int n = last;
	int k = 0;
	while (i <= m && j <= n){
		if (a[i] < a[j]){
			temp[k++] = a[i++];
		}else{
			temp[k++] = a[j++];
		}
	}
	while (i <= m){
		temp[k++] = a[i++];
	}
	while (j <= n){
		temp[k++] = a[j++];
	}
	for(i = 0 ; i < k; i++){
		a[first + i] = temp[i];
	}
} 
void mergeSort(int a[], int first, int last, int temp[]){
	if (first < last){
		int mid = (first + last) / 2;
		mergeSort(a, first, mid, temp);
		mergeSort(a, mid + 1 , last, temp);
		mergeArray(a, first, mid ,last, temp);
	}
}
int main(){
	int a[10] = {2,5,6,6,45,4,44,5,536456,41};
	int temp[10];
	mergeSort(a, 0, 9, temp);
	for(int i = 0 ; i < 10 ; i++){
		cout<<a[i]<<" ";
	}
	cout<<endl;
	return 0;
}
