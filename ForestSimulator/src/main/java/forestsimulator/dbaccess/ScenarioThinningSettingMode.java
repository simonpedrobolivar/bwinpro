package forestsimulator.dbaccess;

import treegross.base.thinning.ThinningModeName;
import treegross.base.thinning.SpeciesThinningSettings;
import java.util.NoSuchElementException;
import treegross.base.thinning.ThinningType;

public enum ScenarioThinningSettingMode {
    AGE(ThinningModeName.AGE) {
        @Override
        protected SpeciesThinningSettings thinningSetting(ThinningType type, String intensityDefinition) {
            return SpeciesThinningSettings.ageBasedScenarioSetting(type, intensityDefinition);
        }
    },
    HEIGHT(ThinningModeName.HEIGHT) {
        @Override
        protected SpeciesThinningSettings thinningSetting(ThinningType type, String intensityDefinition) {
            return SpeciesThinningSettings.heightBasedScenarioSetting(type, intensityDefinition);
        }
    };
    
    private final ThinningModeName name;

    private ScenarioThinningSettingMode(ThinningModeName name) {
        this.name = name;
    }
    
    public static SpeciesThinningSettings forName(ThinningModeName name, ThinningType type, String intensityDefinition) {
        for (ScenarioThinningSettingMode mode : values()) {
            if (mode.name == name) {
                return mode.thinningSetting(type, intensityDefinition);
            }
        }
        throw new NoSuchElementException("No thinning setting found for name " + name);
    }

    protected abstract SpeciesThinningSettings thinningSetting(ThinningType type, String intensityDefinition);
    
}