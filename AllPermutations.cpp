#include <bits/stdc++.h>
using namespace std;

#include <bits/stdc++.h>
using namespace std;
                   
#define ar array
#define ll long long
#define ull unsigned long long int
#define ld long double
#define sza(x) ((int)x.size())
#define all(a) (a).begin(), (a).end()
#define f(i,a,n) for(int i=a;i<n;i++)
#define pb push_back
#define mp make_pair

typedef pair<int, int> pii;
typedef pair<ll, ll> pl;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<pii> vpii;
typedef vector<pl> vpl;
typedef vector<vi> vvi;
typedef vector<vl> vvl;

// max value for long - 1e18;
void solve(){
    int n;
    ll c;
    cin>>n>>c;
    
    ll arr[n],mn;
    
    cin>>arr[0];
    
    mn=arr[0];
    
    for(int i=1;i<n;i++){
        cin>>arr[i];
        mn=min(mn,arr[i]);
    }
    sort(arr,arr+n);
    f(i,1,n) arr[i]+=arr[i-1];
    f(i,0,n) cout<<arr[i]<<" ";
    
    
    
    ll i=0,total=0;
    
    while(c>=(mn+i)){
        int j=0;
        while((arr[j]+i*(j+1))<=c && j<n){cout<<(arr[j]+i*(j+1))<<","; j++;cout<<j<<" ";}
        i++;
        
        total+=(j);
        cout<<total<<" $ "<<endl;
        
    }
    cout<<total<<endl;
    
    
}


int main(){
    
    int t;
    cin>>t;
    while(t--){
        solve();
    }
    
	return 0;
}

