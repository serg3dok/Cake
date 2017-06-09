import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergeyo on 6/4/2017.
 */


public class HiCal {
    protected static class Meeting {
        int startTime;
        int endTime;
        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }

    public static void main(String[] args) {

        Meeting[] meetings = new Meeting[3];
        meetings[0] = new Meeting(1, 2);
        meetings[1] = new Meeting(2, 3);
        meetings[2] = new Meeting(7, 9);

        Meeting[] mergedMeetings = merge(meetings);
        printMeetings(mergedMeetings);



    }

    public static Meeting[] merge(Meeting[] input) {
        // merge meetings
        List<Meeting> mergedMeetings = new ArrayList<Meeting>();


        return input;
    }

    public static void printMeetings(Meeting[] meetingsToPrint) {
        for (Meeting m : meetingsToPrint) {
            System.out.print(m.getStartTime() + " " + m.getEndTime());
            System.out.println();
        }
    }



}


