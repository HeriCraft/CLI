package tv.nosy.cli.models.services.util;

import java.util.List;

public interface EntityRepository<T> {
    public T save(T entity);
    public List<T> findAll();
    public T findOne(Long ref);
    public T update(T entity);
    public void delete(Long ref);
}
