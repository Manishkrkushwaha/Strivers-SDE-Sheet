#include <bits/stdc++.h>
using namespace std;

void printPascal(int n) 
{
  // Write your code here.
    vector<vector<long long int>> r(n);
	for (int i = 0; i < n; i++) {
            r[i].resize(i + 1);
            r[i][0] = r[i][i] = 1;
  
            for (int j = 1; j < i; j++)
                r[i][j] = r[i - 1][j - 1] + r[i - 1][j];
        }
	
	for(int i=0;i<n;i++){
	    for(int j=0;j<=i;j++) cout<<r[i][j]<<" ";
	    cout<<"\n";
	}
}


int main() {
	// your code goes here
	
	printPascal(8);
	return 0;
}
