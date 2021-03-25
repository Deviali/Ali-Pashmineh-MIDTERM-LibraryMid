package ada.edu.LibraryMid.controller.Impl;

import ada.edu.LibraryMid.controller.Libraryuse;
import ada.edu.LibraryMid.service.libService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;


@RestController
@RequestMapping("/Lib")
public class libraryuseimpl implements Libraryuse {

    @Autowired
    private libService LibService;


    @Override
    @RequestMapping(value = "/returnbook", method = RequestMethod.GET)
    public ResponseEntity ReturnBook(
            @RequestHeader("name") String name,
            @RequestHeader("email") String email) throws SQLException {
        int result = LibService.ReturnBook(name, email);
        if (result < -1){return ResponseEntity.ok("please check your spelling or the book does not exist");}
        if (result < 0){
            return ResponseEntity.notFound().build();
        } else if (result == 0){
            return ResponseEntity.ok("Book is already in library");
        }else {
            return new ResponseEntity(HttpStatus.I_AM_A_TEAPOT); //Tea is good :D
        }
    }

    @Override
    @RequestMapping(value = "/takebook", method = RequestMethod.GET)
    public ResponseEntity TakeBook(
            @RequestHeader("name")String name,
            @RequestHeader("email") String email) throws SQLException {
        int result = LibService.TakeBook(name, email);
        if (result < 0){
            return ResponseEntity.notFound().build();
        } else if (result == 0){
            return ResponseEntity.ok("Book is not in library");
        }else {
            return new ResponseEntity(HttpStatus.I_AM_A_TEAPOT); //Tea is good :D
        }
    }

    @Override
    @RequestMapping(value = "/allbookwithme", method = RequestMethod.GET)
    public ResponseEntity AllBookwithme(
            @RequestHeader("email")String email) {
        String text = LibService.AllBookwithme(email);
        return ResponseEntity.ok("The books you currently have are: " + text);
    }

    @Override
    @RequestMapping(value = "/whichbookname", method = RequestMethod.GET)
    public ResponseEntity WhichBookName(
            @RequestHeader("name")String name) {
        String text = LibService.WhichBookName(name);
        return ResponseEntity.ok(text);
    }

    @Override
    @RequestMapping(value = "/whichbookcategory", method = RequestMethod.GET)
    public ResponseEntity WhichBookCategory(
            @RequestHeader("category")String category) {
        String text = LibService.WhichBookCategory(category);
        return ResponseEntity.ok(text);
    }

    @Override
    @RequestMapping(value = "/whichbookauthor", method = RequestMethod.GET)
    public ResponseEntity WhichBookAuthor(String author) {
        return null;
    }

    @Override
    @RequestMapping(value = "/libhistory", method = RequestMethod.GET)
    public ResponseEntity libhistory(String email) {
        return null;
    }

    @Override
    @RequestMapping(value = "/Metalib", method = RequestMethod.GET)
    public ResponseEntity Metalib() {
        LibService.Metalib();
         return ResponseEntity.ok("Please check Console for metaData");
    }
}
