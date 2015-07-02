package app.android.mikazuki.ttp.mirainikki.domain.repository;

import java.util.List;

/**
 * Created by haijimakazuki on 15/07/01.
 */
public interface BaseRepository<T> {

    public void get(int id, BaseCallback<T> cb);
    public void getAll(BaseCallback<List<T>> cb);
    public void create(T t, BaseCallback<T> cb);
    public void update(T t, BaseCallback<T> cb);
    public void delete(int id, BaseCallback<T> cb);

}
