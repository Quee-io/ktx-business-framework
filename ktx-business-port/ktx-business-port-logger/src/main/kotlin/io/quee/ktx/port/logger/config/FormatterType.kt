package io.quee.ktx.port.logger.config

import org.zalando.logbook.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Sunday **21**, June 2020**
 */
enum class FormatterType(val formatter: HttpLogFormatter) {
    DEFAULT(DefaultHttpLogFormatter()),
    JSON(JsonHttpLogFormatter()),
    CURL(CurlHttpLogFormatter()),
    SPLUNK(SplunkHttpLogFormatter())
}