package ada.edu.LibraryMid.controller;

import org.springframework.http.ResponseEntity;

import java.sql.SQLException;


public interface Libraryuse {
    ResponseEntity ReturnBook(String name,String email) throws SQLException;
    ResponseEntity TakeBook(String name,String email) throws SQLException;
    ResponseEntity AllBookwithme(String email);
    ResponseEntity WhichBookName(String name);
    ResponseEntity WhichBookCategory(String category);
    ResponseEntity WhichBookAuthor(String author);
    ResponseEntity libhistory(String email);
    ResponseEntity Metalib();
}
