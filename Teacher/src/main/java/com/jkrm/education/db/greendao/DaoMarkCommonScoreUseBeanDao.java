package com.jkrm.education.db.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.jkrm.education.db.ListConvert;
import java.util.List;

import com.jkrm.education.bean.DaoMarkCommonScoreUseBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DAO_MARK_COMMON_SCORE_USE_BEAN".
*/
public class DaoMarkCommonScoreUseBeanDao extends AbstractDao<DaoMarkCommonScoreUseBean, Long> {

    public static final String TABLENAME = "DAO_MARK_COMMON_SCORE_USE_BEAN";

    /**
     * Properties of entity DaoMarkCommonScoreUseBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property QuestionId = new Property(2, String.class, "questionId", false, "QUESTION_ID");
        public final static Property List = new Property(3, String.class, "list", false, "LIST");
    }

    private final ListConvert listConverter = new ListConvert();

    public DaoMarkCommonScoreUseBeanDao(DaoConfig config) {
        super(config);
    }
    
    public DaoMarkCommonScoreUseBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DAO_MARK_COMMON_SCORE_USE_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"QUESTION_ID\" TEXT UNIQUE ," + // 2: questionId
                "\"LIST\" TEXT);"); // 3: list
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DAO_MARK_COMMON_SCORE_USE_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DaoMarkCommonScoreUseBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String questionId = entity.getQuestionId();
        if (questionId != null) {
            stmt.bindString(3, questionId);
        }
 
        List list = entity.getList();
        if (list != null) {
            stmt.bindString(4, listConverter.convertToDatabaseValue(list));
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DaoMarkCommonScoreUseBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String questionId = entity.getQuestionId();
        if (questionId != null) {
            stmt.bindString(3, questionId);
        }
 
        List list = entity.getList();
        if (list != null) {
            stmt.bindString(4, listConverter.convertToDatabaseValue(list));
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DaoMarkCommonScoreUseBean readEntity(Cursor cursor, int offset) {
        DaoMarkCommonScoreUseBean entity = new DaoMarkCommonScoreUseBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // questionId
            cursor.isNull(offset + 3) ? null : listConverter.convertToEntityProperty(cursor.getString(offset + 3)) // list
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DaoMarkCommonScoreUseBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setQuestionId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setList(cursor.isNull(offset + 3) ? null : listConverter.convertToEntityProperty(cursor.getString(offset + 3)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DaoMarkCommonScoreUseBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DaoMarkCommonScoreUseBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DaoMarkCommonScoreUseBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
