package Fichier;

import java.util.ArrayList;

public interface FilesManager<T>
{
    void Save(T data);
    void SaveAll(T[] data);
    T Find(int id);
    ArrayList<T> FindAll();
    void Delete(int id);
    void DeleteAll();
}
