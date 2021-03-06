package com.jkrm.education.db.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.jkrm.education.db.DaoMicroLessonBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DAO_MICRO_LESSON_BEAN".
*/
public class DaoMicroLessonBeanDao extends AbstractDao<DaoMicroLessonBean, String> {

    public static final String TABLENAME = "DAO_MICRO_LESSON_BEAN";

    /**
     * Properties of entity DaoMicroLessonBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property Keywords = new Property(1, String.class, "keywords", false, "KEYWORDS");
        public final static Property MlessonCount = new Property(2, String.class, "mlessonCount", false, "MLESSON_COUNT");
        public final static Property MlessonExplain = new Property(3, String.class, "mlessonExplain", false, "MLESSON_EXPLAIN");
        public final static Property MlessonName = new Property(4, String.class, "mlessonName", false, "MLESSON_NAME");
        public final static Property MlessonPrice = new Property(5, String.class, "mlessonPrice", false, "MLESSON_PRICE");
        public final static Property MlessonUrl = new Property(6, String.class, "mlessonUrl", false, "MLESSON_URL");
        public final static Property OneId = new Property(7, String.class, "oneId", false, "ONE_ID");
        public final static Property Order = new Property(8, String.class, "order", false, "ORDER");
        public final static Property OrderBy = new Property(9, String.class, "orderBy", false, "ORDER_BY");
        public final static Property OrderKey = new Property(10, String.class, "orderKey", false, "ORDER_KEY");
        public final static Property OrderType = new Property(11, String.class, "orderType", false, "ORDER_TYPE");
        public final static Property PcvId = new Property(12, String.class, "pcvId", false, "PCV_ID");
        public final static Property TwoId = new Property(13, String.class, "twoId", false, "TWO_ID");
        public final static Property TypeId = new Property(14, String.class, "typeId", false, "TYPE_ID");
        public final static Property TypeName = new Property(15, String.class, "typeName", false, "TYPE_NAME");
        public final static Property WhetherBuy = new Property(16, String.class, "whetherBuy", false, "WHETHER_BUY");
        public final static Property WhetherFree = new Property(17, String.class, "whetherFree", false, "WHETHER_FREE");
        public final static Property IsCheck = new Property(18, boolean.class, "isCheck", false, "IS_CHECK");
        public final static Property CacheNum = new Property(19, String.class, "cacheNum", false, "CACHE_NUM");
        public final static Property CacheSize = new Property(20, String.class, "cacheSize", false, "CACHE_SIZE");
        public final static Property IsPause = new Property(21, boolean.class, "isPause", false, "IS_PAUSE");
    }

    private DaoSession daoSession;


    public DaoMicroLessonBeanDao(DaoConfig config) {
        super(config);
    }
    
    public DaoMicroLessonBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DAO_MICRO_LESSON_BEAN\" (" + //
                "\"ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "\"KEYWORDS\" TEXT," + // 1: keywords
                "\"MLESSON_COUNT\" TEXT," + // 2: mlessonCount
                "\"MLESSON_EXPLAIN\" TEXT," + // 3: mlessonExplain
                "\"MLESSON_NAME\" TEXT," + // 4: mlessonName
                "\"MLESSON_PRICE\" TEXT," + // 5: mlessonPrice
                "\"MLESSON_URL\" TEXT," + // 6: mlessonUrl
                "\"ONE_ID\" TEXT," + // 7: oneId
                "\"ORDER\" TEXT," + // 8: order
                "\"ORDER_BY\" TEXT," + // 9: orderBy
                "\"ORDER_KEY\" TEXT," + // 10: orderKey
                "\"ORDER_TYPE\" TEXT," + // 11: orderType
                "\"PCV_ID\" TEXT," + // 12: pcvId
                "\"TWO_ID\" TEXT," + // 13: twoId
                "\"TYPE_ID\" TEXT," + // 14: typeId
                "\"TYPE_NAME\" TEXT," + // 15: typeName
                "\"WHETHER_BUY\" TEXT," + // 16: whetherBuy
                "\"WHETHER_FREE\" TEXT," + // 17: whetherFree
                "\"IS_CHECK\" INTEGER NOT NULL ," + // 18: isCheck
                "\"CACHE_NUM\" TEXT," + // 19: cacheNum
                "\"CACHE_SIZE\" TEXT," + // 20: cacheSize
                "\"IS_PAUSE\" INTEGER NOT NULL );"); // 21: isPause
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DAO_MICRO_LESSON_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DaoMicroLessonBean entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String keywords = entity.getKeywords();
        if (keywords != null) {
            stmt.bindString(2, keywords);
        }
 
        String mlessonCount = entity.getMlessonCount();
        if (mlessonCount != null) {
            stmt.bindString(3, mlessonCount);
        }
 
        String mlessonExplain = entity.getMlessonExplain();
        if (mlessonExplain != null) {
            stmt.bindString(4, mlessonExplain);
        }
 
        String mlessonName = entity.getMlessonName();
        if (mlessonName != null) {
            stmt.bindString(5, mlessonName);
        }
 
        String mlessonPrice = entity.getMlessonPrice();
        if (mlessonPrice != null) {
            stmt.bindString(6, mlessonPrice);
        }
 
        String mlessonUrl = entity.getMlessonUrl();
        if (mlessonUrl != null) {
            stmt.bindString(7, mlessonUrl);
        }
 
        String oneId = entity.getOneId();
        if (oneId != null) {
            stmt.bindString(8, oneId);
        }
 
        String order = entity.getOrder();
        if (order != null) {
            stmt.bindString(9, order);
        }
 
        String orderBy = entity.getOrderBy();
        if (orderBy != null) {
            stmt.bindString(10, orderBy);
        }
 
        String orderKey = entity.getOrderKey();
        if (orderKey != null) {
            stmt.bindString(11, orderKey);
        }
 
        String orderType = entity.getOrderType();
        if (orderType != null) {
            stmt.bindString(12, orderType);
        }
 
        String pcvId = entity.getPcvId();
        if (pcvId != null) {
            stmt.bindString(13, pcvId);
        }
 
        String twoId = entity.getTwoId();
        if (twoId != null) {
            stmt.bindString(14, twoId);
        }
 
        String typeId = entity.getTypeId();
        if (typeId != null) {
            stmt.bindString(15, typeId);
        }
 
        String typeName = entity.getTypeName();
        if (typeName != null) {
            stmt.bindString(16, typeName);
        }
 
        String whetherBuy = entity.getWhetherBuy();
        if (whetherBuy != null) {
            stmt.bindString(17, whetherBuy);
        }
 
        String whetherFree = entity.getWhetherFree();
        if (whetherFree != null) {
            stmt.bindString(18, whetherFree);
        }
        stmt.bindLong(19, entity.getIsCheck() ? 1L: 0L);
 
        String cacheNum = entity.getCacheNum();
        if (cacheNum != null) {
            stmt.bindString(20, cacheNum);
        }
 
        String cacheSize = entity.getCacheSize();
        if (cacheSize != null) {
            stmt.bindString(21, cacheSize);
        }
        stmt.bindLong(22, entity.getIsPause() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DaoMicroLessonBean entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String keywords = entity.getKeywords();
        if (keywords != null) {
            stmt.bindString(2, keywords);
        }
 
        String mlessonCount = entity.getMlessonCount();
        if (mlessonCount != null) {
            stmt.bindString(3, mlessonCount);
        }
 
        String mlessonExplain = entity.getMlessonExplain();
        if (mlessonExplain != null) {
            stmt.bindString(4, mlessonExplain);
        }
 
        String mlessonName = entity.getMlessonName();
        if (mlessonName != null) {
            stmt.bindString(5, mlessonName);
        }
 
        String mlessonPrice = entity.getMlessonPrice();
        if (mlessonPrice != null) {
            stmt.bindString(6, mlessonPrice);
        }
 
        String mlessonUrl = entity.getMlessonUrl();
        if (mlessonUrl != null) {
            stmt.bindString(7, mlessonUrl);
        }
 
        String oneId = entity.getOneId();
        if (oneId != null) {
            stmt.bindString(8, oneId);
        }
 
        String order = entity.getOrder();
        if (order != null) {
            stmt.bindString(9, order);
        }
 
        String orderBy = entity.getOrderBy();
        if (orderBy != null) {
            stmt.bindString(10, orderBy);
        }
 
        String orderKey = entity.getOrderKey();
        if (orderKey != null) {
            stmt.bindString(11, orderKey);
        }
 
        String orderType = entity.getOrderType();
        if (orderType != null) {
            stmt.bindString(12, orderType);
        }
 
        String pcvId = entity.getPcvId();
        if (pcvId != null) {
            stmt.bindString(13, pcvId);
        }
 
        String twoId = entity.getTwoId();
        if (twoId != null) {
            stmt.bindString(14, twoId);
        }
 
        String typeId = entity.getTypeId();
        if (typeId != null) {
            stmt.bindString(15, typeId);
        }
 
        String typeName = entity.getTypeName();
        if (typeName != null) {
            stmt.bindString(16, typeName);
        }
 
        String whetherBuy = entity.getWhetherBuy();
        if (whetherBuy != null) {
            stmt.bindString(17, whetherBuy);
        }
 
        String whetherFree = entity.getWhetherFree();
        if (whetherFree != null) {
            stmt.bindString(18, whetherFree);
        }
        stmt.bindLong(19, entity.getIsCheck() ? 1L: 0L);
 
        String cacheNum = entity.getCacheNum();
        if (cacheNum != null) {
            stmt.bindString(20, cacheNum);
        }
 
        String cacheSize = entity.getCacheSize();
        if (cacheSize != null) {
            stmt.bindString(21, cacheSize);
        }
        stmt.bindLong(22, entity.getIsPause() ? 1L: 0L);
    }

    @Override
    protected final void attachEntity(DaoMicroLessonBean entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public DaoMicroLessonBean readEntity(Cursor cursor, int offset) {
        DaoMicroLessonBean entity = new DaoMicroLessonBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // keywords
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // mlessonCount
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // mlessonExplain
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // mlessonName
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // mlessonPrice
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // mlessonUrl
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // oneId
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // order
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // orderBy
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // orderKey
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // orderType
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // pcvId
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // twoId
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // typeId
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // typeName
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // whetherBuy
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // whetherFree
            cursor.getShort(offset + 18) != 0, // isCheck
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // cacheNum
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // cacheSize
            cursor.getShort(offset + 21) != 0 // isPause
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DaoMicroLessonBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setKeywords(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setMlessonCount(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMlessonExplain(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMlessonName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setMlessonPrice(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setMlessonUrl(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setOneId(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setOrder(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setOrderBy(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setOrderKey(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setOrderType(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setPcvId(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setTwoId(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setTypeId(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setTypeName(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setWhetherBuy(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setWhetherFree(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setIsCheck(cursor.getShort(offset + 18) != 0);
        entity.setCacheNum(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setCacheSize(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setIsPause(cursor.getShort(offset + 21) != 0);
     }
    
    @Override
    protected final String updateKeyAfterInsert(DaoMicroLessonBean entity, long rowId) {
        return entity.getId();
    }
    
    @Override
    public String getKey(DaoMicroLessonBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DaoMicroLessonBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
