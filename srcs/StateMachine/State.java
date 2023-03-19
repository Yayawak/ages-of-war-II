package srcs.StateMachine;

public enum State {
    MOVE {
        @Override
        public State nextState() {
            return ATTACK;
        }
    },
    ATTACK {
        @Override
        public State nextState() {
            return MOVE;
        }
    },
    CHARGE {
        @Override
        public State nextState() {
            return MOVE;
        }
    },
    IDLE {
        @Override
        public State nextState() {
            return MOVE;
        }
    };
    public abstract State nextState();
    // public abstract String stateName();
}
