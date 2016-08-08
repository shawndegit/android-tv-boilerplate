package in.ravidsrk.androidtvboilerplate.ui.search;

import java.util.List;

import javax.inject.Inject;

import in.ravidsrk.androidtvboilerplate.data.DataManager;
import in.ravidsrk.androidtvboilerplate.data.model.Cat;
import in.ravidsrk.androidtvboilerplate.ui.base.BasePresenter;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class SearchContentPresenter extends BasePresenter<SearchContentMvpView> {

    private final DataManager mDataManager;
    private Subscription mSubscription;

    @Inject
    public SearchContentPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void searchCats(List<Cat> cats) {
        checkViewAttached();

        mSubscription = mDataManager.getCats(cats)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleSubscriber<List<Cat>>() {
                    @Override
                    public void onSuccess(List<Cat> cats) {
                        getMvpView().showCats(cats);
                    }

                    @Override
                    public void onError(Throwable error) {
                        getMvpView().showCatsError();
                        Timber.e(error, "There was an error loading the cats!");
                    }
                });
    }

}