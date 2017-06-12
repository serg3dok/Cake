import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sergeyo on 6/4/2017.
 */


public class HiCal {
    protected static class Meeting {
        int startTime;
        int endTime;
        //int sortedLength = 1;

        static private Comparator<Meeting> comparatorByStartTime;
        static {
            comparatorByStartTime = new Comparator<Meeting>() {
                @Override
                public int compare(Meeting o1, Meeting o2) {
                    return o1.startTime - o2.startTime;
                }
            };
        }
        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public void setEndTime(int endTime) {
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

        HiCal calendar = new HiCal();
        Meeting[] meetings = new Meeting[4];
        meetings[0] = new Meeting(1, 2);
        meetings[1] = new Meeting(2, 3);
        meetings[2] = new Meeting(7, 9);
        meetings[3] = new Meeting(6, 10);

        meetings = calendar.sortMeetings(meetings);
        List<Meeting> mergedMeetings = calendar.merge(meetings);

        calendar.printMeetings(mergedMeetings);

    }

    public List<Meeting> merge(Meeting[] input) {
        // merge meetings
        List<Meeting> mergedMeetings = new ArrayList<Meeting>();
        mergedMeetings.add(input[0]);
        int mergedIndex = 0;
        for (Meeting m : input) {
            if (m == input[0]) continue;

            if (m.startTime <= mergedMeetings.get(mergedIndex).endTime &&
                    m.endTime > mergedMeetings.get(mergedIndex).endTime) {
                // case of merge
                mergedMeetings.get(mergedIndex).setEndTime(m.getEndTime());
            }
            else if (m.startTime >= mergedMeetings.get(mergedIndex).startTime &&
                       m.endTime <= mergedMeetings.get(mergedIndex).endTime ) {
                    continue;


            } else {
                mergedMeetings.add(m);
                mergedIndex++;
            }

        }

        return mergedMeetings;
    }

    public void printMeetings(List<Meeting> meetingsToPrint) {
        for (Meeting m : meetingsToPrint) {

            System.out.print(m.getStartTime() + " " + m.getEndTime());
            System.out.println();
        }

    }


    public Meeting[] sortMeetings(Meeting[] meetings) {

        Arrays.sort(meetings, new Comparator<Meeting>() {
            public int compare(Meeting m1, Meeting m2) {
                return m1.startTime - m2.startTime;
            }

        } );

        return meetings;
    }



}


