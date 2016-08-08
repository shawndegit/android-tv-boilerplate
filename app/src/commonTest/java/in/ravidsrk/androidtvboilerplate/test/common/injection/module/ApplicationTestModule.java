package in.ravidsrk.androidtvboilerplate.test.common.injection.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import in.ravidsrk.androidtvboilerplate.data.DataManager;
import in.ravidsrk.androidtvboilerplate.data.local.PreferencesHelper;
import in.ravidsrk.androidtvboilerplate.data.remote.AndroidTvBoilerplateService;
import in.ravidsrk.androidtvboilerplate.injection.ApplicationContext;
import rx.subscriptions.CompositeSubscription;

import static org.mockito.Mockito.mock;

/**
 * Provides application-level dependencies for an app running on a testing environment
 * This allows injecting mocks if necessary.
 */
@Module
public class ApplicationTestModule {

    private final Application mApplication;

    public ApplicationTestModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    CompositeSubscription provideCompositeSubscription() {
        return new CompositeSubscription();
    }

    /*************
     * MOCKS
     *************/

    @Provides
    @Singleton
    DataManager provideDataManager() {
        return mock(DataManager.class);
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper() {
        return mock(PreferencesHelper.class);
    }

    @Provides
    @Singleton
    AndroidTvBoilerplateService provideAndroidTvBoilerplateService() {
        return mock(AndroidTvBoilerplateService.class);
    }

}