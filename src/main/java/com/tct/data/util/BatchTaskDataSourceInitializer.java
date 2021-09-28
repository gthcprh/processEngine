package com.tct.data.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

@Configuration
public class BatchTaskDataSourceInitializer {
    /**
     * 构建Resource对象
     */
    @Value("classpath:default.sql")
    private Resource businessScript;

    /**
     * 自定义Bean实现业务的特殊需求
     * @param dataSource
     * @return
     */
    @Bean
    @Lazy
    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        // 设置数据源
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }

    public DatabasePopulator databasePopulator() {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScripts(businessScript);
        return populator;
    }

    public void executeSql(final DataSource dataSource) throws Exception {
        Resource classPathResource = new ClassPathResource(((ClassPathResource) businessScript).getPath());
        ScriptUtils.executeSqlScript(dataSource.getConnection(), classPathResource);
    }
}