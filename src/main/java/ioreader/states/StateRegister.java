package ioreader.states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {
    private List<State> states = new ArrayList<>();

    public void readStatesFromFile(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("File name can't be empty");
        }

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/main/resources/" + fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                states.add(getStateFromString(line));
            }
        } catch (IOException ex) {
            throw new IllegalStateException("Can't read file!", ex);
        }

        String line;
    }

    public String findCapitalByStateName(String stateName) {
        for (State item : states) {
            if (item.getStateName().equals(stateName)) {
                return item.getCapital();
            }
        }

        throw new IllegalArgumentException("No state with this name!");
    }

    private State getStateFromString(String str) {
        String[] splitStr = str.split("-");
        if (splitStr.length < 2) {
            throw new IllegalStateException("Invalis string format.");
        }
        return new State(splitStr[0], splitStr[1]);
    }

    public List<State> getStates() {
        return new ArrayList<>(states);
    }
}
