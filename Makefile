SHELL = /bin/bash

.PHONY: all
all: compile fmt lint

.PHONY: compile
compile:
	sbt compile

.PHONY: test
test: compile
	sbt test

.PHONY: run
run: compile
	sbt run

.PHONY: fmt
fmt:
	sbt scalafixAll scalafmtAll

.PHONY: lint
lint:
	sbt "scalafixAll --check" scalafmtCheckAll

.PHONY: grpc
grpc:
	grpcurl -plaintext localhost:50051 scalapic.v1.ParticleInCellSimulatorService/Simulate
