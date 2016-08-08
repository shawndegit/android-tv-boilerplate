package in.ravidsrk.androidtvboilerplate.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import in.ravidsrk.androidtvboilerplate.AndroidTvBoilerplateApplication;
import in.ravidsrk.androidtvboilerplate.injection.component.ActivityComponent;
import in.ravidsrk.androidtvboilerplate.injection.component.DaggerActivityComponent;
import in.ravidsrk.androidtvboilerplate.injection.module.ActivityModule;

public class BaseActivity extends Activity {

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public ActivityComponent activityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(AndroidTvBoilerplateApplication.get(this).getComponent())
                    .build();
        }
        return mActivityComponent;
    }

}