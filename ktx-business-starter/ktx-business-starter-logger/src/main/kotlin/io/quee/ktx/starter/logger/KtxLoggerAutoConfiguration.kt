package io.quee.ktx.starter.logger

import io.quee.ktx.port.logger.KtxLoggerPortContext
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Sunday **21**, June 2020**
 */
@Configuration
@Import(value = [KtxLoggerPortContext::class])
class KtxLoggerAutoConfiguration