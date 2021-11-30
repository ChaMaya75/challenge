package com.cml.challenge

import android.app.Application
import com.cml.challenge.ui.detail.DetailFragment
import com.cml.challenge.ui.detail.DetailViewModel
import com.cml.challenge.ui.products.ProductViewModel
import com.cml.challenge.ui.products.ProductsFragment
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.qualifier.named
import org.koin.dsl.module

class ChallengeApp : Application() {

    companion object {
        lateinit var instance: ChallengeApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidLogger(Level.NONE)
            androidContext(instance)
            modules(listOf(scopesModule))
        }

    }
}
private val scopesModule = module {

    scope(named<ProductsFragment>()) {
        viewModel { (query: String) -> ProductViewModel(query) }
    }

    scope(named<DetailFragment>()) {
        viewModel { (idItem: String) -> DetailViewModel(idItem) }
    }
}