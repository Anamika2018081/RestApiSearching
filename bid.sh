#!/bin/bash

cd src/main/resources
mongoimport --type csv -d patient -c patient --headerline maindata.csv