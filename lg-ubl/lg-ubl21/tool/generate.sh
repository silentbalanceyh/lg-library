#!/bin/bash

cd ../src/main
xjc -d java -b resources/bindings.xml resources/org/oasis-open/ubl/schemas/*/*.xsd

cd -
