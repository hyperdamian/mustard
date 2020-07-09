#!/usr/bin/env bash

# docker pull postgres
# docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres
docker start postgres
# psql -h localhost -p 5432 -U postgres

