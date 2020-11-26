package synfron.reshaper.burp.ui.models.rules.thens;

import lombok.Getter;
import synfron.reshaper.burp.core.rules.thens.ThenDrop;
import synfron.reshaper.burp.ui.models.rules.RuleOperationModelType;

public class ThenDropModel extends ThenModel<ThenDropModel, ThenDrop> {

    @Getter
    private boolean dropMessage;

    public ThenDropModel(ThenDrop then, Boolean isNew) {
        super(then, isNew);
        dropMessage = then.isDropMessage();
    }

    public void setDropMessage(boolean dropMessage) {
        this.dropMessage = dropMessage;
        propertyChanged("dropMessage", dropMessage);
    }

    public boolean persist() {
        if (validate().size() != 0) {
            return false;
        }
        ruleOperation.setDropMessage(dropMessage);
        setSaved(true);
        return true;
    }

    @Override
    public boolean record() {
        if (validate().size() != 0) {
            return false;
        }
        setSaved(true);
        return true;
    }

    @Override
    public RuleOperationModelType<ThenDropModel, ThenDrop> getType() {
        return ThenModelType.Drop;
    }
}