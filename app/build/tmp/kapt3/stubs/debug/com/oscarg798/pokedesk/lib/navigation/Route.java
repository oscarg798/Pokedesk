package com.oscarg798.pokedesk.lib.navigation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0014\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0003H\u0004J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/oscarg798/pokedesk/lib/navigation/Route;", "", "route", "", "uriPatternSuffix", "(Ljava/lang/String;Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "getDeepLinks", "", "Landroidx/navigation/NavDeepLink;", "getDeeplinkNavigationRoute", "Landroid/net/Uri;", "arguments", "Landroid/os/Bundle;", "getUriPattern", "navigate", "", "navController", "Landroidx/navigation/NavController;", "app_debug"})
public abstract class Route {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    private final java.lang.String uriPatternSuffix = null;
    
    public Route(@org.jetbrains.annotations.NotNull
    java.lang.String route, @org.jetbrains.annotations.NotNull
    java.lang.String uriPatternSuffix) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    protected android.net.Uri getDeeplinkNavigationRoute(@org.jetbrains.annotations.Nullable
    android.os.Bundle arguments) {
        return null;
    }
    
    public final void navigate(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController, @org.jetbrains.annotations.Nullable
    android.os.Bundle arguments) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<androidx.navigation.NavDeepLink> getDeepLinks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    protected final java.lang.String getUriPattern() {
        return null;
    }
}