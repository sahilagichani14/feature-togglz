package featuretogglz;

import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.mem.InMemoryStateRepository;
import org.togglz.core.user.NoOpUserProvider;
import org.togglz.core.user.UserProvider;

public class MyFeaturesConfig implements TogglzConfig {
    @Override
    public Class<? extends Feature> getFeatureClass() {
        return MyFeatures.class;
    }

    @Override
    public StateRepository getStateRepository() {
        //return new FileBasedStateRepository(new File("/tmp/features.properties"));
        return new InMemoryStateRepository();
    }

    @Override
    public UserProvider getUserProvider() {
        return new NoOpUserProvider();
        //return new ServletUserProvider("admin");
    }

}
