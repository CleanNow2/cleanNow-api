package upao.edu.cleannow_api.service.impl;

import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.repository.IGenericRepository;
import upao.edu.cleannow_api.service.ICRUD;

public abstract class CRUDImpl<T, ID> implements ICRUD<T,ID> {
    protected abstract IGenericRepository<T,ID> getRepo();

    @Override
    public T save(T t) throws Exception, DataAlreadyExistsException {
        return getRepo().save(t);
    }
}