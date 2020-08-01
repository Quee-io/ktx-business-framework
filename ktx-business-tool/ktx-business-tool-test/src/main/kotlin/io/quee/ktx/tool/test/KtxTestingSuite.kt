package io.quee.ktx.tool.test

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestInstanceFactory
import org.junit.jupiter.api.extension.TestInstanceFactoryContext

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **02**, **Sun Aug, 2020**
 * Project **ktx-business-framework** [Quee.IO](https://quee.io/)
 */
class KtxTestingSuite : TestInstanceFactory {
    override fun createTestInstance(factoryContext: TestInstanceFactoryContext, extensionContext: ExtensionContext): Any? {
        return null
    }
}