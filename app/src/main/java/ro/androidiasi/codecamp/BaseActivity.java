package ro.androidiasi.codecamp;

import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import ro.androidiasi.codecamp.internal.aa.IActivityEnhanced;

/**
 * Created by andrei on 08/04/16.
 */
@EActivity
public abstract class BaseActivity extends AppCompatActivity implements IActivityEnhanced{

    @AfterExtras
    @Override public final void afterExtrasInject(){
        this.afterExtras();
    }

    @AfterInject
    @Override public final void afterMembersInject(){
        this.afterInject();
    }

    @AfterViews
    @Override public final void afterViewsInject(){
        this.afterViews();
    }

    @CallSuper
    @Override public void afterExtras(){
        //empty
    }

    @CallSuper
    @Override public void afterInject(){
        //empty
    }

    @CallSuper
    @Override public void afterViews(){
        //empty
    }

}
