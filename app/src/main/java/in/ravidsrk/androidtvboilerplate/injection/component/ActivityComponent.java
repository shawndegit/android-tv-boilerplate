package in.ravidsrk.androidtvboilerplate.injection.component;

import dagger.Component;
import in.ravidsrk.androidtvboilerplate.injection.PerActivity;
import in.ravidsrk.androidtvboilerplate.injection.module.ActivityModule;
import in.ravidsrk.androidtvboilerplate.ui.content.ContentFragment;
import in.ravidsrk.androidtvboilerplate.ui.search.SearchContentFragment;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(ContentFragment contentFragment);

    void inject(SearchContentFragment searchContentFragment);

}