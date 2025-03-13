package rules;

import rules.action.ConstraintStrategy;
import rules.action.EqualsConstraintStrategy;
import rules.action.MinMaxConstraintStrategy;
import rules.enums.StrategyNames;

import java.util.List;

public class ConstraintStrategyFactory {

    private final List<ConstraintStrategy> strategies;

    public ConstraintStrategyFactory(List<ConstraintStrategy> strategies) {
        this.strategies = strategies;
    }

    public ConstraintStrategy getStrategy(StrategyNames name) {
        if(name.equals(StrategyNames.EQUALS_STRATEGY)) {
            return strategies.stream()
                    .filter(strategy ->
                            strategy instanceof EqualsConstraintStrategy)
                    .findAny().get();
        }
        if(name.equals(StrategyNames.MINMAX_STRATEGY)) {
            return strategies.stream()
                    .filter(strategy ->
                            strategy instanceof MinMaxConstraintStrategy)
                    .findAny().get();
        }

        return null;
    }
}
