package Algorithm.greedy;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/7/11 16:31
 */
public class lc134_加油站 {
    //暴力遍历，每个节点尝试就是了 -- 28 ms
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int gt = 0;
        int ct = 0;
        for(int i = 0; i < len; i++){
            gt += gas[i];
            ct += cost[i];
        }
        if(gt < ct)
            return -1;
        for(int i = 0; i < len; i++){
            if(gas[i] >= cost[i]){
                boolean flag = method(gas, cost, i);
                if(flag)
                    return i;
            }
        }
        return -1;
    }
    public boolean method(int[] gas, int[] cost, int index){
        int gasSum = gas[index];
        for(int i = index + 1; i < gas.length; i++){
            gasSum -= cost[i-1];
            if(gasSum < 0)
                return false;
            gasSum += gas[i];
        }
        for(int i = 0; i <= index; i++){
            if(i == 0){
                gasSum -= cost[gas.length - 1];
            }else{
                gasSum -= cost[i-1];
            }
            if(gasSum < 0)
                return false;
            gasSum += gas[i];
        }
        return true;
    }
    //一遍遍历 -- 贪心 -- 没咋看懂
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            // If one couldn't get here,
            if (curr_tank < 0) {
                // Pick up the next station as the starting one.
                starting_station = i + 1;
                // Start with an empty tank.
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_station : -1;
    }
}
