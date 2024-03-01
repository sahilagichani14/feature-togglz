package featuretogglz;

import jdk.jfr.Label;
import org.togglz.core.Feature;
import org.togglz.core.annotation.DefaultActivationStrategy;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.InfoLink;
import org.togglz.core.annotation.Owner;
import org.togglz.core.context.FeatureContext;


public enum MyFeatures implements Feature {
    @Label("ADMIN_ROLE_APPLIED")
    //@DefaultActivationStrategy(id = "header") //this is imp, and is in togglz-core
    @EnabledByDefault
    @Owner("Sahil")
    @InfoLink("https://www.togglz.org/documentation/advanced-config.html")
    ADMIN_ROLE_APPLIED,

    @Label("MOOD_CHANGE")
    //@DefaultActivationStrategy(id = "header") //this is imp, and is in togglz-core
    @EnabledByDefault
    @Owner("Sahil")
    @InfoLink("https://www.togglz.org/documentation/advanced-config.html")
    MAKE_HAPPY_MOOD;


//    public boolean isActive() {
//        return FeatureContext.getFeatureManager().isActive(this);
//    }

}
