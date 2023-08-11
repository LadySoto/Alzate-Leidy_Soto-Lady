package com.backend.integrador.dao;

import java.util.List;

public interface IDao <T>{
    T registrar (T t);
    List<T> listarOdontologos(); //deberia llamarse solo Listar, tiene que poder reutilizarse en todas las entidades, mas alla que aca solo tengamos una
    
}
