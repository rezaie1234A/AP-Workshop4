import java.util.*;

public class VotingSystem {

    private final ArrayList<Voting> votingList;
    public VotingSystem() {
        this.votingList = new ArrayList<>();
    }

    // Method to create a new Voting object and add it to the voting list
    public void createVoting(String question, boolean isAnonymous, int type, ArrayList<String> choices) {
        Voting voting = new Voting(type, question, isAnonymous);
        for (String choice : choices) {
            voting.createChoice(choice);
        }
        votingList.add(voting);
    }

    // Method to get a specific Voting object from the voting list based on its index
    public Voting getVoting(int index) {
        return votingList.get(index);
    }

    // Method to get the entire voting list
    public ArrayList<Voting> getVotingList() {
        return votingList;
    }

    // Method to print the results of a particular voting
    public void printResults(int index) {
        Voting voting = votingList.get(index);
        voting.printResults();
    }

    // Method to print the list of voters who have participated in a particular voting
    public void printVoters(int index) {
        Voting voting = votingList.get(index);
        voting.printVoters();
    }

    // Method to print the details of a particular voting
    public void printVoting(int index) {
        Voting voting = votingList.get(index);
        System.out.println("Question: " + voting.question);
        System.out.println("Choices:");
        ArrayList<String> choices = voting.getChoices();
        for (String choice : choices) {
            System.out.println("- " + choice);
        }
    }

    // Method to allow a voter to cast their vote in a particular voting
    public void vote(int index, Person voter) {
        Voting voting = votingList.get(index);
        if (voting.type == 1) {
            voting.vote(voter);
        }
    }

    // Method to allow a voter to cast their vote for multiple choices in a particular voting
    public void vote(int index, Person voter, ArrayList<String> choices) {
        Voting voting = votingList.get(index);
        if (voting.type == 0) {
            voting.vote(voter, choices);
        }
    }
}