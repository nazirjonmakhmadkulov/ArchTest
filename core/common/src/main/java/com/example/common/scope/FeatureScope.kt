package com.example.common.scope

import javax.inject.Qualifier
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureScope

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthUrl

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MarketUrl

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MessengerUrl

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class SocialUrl

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class SocketRoom

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class SocketMessage