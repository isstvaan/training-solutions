package statemachine.elevator;

public enum ElevatorStates {
    GROUND_FLOOR_OPEN("Ground Floor Open", 0) {
        @Override
        ElevatorStates nextState(ElevatorStates targetState) {
            return this == targetState ? this : GROUND_FLOOR_CLOSE;
        }
    },
    GROUND_FLOOR_CLOSE("Ground Floor Closed", 0) {
        @Override
        ElevatorStates nextState(ElevatorStates targetState) {
            return this == targetState ? this :
                    floorIndex - targetState.getFloorIndex() < 0 ? FIRST_FLOOR_CLOSE ://Ha emeletre megy
                            GROUND_FLOOR_OPEN;
        }
    },
    FIRST_FLOOR_OPEN("First Floor Open", 1) {
        @Override
        ElevatorStates nextState(ElevatorStates targetState) {
            return this == targetState ? this : FIRST_FLOOR_CLOSE;
        }
    },
    FIRST_FLOOR_CLOSE("First Floor Closed", 1) {
        @Override
        ElevatorStates nextState(ElevatorStates targetState) {
            return this == targetState ? this :
                    floorIndex - targetState.getFloorIndex() > 0 ? GROUND_FLOOR_CLOSE ://Ha földszintre megy
                            FIRST_FLOOR_OPEN;
        }
    };

    ElevatorStates(String description, int floorIndex) {
        this.description = description;
        this.floorIndex = floorIndex;
    }

    private String description;

    @Override
    public String toString() {
        return description;
    }

    abstract ElevatorStates nextState(ElevatorStates targetState);

    int floorIndex;

    public int getFloorIndex() {
        return floorIndex;
    }
}
