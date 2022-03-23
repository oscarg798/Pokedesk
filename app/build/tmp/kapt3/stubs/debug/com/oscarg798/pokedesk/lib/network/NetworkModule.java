package com.oscarg798.pokedesk.lib.network;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u00020\u00042\u0011\u0010\u0005\u001a\r\u0012\t\u0012\u00070\u0007\u00a2\u0006\u0002\b\b0\u0006H\u0007J\b\u0010\t\u001a\u00020\u0007H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/oscarg798/pokedesk/lib/network/NetworkModule;", "", "()V", "provideHttpClient", "Lokhttp3/OkHttpClient;", "interceptors", "", "Lokhttp3/Interceptor;", "Lkotlin/jvm/JvmSuppressWildcards;", "provideLoggingInterceptor", "app_debug"})
@dagger.Module()
public final class NetworkModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.oscarg798.pokedesk.lib.network.NetworkModule INSTANCE = null;
    
    private NetworkModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @dagger.multibindings.IntoSet()
    public final okhttp3.Interceptor provideLoggingInterceptor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final okhttp3.OkHttpClient provideHttpClient(@org.jetbrains.annotations.NotNull()
    java.util.Set<okhttp3.Interceptor> interceptors) {
        return null;
    }
}