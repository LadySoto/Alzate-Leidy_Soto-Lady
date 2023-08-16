package com.backend.integrador.dao;

import java.util.List;

public interface IDao <T>{
    T registrar (T t);
<<<<<<< HEAD
    List<T> listar();
=======
    List<T> listarOdontologos(); //deberia llamarse solo Listar, tiene que poder reutilizarse en todas las entidades, mas alla que aca solo tengamos una
    
>>>>>>> 7981331b12081e6e42f5b573fab80cedf86e04aa
}
