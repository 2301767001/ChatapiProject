package system.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class QueryBuilder {

    private final JdbcTemplate jdbcTemplate;

    private StringBuilder queryBuilder;

    private ArrayList<String> columnCollection ;
    private ArrayList<String> holderCollection ;
    private ArrayList<Object> valueCollection  ;

    public QueryBuilder(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;

    }

    public boolean insert() {

        String columnJoin = String.join(",", this.columnCollection);
        String valueJoin = String.join(",", this.holderCollection);

        queryBuilder.append("(").append(columnJoin)
                .append(") ")
                .append("VALUES")
                .append("(").append(valueJoin).append(")");

        String sqlQuery = this.queryBuilder.toString();

     int resultCount =  this.jdbcTemplate.update(sqlQuery, this.valueCollection.toArray());

        return resultCount > 0;


    }

    public QueryBuilder into(String tableName) {

        this.initQueryOperation();
        queryBuilder.append("INSERT INTO ").append(tableName);

        return this;

    }

    public QueryBuilder insertValue(String columnName, Object value) {

     this.setQueryValue(columnName, value);

         return this;


    }

    private void initQueryOperation() {

        this.columnCollection = new ArrayList<>();
        this.holderCollection = new ArrayList<>();
        this.valueCollection  = new ArrayList<>();
        this.queryBuilder     = new StringBuilder();

    }

    private void setQueryValue(String columnName, Object value) {

        columnCollection.add(columnName);
        holderCollection.add("?");
        valueCollection.add(value);

    }

    private void buildColumnValue(String columnName, String operator) {

        this.queryBuilder.append(columnName).append(operator).append("?");

    }

    private void buildColumnValue(String columnName) {

        this.buildColumnValue(columnName, "=");

    }

    public QueryBuilder updateTable(String tableName) {

        this.initQueryOperation();
        this.queryBuilder.append("UPDATE ").append(tableName).append(" SET ");

        return this;

    }

    public QueryBuilder set(String columnName, Object value) {

        if(!this.columnCollection.isEmpty()) {
            this.queryBuilder.append(",");
        }

            this.buildColumnValue(columnName);
            this.setQueryValue(columnName, value);
            return this;

        }

    public int update() {

        String sqlQuery = this.queryBuilder.toString();
        return this.jdbcTemplate.update(sqlQuery, this.valueCollection.toArray());


    }

    public QueryBuilder where(String columnName, String operator, Object value) {

        this.queryBuilder.append(" WHERE ");
        this.buildColumnValue(columnName, operator);
        this.setQueryValue(columnName, value);

        return this;

    }

    public QueryBuilder twoWhere(String columnName, Object value) {

        return this.where(columnName, "=", value);

    }

    public QueryBuilder andWhere(String columnName, String operator, Object value) {

       this.queryBuilder.append(" AND ( ");
       this.buildColumnValue(columnName, operator);
       this.queryBuilder.append(" ) ");
       this.setQueryValue(columnName, value);

        return this;

    }

    public QueryBuilder andWhere(String columnName, Object value) {

        return this.where(columnName, "=", value);

    }

    public QueryBuilder orWhere(String columnName, String operator, Object value) {

        this.queryBuilder.append(" OR ( ");
        this.buildColumnValue(columnName, operator);
        this.queryBuilder.append(" ) ");
        this.setQueryValue(columnName, value);

        return this;

    }

    public QueryBuilder orWhere(String columnName, Object value) {

        return this.where(columnName, "=", value);

    }



}
