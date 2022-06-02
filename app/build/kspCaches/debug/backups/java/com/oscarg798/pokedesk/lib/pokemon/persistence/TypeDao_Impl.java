package com.oscarg798.pokedesk.lib.pokemon.persistence;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.oscarg798.pokedesk.lib.pokemon.model.PokemonTypeRef;
import com.oscarg798.pokedesk.lib.pokemon.model.TypeEntity;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TypeDao_Impl implements TypeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TypeEntity> __insertionAdapterOfTypeEntity;

  private final EntityInsertionAdapter<PokemonTypeRef> __insertionAdapterOfPokemonTypeRef;

  public TypeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTypeEntity = new EntityInsertionAdapter<TypeEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `TypeEntity` (`id`,`name`,`vulnerableTo`,`resistantAgainst`,`weakTo`,`strongAgainst`,`noEffectiveTo`,`noAffectedAgainst`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TypeEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getVulnerableTo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getVulnerableTo());
        }
        if (value.getResistantAgainst() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getResistantAgainst());
        }
        if (value.getWeakTo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWeakTo());
        }
        if (value.getStrongAgainst() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getStrongAgainst());
        }
        if (value.getNoEffectiveTo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getNoEffectiveTo());
        }
        if (value.getNoAffectedAgainst() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNoAffectedAgainst());
        }
      }
    };
    this.__insertionAdapterOfPokemonTypeRef = new EntityInsertionAdapter<PokemonTypeRef>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `PokemonTypeRef` (`pokemonId`,`typeId`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PokemonTypeRef value) {
        stmt.bindLong(1, value.getPokemonId());
        stmt.bindLong(2, value.getTypeId());
      }
    };
  }

  @Override
  public void insert(final TypeEntity typeEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTypeEntity.insert(typeEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final PokemonTypeRef pokemonTypeRef) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPokemonTypeRef.insert(pokemonTypeRef);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public TypeEntity getById(final int id) {
    final String _sql = "select * from typeentity where id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfVulnerableTo = CursorUtil.getColumnIndexOrThrow(_cursor, "vulnerableTo");
      final int _cursorIndexOfResistantAgainst = CursorUtil.getColumnIndexOrThrow(_cursor, "resistantAgainst");
      final int _cursorIndexOfWeakTo = CursorUtil.getColumnIndexOrThrow(_cursor, "weakTo");
      final int _cursorIndexOfStrongAgainst = CursorUtil.getColumnIndexOrThrow(_cursor, "strongAgainst");
      final int _cursorIndexOfNoEffectiveTo = CursorUtil.getColumnIndexOrThrow(_cursor, "noEffectiveTo");
      final int _cursorIndexOfNoAffectedAgainst = CursorUtil.getColumnIndexOrThrow(_cursor, "noAffectedAgainst");
      final TypeEntity _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpVulnerableTo;
        if (_cursor.isNull(_cursorIndexOfVulnerableTo)) {
          _tmpVulnerableTo = null;
        } else {
          _tmpVulnerableTo = _cursor.getString(_cursorIndexOfVulnerableTo);
        }
        final String _tmpResistantAgainst;
        if (_cursor.isNull(_cursorIndexOfResistantAgainst)) {
          _tmpResistantAgainst = null;
        } else {
          _tmpResistantAgainst = _cursor.getString(_cursorIndexOfResistantAgainst);
        }
        final String _tmpWeakTo;
        if (_cursor.isNull(_cursorIndexOfWeakTo)) {
          _tmpWeakTo = null;
        } else {
          _tmpWeakTo = _cursor.getString(_cursorIndexOfWeakTo);
        }
        final String _tmpStrongAgainst;
        if (_cursor.isNull(_cursorIndexOfStrongAgainst)) {
          _tmpStrongAgainst = null;
        } else {
          _tmpStrongAgainst = _cursor.getString(_cursorIndexOfStrongAgainst);
        }
        final String _tmpNoEffectiveTo;
        if (_cursor.isNull(_cursorIndexOfNoEffectiveTo)) {
          _tmpNoEffectiveTo = null;
        } else {
          _tmpNoEffectiveTo = _cursor.getString(_cursorIndexOfNoEffectiveTo);
        }
        final String _tmpNoAffectedAgainst;
        if (_cursor.isNull(_cursorIndexOfNoAffectedAgainst)) {
          _tmpNoAffectedAgainst = null;
        } else {
          _tmpNoAffectedAgainst = _cursor.getString(_cursorIndexOfNoAffectedAgainst);
        }
        _result = new TypeEntity(_tmpId,_tmpName,_tmpVulnerableTo,_tmpResistantAgainst,_tmpWeakTo,_tmpStrongAgainst,_tmpNoEffectiveTo,_tmpNoAffectedAgainst);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Integer> getTypeIdFromPokemonId(final int pokemonId) {
    final String _sql = "select typeId from pokemontyperef where pokemonId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, pokemonId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<Integer> _result = new ArrayList<Integer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Integer _item;
        _item = _cursor.getInt(0);
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
