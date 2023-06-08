package upao.edu.cleannow_api.service;

import upao.edu.cleannow_api.exception.DataAlreadyExistsException;

public interface ICRUD<T, ID> {

    T save(T t) throws Exception, DataAlreadyExistsException;

}