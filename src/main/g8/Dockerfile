FROM java

# Env subst install
RUN \
  apt-get update \
  && apt-get -y install gettext-base \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/*

# SETUP NEW RELIC
RUN wget -N https://download.newrelic.com/newrelic/java-agent/newrelic-agent/current/newrelic-java.zip
RUN unzip newrelic-java.zip
RUN rm newrelic-java.zip
COPY target/universal/stage /app
COPY scripts/start.sh /app/bin
RUN ["chmod", "+x", "/app/bin/start.sh"]
COPY conf/newrelic.yml /newrelic/

ENTRYPOINT ["/app/bin/start.sh"]
EXPOSE 80