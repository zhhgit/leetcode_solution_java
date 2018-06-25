package session3.q134_gas_station;

public class Solution1 {
    public static void main(String[] args){
        int[] cost = {3,4,5,1,2};
        int[] gas = {1,2,3,4,5};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        if (len == 1){
            return gas[0] >= cost[0] ? 0 : -1;
        }
        for (int i = 0;i < len;i++){
            boolean can = canCompleteFrom(gas,cost,i);
            if (can){
                return i;
            }
        }
        return -1;
    }

    private static boolean canCompleteFrom (int[] gas, int[] cost,int start){
        int len = gas.length;
        int remain = 0;
        int pos = start;
        for (int i = 0;i<len;i++){
            pos = pos % len;
            remain = remain + gas[pos] - cost[pos];
            if (remain < 0){
                return false;
            }
            pos++;
        }
        return true;
    }
}
