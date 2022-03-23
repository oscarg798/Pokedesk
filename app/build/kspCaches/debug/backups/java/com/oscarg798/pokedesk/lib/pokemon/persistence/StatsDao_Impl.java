package com.oscarg798.pokedesk.lib.pokemon.persistence;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class StatsDao_Impl implements StatsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PokemonEntity.Stat> __insertionAdapterOfStat;

  public StatsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStat = new EntityInsertionAdapter<PokemonEntity.Stat>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Stat` (`statId`,`name`,`value`,`pokemonId`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PokemonEntity.Stat value) {
        stmt.bindLong(1, value.getStatId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getValue());
        stmt.bindLong(4, value.getPokemonId());
      }
    };
  }

  @Override
  public void insert(final PokemonEntity.Stat stat) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfStat.insert(stat);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<PokemonEntity.Stat> getByPokemonId(final int pokemonId) {
    final String _sql = "select * from stat where pokemonId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, pokemonId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfStatId = CursorUtil.getColumnIndexOrThrow(_cursor, "statId");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final int _cursorIndexOfPokemonId = CursorUtil.getColumnIndexOrThrow(_cursor, "pokemonId");
      final List<PokemonEntity.Stat> _result = new ArrayList<PokemonEntity.Stat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PokemonEntity.Stat _item;
        final int _tmpStatId;
        _tmpStatId = _cursor.getInt(_cursorIndexOfStatId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final int _tmpValue;
        _tmpValue = _cursor.getInt(_cursorIndexOfValue);
        final int _tmpPokemonId;
        _tmpPokemonId = _cursor.getInt(_cursorIndexOfPokemonId);
        _item = new PokemonEntity.Stat(_tmpStatId,_tmpName,_tmpValue,_tmpPokemonId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
