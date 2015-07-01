package app.android.mikazuki.ttp.mirainikki.domain.repository;

/**
 * Created by haijimakazuki on 15/07/02.
 */
public interface BaseCallback<T> {
    public void onSuccess(T t);
    public void onFailure();
}
