package pers.jack.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class BestArrange {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end; //比較結束時間
        }
    }

    public static int bestArrange(Program[] programs, int current) {
        Arrays.sort(programs, new ProgramComparator()); //哪個結束時間早就排在前面
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (current <= programs[i].start) { //項目開始時間大於等於當前時刻
                result++;
                current = programs[i].end; //當前時間為項目結束
            }
        }
        return result;
    }
}
