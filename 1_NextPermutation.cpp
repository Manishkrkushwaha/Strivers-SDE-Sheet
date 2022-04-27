#include <bits/stdc++.h>
using namespace std;


vector<int> nextPermutation(vector<int> &permutation, int n)
{
    //  Write your code here.
	vector<int> p;
	p=permutation;
	int i,j;
	for(i=n-2;i>=0;i--){
		if(p[i]<p[i+1])
			break;
	}
	if(i<0) reverse(p.begin(),p.end());
	else{
		for(j=n-1;j>=0;j--){
			if(p[i]<p[j]) break;
		}
		swap(p[i],p[j]);
		reverse(p.begin()+i+1,p.end());
	}
	return p;
}

int main() {
	vector<int> a;
	
	
	a={1,5,4,3,2};
	
	a=nextPermutation(a,a.size());
	
	for(auto it:a) cout<<it<<" ";
	return 0;
}

