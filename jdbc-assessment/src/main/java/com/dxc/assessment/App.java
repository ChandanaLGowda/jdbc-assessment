package com.dxc.assessment;

import java.sql.SQLException;
import java.util.List;
import com.dxc.assessment.dao.AuthorDao;
import com.dxc.assessment.modal.Author;

public class App {
    public static void main(String[] args) {
        findAllAuthors();
    }

    static void findAllAuthors(){
        
        AuthorDao dao = new AuthorDao();
        try {
            List<Author> authors = dao.findAll();
            if (authors.size() == 0) {
                System.out.println("No authors found");
                return;
            }
            authors.forEach(au -> System.out.println(au));
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }

    static void createAuthors() {
        Author lwrobert = new Author(122, "lw", "robert","comedy","robert23@gmail.com");
        Author parthgowda = new Author(123, "parth" , "gowda","horror","parthgowda12@gmail.com");

        List<Author> Authors = List.of(lwrobert, parthgowda);
        AuthorDao authorDao = new AuthorDao();

        authors.forEach(au -> {
            try {
                int rows = authorDao.save(au);
                System.out.println("Rows affected: " + rows);
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        });
    }
}
