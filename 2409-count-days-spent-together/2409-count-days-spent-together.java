class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveA = parseDay(arriveAlice);
        int leaveA = parseDay(leaveAlice);
        int arriveB = parseDay(arriveBob);
        int leaveB = parseDay(leaveBob);
        
        int startOverlap = Math.max(arriveA, arriveB);
        int endOverlap = Math.min(leaveA, leaveB);
        
        return Math.max(0, endOverlap - startOverlap + 1);
    }
    
    private int parseDay(String date) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        
        int totalDays = day;
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonths[i];
        }
        return totalDays;
    }
}