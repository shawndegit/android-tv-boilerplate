package in.ravidsrk.androidtvboilerplate.ui.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ravidsrk.androidtvboilerplate.R;

import in.ravidsrk.androidtvboilerplate.ui.base.BaseActivity;

public class SearchContentActivity extends BaseActivity {

    private SearchContentFragment mSearchContentFragment;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SearchContentActivity.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mSearchContentFragment = (SearchContentFragment) getFragmentManager()
                .findFragmentById(R.id.search_fragment);
    }

    @Override
    public boolean onSearchRequested() {
        if (mSearchContentFragment.hasResults()) {
            startActivity(new Intent(this, SearchContentActivity.class));
        } else {
            mSearchContentFragment.startRecognition();
        }
        return true;
    }

}