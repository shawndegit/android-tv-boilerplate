package in.ravidsrk.androidtvboilerplate.test.common.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import in.ravidsrk.androidtvboilerplate.injection.component.ApplicationComponent;
import in.ravidsrk.androidtvboilerplate.test.common.injection.module.ApplicationTestModule;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {

}