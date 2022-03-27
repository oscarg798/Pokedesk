package com.oscarg798.pokedesk.lib.pokemon.persistence;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PokeDexDatabase_Impl extends PokeDexDatabase {
  private volatile PokemonDao _pokemonDao;

  private volatile TypeDao _typeDao;

  private volatile StatsDao _statsDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PokemonEntity` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `order` INTEGER NOT NULL, `height` INTEGER NOT NULL, `weight` INTEGER NOT NULL, `image` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TypeEntity` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `vulnerableTo` TEXT NOT NULL, `resistantAgainst` TEXT NOT NULL, `weakTo` TEXT NOT NULL, `strongAgainst` TEXT NOT NULL, `noEffectiveTo` TEXT NOT NULL, `noAffectedAgainst` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PokemonTypeRef` (`pokemonId` INTEGER NOT NULL, `typeId` INTEGER NOT NULL, PRIMARY KEY(`pokemonId`, `typeId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Stat` (`statId` INTEGER NOT NULL, `name` TEXT NOT NULL, `value` INTEGER NOT NULL, `pokemonId` INTEGER NOT NULL, PRIMARY KEY(`statId`, `pokemonId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4a69062e59fbbfdf31ee7ff8d66bc91a')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `PokemonEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `TypeEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `PokemonTypeRef`");
        _db.execSQL("DROP TABLE IF EXISTS `Stat`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsPokemonEntity = new HashMap<String, TableInfo.Column>(6);
        _columnsPokemonEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPokemonEntity.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPokemonEntity.put("order", new TableInfo.Column("order", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPokemonEntity.put("height", new TableInfo.Column("height", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPokemonEntity.put("weight", new TableInfo.Column("weight", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPokemonEntity.put("image", new TableInfo.Column("image", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPokemonEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPokemonEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPokemonEntity = new TableInfo("PokemonEntity", _columnsPokemonEntity, _foreignKeysPokemonEntity, _indicesPokemonEntity);
        final TableInfo _existingPokemonEntity = TableInfo.read(_db, "PokemonEntity");
        if (! _infoPokemonEntity.equals(_existingPokemonEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "PokemonEntity(com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity).\n"
                  + " Expected:\n" + _infoPokemonEntity + "\n"
                  + " Found:\n" + _existingPokemonEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsTypeEntity = new HashMap<String, TableInfo.Column>(8);
        _columnsTypeEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTypeEntity.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTypeEntity.put("vulnerableTo", new TableInfo.Column("vulnerableTo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTypeEntity.put("resistantAgainst", new TableInfo.Column("resistantAgainst", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTypeEntity.put("weakTo", new TableInfo.Column("weakTo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTypeEntity.put("strongAgainst", new TableInfo.Column("strongAgainst", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTypeEntity.put("noEffectiveTo", new TableInfo.Column("noEffectiveTo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTypeEntity.put("noAffectedAgainst", new TableInfo.Column("noAffectedAgainst", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTypeEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTypeEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTypeEntity = new TableInfo("TypeEntity", _columnsTypeEntity, _foreignKeysTypeEntity, _indicesTypeEntity);
        final TableInfo _existingTypeEntity = TableInfo.read(_db, "TypeEntity");
        if (! _infoTypeEntity.equals(_existingTypeEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "TypeEntity(com.oscarg798.pokedesk.lib.pokemon.model.TypeEntity).\n"
                  + " Expected:\n" + _infoTypeEntity + "\n"
                  + " Found:\n" + _existingTypeEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsPokemonTypeRef = new HashMap<String, TableInfo.Column>(2);
        _columnsPokemonTypeRef.put("pokemonId", new TableInfo.Column("pokemonId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPokemonTypeRef.put("typeId", new TableInfo.Column("typeId", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPokemonTypeRef = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPokemonTypeRef = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPokemonTypeRef = new TableInfo("PokemonTypeRef", _columnsPokemonTypeRef, _foreignKeysPokemonTypeRef, _indicesPokemonTypeRef);
        final TableInfo _existingPokemonTypeRef = TableInfo.read(_db, "PokemonTypeRef");
        if (! _infoPokemonTypeRef.equals(_existingPokemonTypeRef)) {
          return new RoomOpenHelper.ValidationResult(false, "PokemonTypeRef(com.oscarg798.pokedesk.lib.pokemon.model.PokemonTypeRef).\n"
                  + " Expected:\n" + _infoPokemonTypeRef + "\n"
                  + " Found:\n" + _existingPokemonTypeRef);
        }
        final HashMap<String, TableInfo.Column> _columnsStat = new HashMap<String, TableInfo.Column>(4);
        _columnsStat.put("statId", new TableInfo.Column("statId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStat.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStat.put("value", new TableInfo.Column("value", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStat.put("pokemonId", new TableInfo.Column("pokemonId", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStat = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStat = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStat = new TableInfo("Stat", _columnsStat, _foreignKeysStat, _indicesStat);
        final TableInfo _existingStat = TableInfo.read(_db, "Stat");
        if (! _infoStat.equals(_existingStat)) {
          return new RoomOpenHelper.ValidationResult(false, "Stat(com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity.Stat).\n"
                  + " Expected:\n" + _infoStat + "\n"
                  + " Found:\n" + _existingStat);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "4a69062e59fbbfdf31ee7ff8d66bc91a", "31f73a3365d32e0654329df6248b6650");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "PokemonEntity","TypeEntity","PokemonTypeRef","Stat");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `PokemonEntity`");
      _db.execSQL("DELETE FROM `TypeEntity`");
      _db.execSQL("DELETE FROM `PokemonTypeRef`");
      _db.execSQL("DELETE FROM `Stat`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(PokemonDao.class, PokemonDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TypeDao.class, TypeDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(StatsDao.class, StatsDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public PokemonDao pokemonDao() {
    if (_pokemonDao != null) {
      return _pokemonDao;
    } else {
      synchronized(this) {
        if(_pokemonDao == null) {
          _pokemonDao = new PokemonDao_Impl(this);
        }
        return _pokemonDao;
      }
    }
  }

  @Override
  public TypeDao typeDao() {
    if (_typeDao != null) {
      return _typeDao;
    } else {
      synchronized(this) {
        if(_typeDao == null) {
          _typeDao = new TypeDao_Impl(this);
        }
        return _typeDao;
      }
    }
  }

  @Override
  public StatsDao statDao() {
    if (_statsDao != null) {
      return _statsDao;
    } else {
      synchronized(this) {
        if(_statsDao == null) {
          _statsDao = new StatsDao_Impl(this);
        }
        return _statsDao;
      }
    }
  }
}
