#include<iostream>
using namespace std;

// ¿ìËÙÅÅĞò
void quickSort(int a[], int l, int r){
    int i = l;
    int j = r;
    int x = a[i];
    while (i < j){
        while (i < j && a[j] < x) j--;
        if (i < j) a[i] = a[j];
        
        while (i < j && a[i] > x) i++;
        if (i < j) a[j] = a[i];
    }
    a[i] = x;
    quickSort(a, l, i - 1);
    quickSort(a, i + 1 , r);
}
int main(){
    int a[10] = {23,2,354,134,12,58,423,483,131,56};
    quickSort(a, 0 , 9);
    for(int i = 0 ; i < 10 ; i++){
        cout<<a[i]<<" ";
    }
    cout<<endl;
    return 0;
}
