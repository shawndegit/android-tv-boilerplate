package in.ravidsrk.androidtvboilerplate.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import in.ravidsrk.androidtvboilerplate.data.DataManager;
import in.ravidsrk.androidtvboilerplate.data.local.PreferencesHelper;
import in.ravidsrk.androidtvboilerplate.injection.ApplicationContext;
import in.ravidsrk.androidtvboilerplate.injection.module.ApplicationModule;
import rx.subscriptions.CompositeSubscription;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();

    Application application();

    PreferencesHelper preferencesHelper();

    DataManager dataManager();

    CompositeSubscription compositeSubscription();

}