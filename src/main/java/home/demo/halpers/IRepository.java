package home.demo.halpers;

import java.util.List;
import java.util.Optional;

public interface IRepository <T> {
    abstract void create(T t);

    abstract void update(T t);

    abstract void delete(String name);

    abstract List<T> getAll();

    abstract Optional<T> getById(long id);
}
