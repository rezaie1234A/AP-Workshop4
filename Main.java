import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Creating Ojects for voting
        VotingSystem votingSystem = new VotingSystem();

        // creatign some different votes
        ArrayList<String> choices1 = new ArrayList<>(Arrays.asList("Choice1", "Choice2"));
        votingSystem.createVoting("Question 1?", true, 0, choices1);

        ArrayList<String> choices2 = new ArrayList<>(Arrays.asList("Option1", "Option2", "Option3"));
        votingSystem.createVoting("Question 2?", false, 1, choices2);

        // creating person
        Person person1 = new Person("Ahmad", "Mohammadi");
        Person person2 = new Person("Reza", "Ahmadi");

        // Voting for votergetter
        ArrayList<String> voteChoices1 = new ArrayList<>(Arrays.asList("Choice1"));
        votingSystem.vote(0, person1, voteChoices1);

        ArrayList<String> voteChoices2 = new ArrayList<>(Arrays.asList("Choice2"));
        votingSystem.vote(0, person2, voteChoices2);

        votingSystem.vote(1, person1);
        votingSystem.vote(1, person2);

        // Showing results at console
        System.out.println("Results of Voting 1:");
        votingSystem.printResults(0);
        votingSystem.printVoters(0);

        System.out.println("\nResults of Voting 2:");
        votingSystem.printResults(1);
        votingSystem.printVoters(1);
    }
}
