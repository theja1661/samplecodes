import java.util.HashMap;
import java.util.Map;

public class Target {

    public static int[] getTargetIndicesBruteForce(int[] nums,int target){
        for(int i = 0; i< nums.length - 1; i++){
            for(int j = i+1 ; j < nums.length; j++){
                if((nums[i] + nums[j]) == target )
                    return new int[] {i,j};
            }
        }
        return new int[] {};
    }

    public static int[] getTargetIndices(int[] nums,int target){ // 1 2 3 4 // t = 5
        Map<Integer,Integer> map = new HashMap<>(); // { 1:0,2:1}
        for(int i = 0; i < nums.length ; i++){  // 2
            int difference = target - nums[i];  // 5-3 = 2
            if(map.containsKey(difference)){ 
                return new int[] {map.get(difference),i}; // 1,2
            }
            map.put(nums[i],i); // 
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3};
        int[] result = getTargetIndicesBruteForce(arr, 4);
        if(result.length != 0){
            System.out.println(String.format("Target indices are '%d' & '%d'",result[0],result[1]));
        }
        result = getTargetIndices(arr, 4);
        if(result.length != 0){
            System.out.println(String.format("Target indices are '%d' & '%d'",result[0],result[1]));
        }
       
    }
}
