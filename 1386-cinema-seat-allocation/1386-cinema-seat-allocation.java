import java.util.*;
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col=seat[1];
            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(col);
        }
        int answer = n * 2;
        for (int row : map.keySet()) {
            Set<Integer> seats = map.get(row);
            boolean A = true; // 2,3,4,5
            boolean B = true; // 4,5,6,7
            boolean C = true; // 6,7,8,9
            for (int i = 2; i <= 5; i++) {
                if (seats.contains(i)) {
                    A = false;
                    break;
                }
            }
            for (int i = 4; i <= 7; i++) {
                if (seats.contains(i)) {
                    B = false;
                    break;
                }
            }
            for (int i = 6; i <= 9; i++) {
                if (seats.contains(i)) {
                    C = false;
                    break;
                }
            }
            if (A && C) {
            } 
            else if (A || B || C) {
                answer -= 1;
            } 
            else {
                answer -= 2;
            }
        }
        return answer;
    }
}