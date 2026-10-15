class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set =  new HashSet<>();
        while(n!=1){
            if(set.contains(n)){
                return false;
            }

            set.add(n);

            int  sum=0;

            while(n>0){
                int digit = n%10;
                sum+=digit*digit;
                n/=10;
            }

            n=sum;
        }


        return true;

        // while(n!=1 && n!=4) {
        //     int sum = 0;
        //     while (n > 0) {
        //         int rem = n % 10;
        //         sum = sum + rem * rem;
        //         n /= 10;
        //     }
        //     n=sum;
        
        // }
        // if (n==1) {
        //     return true;
        // }else{
        //     return false;
        // }
    }
}