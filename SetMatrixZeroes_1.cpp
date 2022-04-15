#include <bits/stdc++.h>
using namespace std;

void zeroes(vector<vector<int>>& matrix,int i,int j,int m,int n){
        
    for(int a=0;a<m;a++) matrix[a][j]=0;
    
    for(int a=0;a<n;a++) matrix[i][a]=0;
}
void setZeroes(vector<vector<int>>& matrix) {
    int i,j;
    
    int m=matrix.size();
    int n=matrix[1].size();
    vector<int> row(m,1),col(n,1);
    
    for(i=0;i<m;i++){
        for(j=0;j<n;j++){
            if(matrix[i][j]==0){
                row[i]=0;
                col[j]=0;
            }
        }
    }
    // for(int i=0;i<row.size();i++){
    //     zeroes(matrix,row[i],col[i],m,n);
    // }
    
    
    for(i=0;i<m;i++){
        for(j=0;j<n;j++){
            if(row[i]==0 || col[j]==0){
                matrix[i][j]=0;
            }
        }
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
	
	cout<<"\n\n\n\n";
	matrix={{0,1,1,0},{1,1,1,1},{1,1,1,1}};
	
	setZeroes(matrix);

	return 0;
}
