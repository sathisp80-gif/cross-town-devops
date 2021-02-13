# entity

Entity database to manage the entity and users of the platform

insert into databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, tag )
VALUES ('TAG-1', 'spt-liquibase', 'spt-liquibase.file', now(), 0, 'EXECUTED', 'TAG-1');


 ./liquibase --driver=org.postgresql.Driver --changeLogFile=./empty-change-log.xml --url="jdbc:postgresql://localhost:5432/entity" --username=postgres --password=pass update

  ./liquibase --driver=org.postgresql.Driver --changeLogFile=./changelog-master-entity.xml --url="jdbc:postgresql://localhost:5432/entity" --username=postgres --password=pass status

   ./liquibase --driver=org.postgresql.Driver --changeLogFile=./changelog-master-entity.xml --url="jdbc:postgresql://localhost:5432/entity" --username=postgres --password=pass update