#!/bin/sh
echo "Updating newrelic config"
envsubst < "/newrelic/newrelic.yml" > "/newrelic/newrelic-updated.yml"
mv /newrelic/newrelic-updated.yml /newrelic/newrelic.yml
echo "Starting the application"
/app/bin/$name$ -J-javaagent:/newrelic/newrelic.jar