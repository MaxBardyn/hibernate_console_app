package lab_5.view;

import java.sql.SQLException;
import java.text.ParseException;

@FunctionalInterface
public interface Printable {

    void print() throws SQLException, ParseException;

}