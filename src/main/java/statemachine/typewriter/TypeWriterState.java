package statemachine.typewriter;

import statemachine.trafficlight.TrafficLight;

public enum TypeWriterState {
    UPPERCASE {
        @Override
        TypeWriterState next() {
            return LOWERCASE;
        }
    }, LOWERCASE {
        @Override
        TypeWriterState next() {
            return UPPERCASE;
        }
    };

    abstract TypeWriterState next();

}
