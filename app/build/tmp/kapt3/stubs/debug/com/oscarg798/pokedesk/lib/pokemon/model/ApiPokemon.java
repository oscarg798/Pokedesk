package com.oscarg798.pokedesk.lib.pokemon.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0003+,-BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u00c6\u0003J\t\u0010$\u001a\u00020\u000fH\u00c6\u0003Je\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u00c6\u0001J\u0013\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020\u0003H\u00d6\u0001J\t\u0010*\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012\u00a8\u0006."}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon;", "", "id", "", "name", "", "order", "height", "weight", "types", "", "Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$APIType;", "stats", "Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiStat;", "image", "Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiImages;", "(ILjava/lang/String;IIILjava/util/List;Ljava/util/List;Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiImages;)V", "getHeight", "()I", "getId", "getImage", "()Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiImages;", "getName", "()Ljava/lang/String;", "getOrder", "getStats", "()Ljava/util/List;", "getTypes", "getWeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "APIType", "ApiImages", "ApiStat", "app_debug"})
public final class ApiPokemon {
    @com.google.gson.annotations.SerializedName(value = "id")
    private final int id = 0;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "name")
    private final java.lang.String name = null;
    @com.google.gson.annotations.SerializedName(value = "order")
    private final int order = 0;
    @com.google.gson.annotations.SerializedName(value = "height")
    private final int height = 0;
    @com.google.gson.annotations.SerializedName(value = "weight")
    private final int weight = 0;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "types")
    private final java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.APIType> types = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "stats")
    private final java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiStat> stats = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "sprites")
    private final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages image = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon copy(int id, @org.jetbrains.annotations.NotNull
    java.lang.String name, int order, int height, int weight, @org.jetbrains.annotations.NotNull
    java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.APIType> types, @org.jetbrains.annotations.NotNull
    java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiStat> stats, @org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages image) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public ApiPokemon(int id, @org.jetbrains.annotations.NotNull
    java.lang.String name, int order, int height, int weight, @org.jetbrains.annotations.NotNull
    java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.APIType> types, @org.jetbrains.annotations.NotNull
    java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiStat> stats, @org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages image) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getOrder() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getHeight() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getWeight() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.APIType> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.APIType> getTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiStat> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiStat> getStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages getImage() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\rH\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiImages;", "", "artWork", "Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiImages$ArtWork;", "(Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiImages$ArtWork;)V", "getArtWork", "()Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiImages$ArtWork;", "component1", "copy", "equals", "", "other", "getImageUrl", "", "hashCode", "", "toString", "ArtWork", "app_debug"})
    public static final class ApiImages {
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "other")
        private final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages.ArtWork artWork = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages copy(@org.jetbrains.annotations.NotNull
        com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages.ArtWork artWork) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public ApiImages(@org.jetbrains.annotations.NotNull
        com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages.ArtWork artWork) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages.ArtWork component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages.ArtWork getArtWork() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getImageUrl() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiImages$ArtWork;", "", "detail", "Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiImages$ArtWork$Detail;", "(Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiImages$ArtWork$Detail;)V", "getDetail", "()Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiImages$ArtWork$Detail;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Detail", "app_debug"})
        public static final class ArtWork {
            @org.jetbrains.annotations.NotNull
            @com.google.gson.annotations.SerializedName(value = "official-artwork")
            private final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages.ArtWork.Detail detail = null;
            
            @org.jetbrains.annotations.NotNull
            public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages.ArtWork copy(@org.jetbrains.annotations.NotNull
            com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages.ArtWork.Detail detail) {
                return null;
            }
            
            @java.lang.Override
            public boolean equals(@org.jetbrains.annotations.Nullable
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull
            @java.lang.Override
            public java.lang.String toString() {
                return null;
            }
            
            public ArtWork(@org.jetbrains.annotations.NotNull
            com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages.ArtWork.Detail detail) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages.ArtWork.Detail component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages.ArtWork.Detail getDetail() {
                return null;
            }
            
            @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiImages$ArtWork$Detail;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
            public static final class Detail {
                @org.jetbrains.annotations.NotNull
                @com.google.gson.annotations.SerializedName(value = "front_default")
                private final java.lang.String url = null;
                
                @org.jetbrains.annotations.NotNull
                public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiImages.ArtWork.Detail copy(@org.jetbrains.annotations.NotNull
                java.lang.String url) {
                    return null;
                }
                
                @java.lang.Override
                public boolean equals(@org.jetbrains.annotations.Nullable
                java.lang.Object other) {
                    return false;
                }
                
                @java.lang.Override
                public int hashCode() {
                    return 0;
                }
                
                @org.jetbrains.annotations.NotNull
                @java.lang.Override
                public java.lang.String toString() {
                    return null;
                }
                
                public Detail(@org.jetbrains.annotations.NotNull
                java.lang.String url) {
                    super();
                }
                
                @org.jetbrains.annotations.NotNull
                public final java.lang.String component1() {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull
                public final java.lang.String getUrl() {
                    return null;
                }
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$APIType;", "", "detail", "Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$APIType$Detail;", "(Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$APIType$Detail;)V", "getDetail", "()Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$APIType$Detail;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Detail", "app_debug"})
    public static final class APIType {
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "type")
        private final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.APIType.Detail detail = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.APIType copy(@org.jetbrains.annotations.NotNull
        com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.APIType.Detail detail) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public APIType(@org.jetbrains.annotations.NotNull
        com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.APIType.Detail detail) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.APIType.Detail component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.APIType.Detail getDetail() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$APIType$Detail;", "", "url", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
        public static final class Detail {
            @org.jetbrains.annotations.NotNull
            @com.google.gson.annotations.SerializedName(value = "url")
            private final java.lang.String url = null;
            @org.jetbrains.annotations.NotNull
            @com.google.gson.annotations.SerializedName(value = "name")
            private final java.lang.String name = null;
            
            @org.jetbrains.annotations.NotNull
            public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.APIType.Detail copy(@org.jetbrains.annotations.NotNull
            java.lang.String url, @org.jetbrains.annotations.NotNull
            java.lang.String name) {
                return null;
            }
            
            @java.lang.Override
            public boolean equals(@org.jetbrains.annotations.Nullable
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull
            @java.lang.Override
            public java.lang.String toString() {
                return null;
            }
            
            public Detail(@org.jetbrains.annotations.NotNull
            java.lang.String url, @org.jetbrains.annotations.NotNull
            java.lang.String name) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getUrl() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String component2() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getName() {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiStat;", "", "value", "", "statInfo", "Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiStat$ApiStatInfo;", "(ILcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiStat$ApiStatInfo;)V", "getStatInfo", "()Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiStat$ApiStatInfo;", "getValue", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toStat", "Lcom/oscarg798/pokedesk/lib/pokemon/model/Pokemon$Stat;", "toString", "", "ApiStatInfo", "app_debug"})
    public static final class ApiStat {
        @com.google.gson.annotations.SerializedName(value = "base_stat")
        private final int value = 0;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "stat")
        private final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiStat.ApiStatInfo statInfo = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiStat copy(int value, @org.jetbrains.annotations.NotNull
        com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiStat.ApiStatInfo statInfo) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public ApiStat(int value, @org.jetbrains.annotations.NotNull
        com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiStat.ApiStatInfo statInfo) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int getValue() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiStat.ApiStatInfo component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiStat.ApiStatInfo getStatInfo() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.oscarg798.pokedesk.lib.pokemon.model.Pokemon.Stat toStat() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$ApiStat$ApiStatInfo;", "", "url", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
        public static final class ApiStatInfo {
            @org.jetbrains.annotations.NotNull
            @com.google.gson.annotations.SerializedName(value = "url")
            private final java.lang.String url = null;
            @org.jetbrains.annotations.NotNull
            @com.google.gson.annotations.SerializedName(value = "name")
            private final java.lang.String name = null;
            
            @org.jetbrains.annotations.NotNull
            public final com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.ApiStat.ApiStatInfo copy(@org.jetbrains.annotations.NotNull
            java.lang.String url, @org.jetbrains.annotations.NotNull
            java.lang.String name) {
                return null;
            }
            
            @java.lang.Override
            public boolean equals(@org.jetbrains.annotations.Nullable
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull
            @java.lang.Override
            public java.lang.String toString() {
                return null;
            }
            
            public ApiStatInfo(@org.jetbrains.annotations.NotNull
            java.lang.String url, @org.jetbrains.annotations.NotNull
            java.lang.String name) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getUrl() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String component2() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getName() {
                return null;
            }
        }
    }
}