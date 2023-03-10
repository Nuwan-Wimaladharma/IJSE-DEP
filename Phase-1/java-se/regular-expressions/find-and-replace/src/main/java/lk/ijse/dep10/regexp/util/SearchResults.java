package lk.ijse.dep10.regexp.util;

public class SearchResults {
    private int start;
    private int end;

    public SearchResults() {
    }

    public SearchResults(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "SearchResults{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
