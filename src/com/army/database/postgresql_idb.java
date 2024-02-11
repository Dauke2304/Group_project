package com.army.database;

import java.sql.Connection;

public interface postgresql_idb {
    Connection getConnection();
    /*
    Function that connects with database, the information about database must be written manually to the body of function, returns object Connection type
     */
}
