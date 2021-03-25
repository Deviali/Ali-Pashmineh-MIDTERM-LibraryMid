package ada.edu.LibraryMid.service;

import java.sql.SQLException;

public interface libService {

    int ReturnBook(String name,String email) throws SQLException;
    int TakeBook(String name, String email) throws SQLException;
    String AllBookwithme(String email);
    String WhichBookName(String name);
    String WhichBookCategory(String category);
    String WhichBookAuthor(String author);
    String libhistory(String email);
    void Metalib();
}
