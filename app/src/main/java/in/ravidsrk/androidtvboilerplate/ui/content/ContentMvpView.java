package in.ravidsrk.androidtvboilerplate.ui.content;

import java.util.List;

import in.ravidsrk.androidtvboilerplate.data.model.Cat;
import in.ravidsrk.androidtvboilerplate.ui.base.MvpView;

public interface ContentMvpView extends MvpView {

    void showCats(List<Cat> cats);

    void showCatsError();

}