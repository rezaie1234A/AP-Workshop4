import java.util.*;

public class Voting {

    final int type;
    private final HashMap<String, HashSet<Vote>> choices;

    private final boolean isAnonymous;
    private final ArrayList<Person> voters;

    public String question;

    public Voting(int type, String question, boolean isAnonymous) {
        this.type = type;
        this.question = question;
        this.choices = new HashMap<>();
        this.isAnonymous = isAnonymous;
        this.voters = new ArrayList<>();
    }

    public ArrayList<String> getChoices() {
        return new ArrayList<>(choices.keySet());
    }

    public void createChoice(String choice) {
        choices.put(choice, new HashSet<>());
    }

    // Method to register a vote by a person with specified choices
    public void vote(Person voter, ArrayList<String> voter_choices) {
        if (type == 0) {
            for (String choice : voter_choices) {
                if (choices.containsKey(choice)) {
                    Vote vote = new Vote(voter, new Date().toString());
                    choices.get(choice).add(vote);
                    if (!voters.contains(voter)) {
                        voters.add(voter);
                    }
                }
            }
        }
    }

    // Method to register a vote by a person with a randomly selected choice
    public void vote(Person person) {
        if (type == 1) {
            Random random = new Random();
            ArrayList<String> choiceList = new ArrayList<>(choices.keySet());
            String randomChoice = choiceList.get(random.nextInt(choiceList.size()));
            Vote vote = new Vote(person, new Date().toString());
            choices.get(randomChoice).add(vote);
            if (!voters.contains(person)) {
                voters.add(person);
            }
        }
    }

    // Method to print the voting results
    public void printResults() {
        System.out.println("Results for voting on: " + question);
        for (String choice : choices.keySet()) {
            System.out.println("- " + choice + ": " + choices.get(choice).size() + " votes");
        }
    }

    // Method to print the list of voters
    public void printVoters() {
        if (!isAnonymous) {
            for (String choice : choices.keySet()) {
                System.out.println("Voters for " + choice + ":");
                HashSet<Vote> votes = choices.get(choice);
                for (Vote vote : votes) {
                    Person voter = vote.getVoter();
                    System.out.println("- " + voter.getFirstname() + " " + voter.getLastname());
                }
            }
        }
    }

}