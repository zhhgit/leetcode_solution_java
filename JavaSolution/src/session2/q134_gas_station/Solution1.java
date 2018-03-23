package session2.q134_gas_station;

public class Solution1 {
    public static void main(String[] args){
        int[] gas = {2,4};
        int[] cost = {3,4};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int tank = 0;
        int pos = 0;
        for(int i = 0;i<gas.length;i++){
            gasSum += gas[i];
            costSum += cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0){
                pos = i + 1;
                tank = 0;
            }
        }
        if(gasSum >= costSum){
            return pos;
        }
        else{
            return -1;
        }
    }
}
