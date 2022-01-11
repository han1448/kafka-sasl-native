# kafka-sasl-native

## Note: 
- Change topic name: `Sender.send()`
- Change application.yaml for the kafka information and sasl configuration

# Build Native Image
```shell
./mvnw -Pnative -DskipTests clean package  
```

# Run
```shell
target/kafka-sasl
```

# Error
```shell
2021-12-06 16:23:57.827  INFO 5526 --- [           main] o.a.k.clients.producer.ProducerConfig    : ProducerConfig values: 
        acks = 1
        batch.size = 16384
        bootstrap.servers = [XXXXXXX]
        buffer.memory = 33554432
        client.dns.lookup = use_all_dns_ips
        client.id = producer-1
        compression.type = gzip
        connections.max.idle.ms = 540000
        delivery.timeout.ms = 120000
        enable.idempotence = false
        interceptor.classes = []
        internal.auto.downgrade.txn.commit = true
        key.serializer = class org.apache.kafka.common.serialization.StringSerializer
        linger.ms = 300
        max.block.ms = 60000
        max.in.flight.requests.per.connection = 5
        max.request.size = 5242880
        metadata.max.age.ms = 300000
        metadata.max.idle.ms = 300000
        metric.reporters = []
        metrics.num.samples = 2
        metrics.recording.level = INFO
        metrics.sample.window.ms = 30000
        partitioner.class = class org.apache.kafka.clients.producer.internals.DefaultPartitioner
        receive.buffer.bytes = 32768
        reconnect.backoff.max.ms = 1000
        reconnect.backoff.ms = 50
        request.timeout.ms = 30000
        retries = 2147483647
        retry.backoff.ms = 100
        sasl.client.callback.handler.class = null
        sasl.jaas.config = [hidden]
        sasl.kerberos.kinit.cmd = /usr/bin/kinit
        sasl.kerberos.min.time.before.relogin = 60000
        sasl.kerberos.service.name = null
        sasl.kerberos.ticket.renew.jitter = 0.05
        sasl.kerberos.ticket.renew.window.factor = 0.8
        sasl.login.callback.handler.class = null
        sasl.login.class = null
        sasl.login.refresh.buffer.seconds = 300
        sasl.login.refresh.min.period.seconds = 60
        sasl.login.refresh.window.factor = 0.8
        sasl.login.refresh.window.jitter = 0.05
        sasl.mechanism = SCRAM-SHA-512
        security.protocol = SASL_SSL
        security.providers = null
        send.buffer.bytes = 131072
        socket.connection.setup.timeout.max.ms = 127000
        socket.connection.setup.timeout.ms = 10000
        ssl.cipher.suites = null
        ssl.enabled.protocols = [TLSv1.2, TLSv1.3]
        ssl.endpoint.identification.algorithm = 
        ssl.engine.factory.class = null
        ssl.key.password = null
        ssl.keymanager.algorithm = SunX509
        ssl.keystore.certificate.chain = null
        ssl.keystore.key = null
        ssl.keystore.location = null
        ssl.keystore.password = null
        ssl.keystore.type = JKS
        ssl.protocol = TLSv1.3
        ssl.provider = null
        ssl.secure.random.implementation = null
        ssl.trustmanager.algorithm = PKIX
        ssl.truststore.certificates = null
        ssl.truststore.location = XXXXXXX
        ssl.truststore.password = [hidden]
        ssl.truststore.type = JKS
        transaction.timeout.ms = 60000
        transactional.id = null
        value.serializer = class org.apache.kafka.common.serialization.StringSerializer

2021-12-06 16:23:57.931  INFO 5526 --- [           main] o.a.k.c.s.authenticator.AbstractLogin    : Successfully logged in.
2021-12-06 16:23:57.935  INFO 5526 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka version: 2.7.1
2021-12-06 16:23:57.935  INFO 5526 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka commitId: 61dbce85d0d41457
2021-12-06 16:23:57.935  INFO 5526 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka startTimeMs: 1638775437935
2021-12-06 16:23:58.204  WARN 5526 --- [ad | producer-1] o.apache.kafka.common.network.Selector   : [Producer clientId=producer-1] Unexpected error from kf03-vdajp-imf.linecorp-dev.com/10.127.148.6; closing connection

java.lang.NullPointerException: null
        at java.util.regex.Matcher.getTextLength(Matcher.java:1770) ~[na:na]
        at java.util.regex.Matcher.reset(Matcher.java:416) ~[na:na]
        at java.util.regex.Matcher.<init>(Matcher.java:253) ~[na:na]
        at java.util.regex.Pattern.matcher(Pattern.java:1133) ~[na:na]
        at org.apache.kafka.common.security.scram.internals.ScramFormatter.saslName(ScramFormatter.java:106) ~[kafka-sasl:na]
        at org.apache.kafka.common.security.scram.internals.ScramSaslClient.evaluateChallenge(ScramSaslClient.java:115) ~[kafka-sasl:na]
        at org.apache.kafka.common.security.authenticator.SaslClientAuthenticator.lambda$createSaslToken$1(SaslClientAuthenticator.java:524) ~[kafka-sasl:na]
        at java.security.AccessController.doPrivileged(AccessController.java:150) ~[na:na]
        at javax.security.auth.Subject.doAs(Subject.java:423) ~[na:na]
        at org.apache.kafka.common.security.authenticator.SaslClientAuthenticator.createSaslToken(SaslClientAuthenticator.java:524) ~[kafka-sasl:na]
        at org.apache.kafka.common.security.authenticator.SaslClientAuthenticator.sendSaslClientToken(SaslClientAuthenticator.java:431) ~[kafka-sasl:na]
        at org.apache.kafka.common.security.authenticator.SaslClientAuthenticator.sendInitialToken(SaslClientAuthenticator.java:330) ~[kafka-sasl:na]
        at org.apache.kafka.common.security.authenticator.SaslClientAuthenticator.authenticate(SaslClientAuthenticator.java:271) ~[kafka-sasl:na]
        at org.apache.kafka.common.network.KafkaChannel.prepare(KafkaChannel.java:176) ~[na:na]
        at org.apache.kafka.common.network.Selector.pollSelectionKeys(Selector.java:543) ~[na:na]
        at org.apache.kafka.common.network.Selector.poll(Selector.java:481) ~[na:na]
        at org.apache.kafka.clients.NetworkClient.poll(NetworkClient.java:563) ~[na:na]
        at org.apache.kafka.clients.producer.internals.Sender.runOnce(Sender.java:325) ~[na:na]
        at org.apache.kafka.clients.producer.internals.Sender.run(Sender.java:240) ~[na:na]
        at java.lang.Thread.run(Thread.java:829) ~[na:na]
        at com.oracle.svm.core.thread.JavaThreads.threadStartRoutine(JavaThreads.java:596) ~[na:na]
        at com.oracle.svm.core.posix.thread.PosixJavaThreads.pthreadStartRoutine(PosixJavaThreads.java:192) ~[na:na]

2021-12-06 16:23:58.208  WARN 5526 --- [ad | producer-1] org.apache.kafka.clients.NetworkClient   : [Producer clientId=producer-1] Connection to node -3 (XXXXX) terminated during authentication. This may happen due to any of the following reasons: (1) Authentication failed due to invalid credentials with brokers older than 1.0.0, (2) Firewall blocking Kafka TLS traffic (eg it may only allow HTTPS traffic), (3) Transient network issue.
2021-12-06 16:23:58.208  WARN 5526 --- [ad | producer-1] org.apache.kafka.clients.NetworkClient   : [Producer clientId=producer-1] Bootstrap broker XXXXX (id: -3 rack: null) disconnected
2021-12-06 16:23:58.520  WARN 5526 --- [ad | producer-1] o.apache.kafka.common.network.Selector   : [Producer clientId=producer-1] Unexpected error from XXXXXX; closing connection

```
