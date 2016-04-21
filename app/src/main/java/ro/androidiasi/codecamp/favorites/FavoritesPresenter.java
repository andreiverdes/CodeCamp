package ro.androidiasi.codecamp.favorites;

import android.view.View;

import org.androidannotations.annotations.EBean;

import java.util.List;

import ro.androidiasi.codecamp.data.model.DataSession;
import ro.androidiasi.codecamp.data.source.ILoadCallback;
import ro.androidiasi.codecamp.internal.model.Session;
import ro.androidiasi.codecamp.sessions.SessionsPresenter;

/**
 * Created by andrei on 22/04/16.
 */
@EBean
public class FavoritesPresenter extends SessionsPresenter implements FavoritesContract.Presenter{

    @Override protected void updateAdapter() {
        this.mRepository.getFavoriteSessionsList(new ILoadCallback<List<DataSession>>() {
            @Override public void onSuccess(List<DataSession> pObject) {
                mView.getEmptyListTextView().setVisibility(pObject.size() == 0 ? View.VISIBLE : View.GONE);
                mSessionsAdapter.update(Session.fromDataSessionList(pObject));
            }

            @Override public void onFailure(Exception pE) {
                mView.getEmptyListTextView().setVisibility(View.VISIBLE);
            }
        });
    }

    @Override public void onRefresh() {
        this.mRepository.getFavoriteSessionsList(true, new ILoadCallback<List<DataSession>>() {
            @Override public void onSuccess(List<DataSession> pObject) {
                mView.getEmptyListTextView().setVisibility(pObject.size() == 0 ? View.VISIBLE : View.GONE);
                mSessionsAdapter.update(Session.fromDataSessionList(pObject));
                mView.getSwipeRefreshLayout().setRefreshing(false);
            }

            @Override public void onFailure(Exception pException) {
                mView.getEmptyListTextView().setVisibility(View.VISIBLE);
                mView.getSwipeRefreshLayout().setRefreshing(false);
            }
        });
    }
}