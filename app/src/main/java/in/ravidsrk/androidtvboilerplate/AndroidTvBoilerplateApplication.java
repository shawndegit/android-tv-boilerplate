package in.ravidsrk.androidtvboilerplate;

import android.app.Application;
import android.content.Context;

import com.ravidsrk.androidtvboilerplate.BuildConfig;

import in.ravidsrk.androidtvboilerplate.injection.component.ApplicationComponent;
import in.ravidsrk.androidtvboilerplate.injection.component.DaggerApplicationComponent;
import in.ravidsrk.androidtvboilerplate.injection.module.ApplicationModule;
import timber.log.Timber;

public class AndroidTvBoilerplateApplication extends Application {

    ApplicationComponent mApplicationComponent;

    public static AndroidTvBoilerplateApplication get(Context context) {
        return (AndroidTvBoilerplateApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

}
