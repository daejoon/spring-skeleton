package com.ddoong2.spring_sketeton.springbootstarter.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ReplicationRoutingDataSource extends AbstractRoutingDataSource {

    public enum Type {
        READ, WRITE
    }

    @Override
    protected Object determineCurrentLookupKey() {
        final Type type = TransactionSynchronizationManager.isCurrentTransactionReadOnly() ? Type.READ : Type.WRITE;
        log.debug("DataSourceType: '{}'", type.name());
        return type;
    }

    public static ReplicationRoutingDataSource of(final DataSource writeDataSource, final DataSource readDataSource) {

        Map<Object, Object> datasourceMap = new HashMap<>();
        datasourceMap.put(Type.READ, readDataSource);
        datasourceMap.put(Type.WRITE, writeDataSource);

        ReplicationRoutingDataSource routingDataSource = new ReplicationRoutingDataSource();
        routingDataSource.setTargetDataSources(datasourceMap);
        routingDataSource.setDefaultTargetDataSource(datasourceMap.get(Type.READ));

        return routingDataSource;
    }
}
