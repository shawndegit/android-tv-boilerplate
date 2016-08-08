package in.ravidsrk.androidtvboilerplate.ui.content;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.ravidsrk.androidtvboilerplate.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.ravidsrk.androidtvboilerplate.ui.base.BaseActivity;
import in.ravidsrk.androidtvboilerplate.ui.search.SearchContentActivity;

public class ContentActivity extends BaseActivity {

    @Bind(R.id.frame_container)
    FrameLayout mFragmentContainer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getFragmentManager().beginTransaction()
                .replace(mFragmentContainer.getId(), ContentFragment.newInstance()).commit();
    }

    @Override
    public boolean onSearchRequested() {
        startActivity(SearchContentActivity.getStartIntent(this));
        return true;
    }

}