package ioprintwriter.talentshow;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {
    private List<Production> productions = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    public void readTalents(Path talentsFile) {
        if (talentsFile == null) {
            throw new IllegalArgumentException("Talents can't be null");
        }

        try (BufferedReader bufferedReader = Files.newBufferedReader(talentsFile)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                productions.add(getProductionFromSting(line));
                votes.add(new Vote(productions.get(productions.size() - 1).getId(), 0));
            }
        } catch (IOException ex) {
            throw new IllegalStateException("Can't read file.", ex);
        }
    }

    private Production getProductionFromSting(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("String can't be null");
        }

        String[] splittedStr = str.split(" ");
        try {
            return new Production(Integer.parseInt(splittedStr[0]), splittedStr[1]);
        } catch (NumberFormatException ex) {
            throw new IllegalStateException("Not valid format");
        }
    }

    public void calculateVotes(Path votesFile) {
        if (votesFile == null) {
            throw new IllegalArgumentException("Votes can't be null");
        }
        try (BufferedReader bufferedReader = Files.newBufferedReader(votesFile)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Vote vote = getVoteFromString(line);
                if (vote != null) {
                    vote.incNum();
                }
            }
        } catch (IOException ex) {
            throw new IllegalStateException("Can't read file.");
        }
    }

    private Vote getVoteFromString(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("String can't be null");
        }

        try {
            int voteId = Integer.parseInt(str);
            for (Vote item : votes) {
                if (voteId == item.getId()) {
                    return item;
                }
            }
        } catch (NumberFormatException ex) {
            throw new IllegalStateException("Not valid format");
        }
        return null;
    }

    public void writeResultToFile(Path resultFile) {
        if (resultFile == null) {
            throw new IllegalArgumentException("Talents can't be null");
        }
        if (productions.isEmpty()) {
            throw new IllegalStateException("Productions not setted");
        }

        try (PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(resultFile))) {
            Production winner = productions.get(0);
            int maxVote = 0;
            for (Production item : productions) {
                Vote productVote = getVoteFromString(String.valueOf(item.getId()));
                if (productVote != null) {
                    printWriter.println(item + " " + productVote.getNumber());
                    if (maxVote < productVote.getNumber()) {
                        maxVote = productVote.getNumber();
                        winner = item;
                    }
                }
            }
            printWriter.println("Winner: " + winner.getName());
        } catch (IOException ex) {
            throw new IllegalStateException("Can't write file.");
        }
    }

    public List<Production> getProductions() {
        return new ArrayList<>(productions);
    }

    public List<Vote> getVotes() {
        return new ArrayList<>(votes);
    }

}
