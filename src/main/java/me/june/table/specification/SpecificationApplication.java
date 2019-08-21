package me.june.table.specification;

import me.june.table.specification.entity.ColumnMetaData;
import me.june.table.specification.entity.TableMetaData;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpecificationApplication {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ResourceLoader resourceLoader;

    @Bean
    public ApplicationRunner applicationRunner () {
        return args -> {
            DatabaseMetaData metaData = jdbcTemplate.getDataSource().getConnection().getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, null , new String[]{"TABLE"});
            Map<String, Object> beans = new HashMap<>();
            List tables = createTables(metaData, resultSet);
            beans.put("tables", tables);
            Resource resource = resourceLoader.getResource("classpath:table.xls");
            InputStream inputStream = resource.getInputStream();
            XLSTransformer xlsTransformer = new XLSTransformer();
            Workbook workbook = xlsTransformer.transformXLS(inputStream, beans);
            File file = new File("result.xls");
            OutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
        };
    }

    private List createTables(DatabaseMetaData metaData, ResultSet resultSet) throws SQLException {
        List tables = new ArrayList();
        while (resultSet.next()) {
            String table_name = resultSet.getString("TABLE_NAME");
            String remarks = resultSet.getString("REMARKS");
            ResultSet columns = metaData.getColumns(null, null, table_name, null);
            TableMetaData sqlTableMetaData = new TableMetaData();
            sqlTableMetaData.setRemarks(remarks);
            sqlTableMetaData.setTableName(table_name);
            sqlTableMetaData.setColumns(createColumns(columns));

            tables.add(sqlTableMetaData);
        }
        return tables;
    }

    private List createColumns(ResultSet columns) throws SQLException {
        List tableColumns = new ArrayList();
        while (columns.next()) {
            ColumnMetaData sqlColumnMetaData = new ColumnMetaData();
            sqlColumnMetaData.setColumnName(columns.getString("COLUMN_NAME").toUpperCase());
            sqlColumnMetaData.setType(columns.getString("TYPE_NAME").toUpperCase());
            sqlColumnMetaData.setAutoIncrement(columns.getString("IS_AUTOINCREMENT"));
            sqlColumnMetaData.setIsNullable(columns.getString("IS_NULLABLE"));
            sqlColumnMetaData.setColumnSize(columns.getString("COLUMN_SIZE"));
            sqlColumnMetaData.setRemarks(columns.getString("REMARKS"));
            System.out.println(sqlColumnMetaData.toString());
            tableColumns.add(sqlColumnMetaData);
        }
        return tableColumns;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpecificationApplication.class, args);
    }

}
