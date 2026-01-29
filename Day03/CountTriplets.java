class Solution {
    public int countTriplets(int[] arr, int target) {
        int count=0;
        int n= arr.length;
        
        // for(int i=0; i<n; i++){
        //     for(int j=i+1; j<n; j++){
        //         for(int k=j+1; k<n; k++){
        //             if(arr[i]+arr[j]+arr[k]==target){
        //                 count++;
        //             }
        //         }
        //     }
        // }
        
        for(int i=0; i<n-2; i++){
            
            int left = i+1;
            int right= n-1;
            
            while(left<right){
                if(arr[i]+arr[left]+arr[right]==target){
                   if(arr[left]==arr[right]){
                       int length= right-left+1;
                       count+= (length* (length-1))/2;
                       break;
                   }
                   
                   int leftCount=1;
                   while(left+1<right && arr[left]==arr[left+1]){
                       left++;
                       leftCount++;
                   }
                   
                     int rightCount=1;
                   while(right-1>left && arr[right]==arr[right-1]){
                       right--;
                      rightCount++;
                   }
                   
                   count+= leftCount*rightCount;
                   left++;
                   right--;
                }
                else if(arr[i]+arr[left]+arr[right]>target){
                    right--;
                }
                else {
                    left++;
                }            }
        }
        
        return count;
    }
}
