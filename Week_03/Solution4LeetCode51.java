import java.util.*;

public class Solution4LeetCode51 {

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) return null;
        List<List<String>> solution = new ArrayList<>();
        search(0, n, solution, new HashMap<>());
        return solution;
    }

    private void search(int row, int n, List<List<String>> solutions, Map<Integer, Integer> attackingLog) {
        if (row >= n) {
            solutions.add(print(attackingLog));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!isAttacked(row, col, attackingLog)) {
                attackingLog.put(row, col);
                search(row+1, n, solutions, attackingLog);
                attackingLog.remove(row); //backtrack
            }
        }
    }

    private boolean isAttacked(int row, int col, Map<Integer, Integer> attackingLog) {
        return attackingLog.entrySet().stream().anyMatch(entry -> {
            int x = entry.getKey();
            int y = entry.getValue();
            return row == x || col == y || row+col == x+y || row-col == x-y;
        });
    }

    private List<String> print(Map<Integer, Integer> attackingLog) {
        List<String> solution = new ArrayList<>();
        for(int i = 0; i < attackingLog.size(); i++) {
            int queuePosition = attackingLog.get(i);
            char[] line = new char[attackingLog.size()];
            Arrays.fill(line, '.');
            line[queuePosition] = 'Q';
            solution.add(new String(line));
        }
        return solution;
    }
}
