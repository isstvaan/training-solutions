package statemachine.elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

    List<String> history = new ArrayList<>();
    private ElevatorStates currentState;
    private ElevatorStates nextState;


    public Elevator() {
        currentState = ElevatorStates.GROUND_FLOOR_OPEN;
    }

    public Elevator(FirstFloorClosed firstFloorClosed) {
        currentState = ElevatorStates.FIRST_FLOOR_CLOSE;
    }

    public void work() {
        while (currentState != nextState) {
            currentState = currentState.nextState(nextState);
            history.add(currentState.toString());
        }
    }


    public String getHistory() {
        return history.toString();
    }

    public void pushButtonToGoToGroundFloor() {
        nextState = ElevatorStates.GROUND_FLOOR_OPEN;
    }

    public void pushButtonToGoToFirstFloor() {
        history.add(currentState.toString());
        nextState = ElevatorStates.FIRST_FLOOR_OPEN;
    }

    public void pushCallButtonOnGroundFloor() {
        nextState = ElevatorStates.GROUND_FLOOR_OPEN;
    }

    public void pushCallButtonOnFirstFloor() {
        nextState = ElevatorStates.FIRST_FLOOR_OPEN;
    }
}
