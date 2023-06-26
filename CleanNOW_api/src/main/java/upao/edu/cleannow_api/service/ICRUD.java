package upao.edu.cleannow_api.service;

import upao.edu.cleannow_api.exception.DataAlreadyExistsException;

import java.util.List;

public interface ICRUD<T, ID> {

    T save(T t) throws Exception, DataAlreadyExistsException;

    T update(T t, ID id) throws Exception;

    List<T> readAll() throws Exception;

    void delete(ID id) throws Exception;

    T readById(ID id) throws Exception, DataAlreadyExistsException;

}