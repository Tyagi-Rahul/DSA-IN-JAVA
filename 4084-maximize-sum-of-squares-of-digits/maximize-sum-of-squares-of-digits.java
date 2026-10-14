class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>num*9){
            return "";
        }

        StringBuilder ans = new StringBuilder();
        while(sum>=9){
            ans.append("9");
            sum-=9;
            num--;
        }

        if(sum>0){
            ans.append(sum);
            num--;
        }

        while(num>0){
            ans.append('0');
            num--;
        }

        return ans.toString();





        // int max=0;
        // int ans=0;
        // for(int i=0;i<Math.pow(10,num)-1;i++){
        //     if(digit(i)==num){
        //         if(sums(i)==sum){
        //             int a=square(i);
        //             if(a>=max){
        //                 max=a;
        //                 ans=i;
        //             }
        //         }
        //     }
        // }

        // return ans == 0 ? "" : String.valueOf(ans);
    }

    // public int sums(int n){
    //     int s=0;
    //     while(n>0){
    //         s+=n%10;
    //         n/=10;
    //     }
    //     return s;
    // }

    // public int digit(int n){
    //     int count=0;
    //     while(n!=0){
    //         count++;
    //         n/=10;
    //     }
    //     return count;
    // }

    // public int square(int n){
    //     int sum=0;
    //     while(n!=0){
    //         int digit=n%10;
    //         sum+=digit*digit;
    //         n/=10;
    //     }
    //     return sum;
    // }
}