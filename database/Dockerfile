FROM postgres:12.3-alpine

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres
ENV POSTGRES_DB=test

COPY ./custom-entrypoint.sh /usr/local/bin/custom-entrypoint.sh
COPY ./01_create_tables.sql /docker-entrypoint-initdb.d/
COPY ./02_add_test_users.sql /docker-entrypoint-initdb.d/

RUN chmod +x /usr/local/bin/custom-entrypoint.sh

USER postgres

RUN custom-entrypoint.sh postgres || exit 0

ENTRYPOINT [ "custom-entrypoint.sh" ]

# using this CMD works so that docker run ... doesnt require a command override, 
# only downside is it calls SET for this parameter on every psql issued to the container
CMD [ "-c", "max_locks_per_transaction=512" ]
