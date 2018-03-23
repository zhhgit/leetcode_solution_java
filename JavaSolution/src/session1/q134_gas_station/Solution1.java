package session1.q134_gas_station;

public class Solution1 {
    public static void main(String[] args){
        int[] gas = {4,6,8,9};
        int[] cost = {5,4,2,1};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int total = 0;
        int start = 0;
        int ret = -1;
        int minSum = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            total += gas[i] - cost[i];
            if(total < minSum){
                minSum = total;
                start = i+1;
            }
        }
        if(total>=0){
            ret = start%len;
        }
        return ret;
    }
}
