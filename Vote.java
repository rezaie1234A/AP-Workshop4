import java.util.Objects;
public class Vote {
    private final Person voter;
    private final String  date;
    public Vote(Person voter, String date) {
        this.voter = voter;
        this.date = date;
    }
    public Person getVoter() {
        return voter;
    }
    public String getDate() {
        return date;
    }
    //Overriding equals method to compare two Vote objects for equality  based on voter and date
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Vote)) return false;
        Vote vote = (Vote) o;
        return Objects.equals(voter, vote.voter) && Objects.equals(date, vote.date);
    }

    //overriding hashcode method to generate a hash code value ofr a vote object based on their voter and date

    @Override
    public int hashCode() {
        return Objects.hash(voter, date);
    }
}
