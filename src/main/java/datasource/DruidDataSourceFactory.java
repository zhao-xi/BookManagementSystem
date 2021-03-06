package datasource;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;
import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import java.sql.SQLException;

public class DruidDataSourceFactory extends UnpooledDataSourceFactory {
    @Override
    public DataSource getDataSource() {
        try {
            ((DruidDataSource) this.dataSource).init();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
        return this.dataSource;
    }

    public DruidDataSourceFactory() {
        this.dataSource = new DruidDataSource();
    }
}
