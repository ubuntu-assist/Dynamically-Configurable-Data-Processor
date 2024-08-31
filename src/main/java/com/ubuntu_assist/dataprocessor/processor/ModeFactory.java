package com.ubuntu_assist.dataprocessor.processor;

import com.ubuntu_assist.dataprocessor.database.DatabaseConnector;
import com.ubuntu_assist.dataprocessor.database.ElasticConnector;
import com.ubuntu_assist.dataprocessor.database.PostgresConnector;
import com.ubuntu_assist.dataprocessor.database.RedisConnector;
import com.ubuntu_assist.dataprocessor.model.DatabaseIdentifier;
import com.ubuntu_assist.dataprocessor.model.ModeIdentifier;
import org.springframework.stereotype.Component;

@Component
public class ModeFactory {
    private final PostgresConnector postgresConnector;
    private final RedisConnector redisConnector;
    private final ElasticConnector elasticConnector;

    public ModeFactory(PostgresConnector postgresConnector, RedisConnector redisConnector, ElasticConnector elasticConnector) {
        this.postgresConnector = postgresConnector;
        this.redisConnector = redisConnector;
        this.elasticConnector = elasticConnector;
    }

    public Mode create(ModeIdentifier modeIdentifier, DatabaseIdentifier databaseIdentifier) {
        DatabaseConnector connector = getDatabaseConnector(databaseIdentifier);

        return switch (modeIdentifier) {
            case DUMP -> new DumpMode();
            case PASSTHROUGH -> new PassThroughMode(connector);
            case VALIDATE -> new ValidateMode(connector);
            default -> throw new IllegalArgumentException("Unknown mode identifier");
        };
    }

    private DatabaseConnector getDatabaseConnector(DatabaseIdentifier databaseIdentifier) {
        return switch (databaseIdentifier) {
            case POSTGRES -> postgresConnector;
            case REDIS -> redisConnector;
            case ELASTIC -> elasticConnector;
            default -> throw new IllegalArgumentException("Unknown database identifier");
        };
    }
}
