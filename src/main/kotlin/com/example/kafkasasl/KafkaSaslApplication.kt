@file:Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")

package com.example.kafkasasl

import org.apache.kafka.common.security.authenticator.AbstractLogin
import org.apache.kafka.common.security.authenticator.DefaultLogin
import org.apache.kafka.common.security.authenticator.SaslClientAuthenticator
import org.apache.kafka.common.security.authenticator.SaslClientCallbackHandler
import org.apache.kafka.common.security.plain.PlainLoginModule
import org.apache.kafka.common.security.scram.ScramLoginModule
import org.apache.kafka.common.security.scram.internals.ScramFormatter
import org.apache.kafka.common.security.scram.internals.ScramSaslClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.nativex.hint.TypeHint
import sun.security.util.Resources
import javax.security.auth.spi.LoginModule
import javax.security.sasl.SaslClient


@TypeHint(
    types = [
        SaslClientCallbackHandler::class,
        DefaultLogin::class, AbstractLogin.DefaultLoginCallbackHandler::class, PlainLoginModule::class,
        LoginModule::class, ScramLoginModule::class, ScramSaslClient::class, ScramSaslClient.ScramSaslClientFactory::class,
        Resources::class, SaslClientAuthenticator::class, ScramFormatter::class, PlainLoginModule::class, SaslClient::class
    ]
)
@SpringBootApplication
class KafkaSaslApplication

fun main(args: Array<String>) {
    runApplication<KafkaSaslApplication>(*args)
}
