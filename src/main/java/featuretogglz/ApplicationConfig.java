package featuretogglz;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;
import org.togglz.core.context.StaticFeatureManagerProvider;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.mem.InMemoryStateRepository;
import org.togglz.core.spi.FeatureProvider;
import org.togglz.servlet.user.ServletUserProvider;
import org.togglz.servlet.util.HttpServletRequestHolder;

import java.io.IOException;

@Configuration
public class ApplicationConfig {

    @Bean
    FeatureManager featureManager() {
        TogglzConfig togglzConfig = new MyFeaturesConfig();
        FeatureManager featureManager = new FeatureManagerBuilder()
                .togglzConfig(togglzConfig)
                //.featureEnum(MyFeatures.class)
                //.featureProvider(new EnumBasedFeatureProvider(MyFeatures.class))
                //.stateRepository(new InMemoryStateRepository())
				//.userProvider(new ServletUserProvider("admin"))
                .build();
        StaticFeatureManagerProvider.setFeatureManager(featureManager);
        return featureManager;
    }

//    @Bean
//    public FeatureProvider featureProvider(){ return new EnumBasedFeatureProvider(MyFeatures.class); }


//    @Bean
//    @ConditionalOnMissingBean(StateRepository.class)
//    public StateRepository inMemoryStateRepository() { return new InMemoryStateRepository(); }

//    @Bean
//    public OncePerRequestFilter featureFilter(){return new FeaturesFilter();}

//    public static class FeaturesFilter extends OncePerRequestFilter{
//        @Override
//        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//            try{
//                HttpServletRequestHolder.bind(request);
//            } finally {
//                HttpServletRequestHolder.release();
//            }
//        }
//    }

//    @Bean
//	public FeatureManager featureManager(){
//		FeatureManager featureManager = new FeatureManagerBuilder()
//				.featureEnum(MyFeatures.class)
//				.stateRepository(new InMemoryStateRepository())
//				.userProvider(new ServletUserProvider("admin"))
//				.build();
//        StaticFeatureManagerProvider.setFeatureManager(featureManager);
//		return featureManager;
//	}

// 	@Bean
//	public FeatureManager featureManager(){
//		FeatureManager featureManager = new FeatureManagerBuilder()
//				.featureEnum(MyFeatures.class)
//				.stateRepository(new InMemoryStateRepository())
//				.userProvider(new ServletUserProvider("admin"))
//				.build();
//		return featureManager;
//	}

}
