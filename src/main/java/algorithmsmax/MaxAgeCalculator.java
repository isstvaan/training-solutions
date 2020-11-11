package algorithmsmax;

import java.util.List;

public class MaxAgeCalculator {
    public Trainer trainerWithMaxAge(List<Trainer> trainers) {
        Trainer trainer = null;
        for (Trainer item : trainers) {
            trainer = trainer == null ? item :
                    trainer.getAge() < item.getAge() ? item : trainer;
        }
        return trainer;
    }
}
