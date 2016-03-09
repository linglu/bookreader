package com.linky;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class DBDaoGenerator {

    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.linky.bookreader.dao.orm");
        schema.enableKeepSectionsByDefault();
        schema.enableActiveEntitiesByDefault();

        addEbookScheme(schema);

        try {
            new DaoGenerator().generateAll(schema, "app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 创建电子书数据表
    private static void addEbookScheme(Schema schema) {
        Entity entity = schema.addEntity("EbookBean");
        entity.setTableName("ebook");
        entity.addIdProperty();
        entity.addStringProperty("file").notNull();
        entity.addIntProperty("lastPosition");
        entity.addIntProperty("blockSize");
        entity.addStringProperty("reader");
        entity.addDateProperty("timestamp");
    }
}
