package io.quee.ktx.port.logger

import io.quee.ktx.port.logger.config.KtxLoggerConfig
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.zalando.logbook.BodyFilters
import org.zalando.logbook.DefaultHttpLogWriter
import org.zalando.logbook.Logbook

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Sunday **21**, June 2020**
 */
@Configuration
@EnableConfigurationProperties(value = [KtxLoggerConfig::class])
@Slf4j
class KtxLoggerPortContext {
    @Bean
    @ConditionalOnMissingBean
    fun logbook(
            ktxLoggerConfig: KtxLoggerConfig
    ): Logbook {
        return Logbook.builder()
                .bodyFilter(BodyFilters.replaceJsonStringProperty(ktxLoggerConfig.maskedKeys, ktxLoggerConfig.mask))
                .formatter(ktxLoggerConfig.formatter.formatter)
                .writer(DefaultHttpLogWriter(LoggerFactory.getLogger(ktxLoggerConfig.loggerName), ktxLoggerConfig.level))
                .build()
    }
}