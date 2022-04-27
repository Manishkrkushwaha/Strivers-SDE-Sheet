#include <bits/stdc++.h>
using namespace std;

void setZeroes(vector<vector<int>>& matrix) {
    int i,j;
    
    int m=matrix.size();
    int n=matrix[1].size();
 //   vector<int> row(m,1),col(n,1);
    int col0=1;
    for(i=0;i<m;i++){
        if(matrix[i][0]==0) col0=0;
        for(j=1;j<n;j++){
            if(matrix[i][j]==0){
                matrix[0][j]=0;
                matrix[i][0]=0;
            }
        }
    }
    
    for(i=m-1;i>=0;i--){
        for(j=n-1;j>0;j--){
            if(matrix[0][j]==0 || matrix[i][0]==0){
                matrix[i][j]=0;
            }
        }
        if(col0==0) matrix[i][0]=0;
    }
    
    
    for(i=0;i<m;i++){
        for(j=0;j<n;j++) cout<<matrix[i][j]<<"  ";
        cout<<"\n";
    }
}

int main() {
	// your code goes here
	vector<vector<int>> matrix;
	matrix={{1,1,1},{1,0,1},{1,1,1}};
	
	setZeroes(matrix);
	
	cout<<"\n";
	matrix={{1, 1, 2, 1}, {3, 0, 5, 2}, {1, 3, 0, 5}, {0, 0, 0, 5}};
	
	setZeroes(matrix);

	return 0;
}
