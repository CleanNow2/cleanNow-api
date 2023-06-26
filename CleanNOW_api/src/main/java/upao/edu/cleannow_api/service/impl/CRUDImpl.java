package upao.edu.cleannow_api.service.impl;

import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.exception.ModelNotFoundException;
import upao.edu.cleannow_api.repository.IGenericRepository;
import upao.edu.cleannow_api.service.ICRUD;

import java.util.List;
import java.util.Optional;

public abstract class CRUDImpl<T, ID> implements ICRUD<T,ID> {
    protected abstract IGenericRepository<T,ID> getRepo();

    @Override
    public T save(T t) throws Exception, DataAlreadyExistsException {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception, DataAlreadyExistsException{
        return getRepo().findAll();
    }

    @Override
    public void delete(ID id) throws Exception{
        getRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("ID NOT FOUND: " + id));
        getRepo().deleteById(id);
    }

    @Override
    public T readById(ID id) throws Exception, DataAlreadyExistsException{
        return getRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("ID NOT FOUND: " + id));
    }

}