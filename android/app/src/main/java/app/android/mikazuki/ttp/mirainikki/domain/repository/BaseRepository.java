package app.android.mikazuki.ttp.mirainikki.domain.repository;

import java.util.List;

/**
 * Created by haijimakazuki on 15/07/01.
 */
public interface BaseRepository<T> {

    public T get(int id);
    public List<T> getAll();
    public T create(T t);
    public T update(T t);
    public void delete(int id);

}
