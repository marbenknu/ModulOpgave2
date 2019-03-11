package ValidateData;

import DatabaseHandler.DBQuery.AllQueries;
import DatabaseHandler.DBExecute;

import java.sql.ResultSet;

public class ValidateData {

    DBExecute execute = new DBExecute();
    AllQueries select = new AllQueries();
    private ResultSet res;

    res = execute.executeSelect(select.getQuery());


}
