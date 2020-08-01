package io.quee.ktx.port.logger.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.bind.DefaultValue
import org.zalando.logbook.DefaultHttpLogWriter

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Sunday **21**, June 2020**
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "ktx.logger")
data class KtxLoggerConfig(
        @DefaultValue("DEFAULT") val formatter: FormatterType,
        @DefaultValue("########") val mask: String,
        val maskedKeys: Set<String> = HashSet(),
        val loggerName: Class<*> = KtxLoggerConfig::class.java,
        @DefaultValue("DEBUG") val level: DefaultHttpLogWriter.Level
)