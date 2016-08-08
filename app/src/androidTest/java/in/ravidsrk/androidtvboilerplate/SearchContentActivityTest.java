package in.ravidsrk.androidtvboilerplate;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.ravidsrk.androidtvboilerplate.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import java.util.List;

import in.ravidsrk.androidtvboilerplate.data.model.Cat;
import in.ravidsrk.androidtvboilerplate.test.common.TestDataFactory;
import in.ravidsrk.androidtvboilerplate.test.common.rules.TestComponentRule;
import in.ravidsrk.androidtvboilerplate.ui.search.SearchContentActivity;
import in.ravidsrk.androidtvboilerplate.util.CustomMatchers;
import rx.Single;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class SearchContentActivityTest {

    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());
    public final ActivityTestRule<SearchContentActivity> main =
            new ActivityTestRule<>(SearchContentActivity.class, false, false);

    @Rule
    public final TestRule chain = RuleChain.outerRule(component).around(main);

    @Test
    public void searchResultsDisplayAndAreScrollable() {
        main.launchActivity(null);

        List<Cat> mockCats = TestDataFactory.makeCats(5);
        stubDataManagerGetCats(Single.just(mockCats));

        onView(withId(R.id.lb_search_text_editor))
                .perform(replaceText("cat"));

        for (int i = 0; i < mockCats.size(); i++) {
            checkItemAtPosition(mockCats.get(i));
        }
    }

    private void checkItemAtPosition(Cat cat) {
        onView(CustomMatchers.withItemText(cat.name, R.id.lb_results_frame)).perform(click());
        onView(CustomMatchers.withItemText(cat.description, R.id.lb_results_frame))
                .check(matches(isDisplayed()));
    }

    private void stubDataManagerGetCats(Single<List<Cat>> single) {
        when(component.getMockDataManager().getCats(anyListOf(Cat.class)))
                .thenReturn(single);
    }

}