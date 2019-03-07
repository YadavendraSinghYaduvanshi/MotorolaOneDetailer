
package com.cpm.motorolaonedetailer.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.cpm.motorolaonedetailer.Constant.CommonString;
import com.cpm.motorolaonedetailer.GetterSetter.VisitCountGetterSetter;

/**
 * Created by neeraj on 21-04-2018.
 */

public class MotorolaDetailerDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MotorolaDetailer_DB";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public MotorolaDetailerDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Context context1 = context;
    }

    public void open() {
        try {
            db = this.getWritableDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CommonString.CREATE_TABLE_TOTAL_VISIT_COUNT);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertVisitCountData(String visit_date, int count, int index, String emp_id) {
        ContentValues values = new ContentValues();
        try {
            values.put(CommonString.KEY_EMP_CD, emp_id);
            values.put(CommonString.KEY_VISIT_DATE,visit_date);
            if(index == 1){
                values.put(CommonString.KEY_SUPER_FAST_PROCESSOR_COUNTER,count);
            }else if(index == 2){
                values.put(CommonString.KEY_U_NOTCH_DISPLAY_COUNTER,count);
            }else if(index == 3){
                values.put(CommonString.KEY_SMART_CAMERA_COUNTER,count);
            } else {
                values.put(CommonString.KEY_TURBO_POWER_CHARGING_COUNTER,count);
            }
            long id = db.insert(CommonString.TABLE_TOTAL_VISIT_COUNT, null, values);
            if (id == -1) {
                throw new Exception();
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("Database Exception  ", ex.toString());
            return false;
        }
    }

    public VisitCountGetterSetter getInsertedVisitCountData(String emp_id, String visit_date) {
        VisitCountGetterSetter countObj = new VisitCountGetterSetter();
        Cursor dbcursor = null;
        try {
            dbcursor = db.rawQuery("Select * from " + CommonString.TABLE_TOTAL_VISIT_COUNT + " Where "+CommonString.KEY_EMP_CD+" = '" + emp_id + "' and "+CommonString.KEY_VISIT_DATE+" = '" + visit_date+ "'", null);

            if (dbcursor != null) {
                dbcursor.moveToFirst();
                while (!dbcursor.isAfterLast()) {

                    countObj.setEmp_cd(dbcursor.getString(dbcursor.getColumnIndexOrThrow(CommonString.KEY_EMP_CD)));
                    countObj.setSmart_camera_count(dbcursor.getInt(dbcursor.getColumnIndexOrThrow(CommonString.KEY_SMART_CAMERA_COUNTER)));
                    countObj.setSuper_fast_processor_count(dbcursor.getInt(dbcursor.getColumnIndexOrThrow(CommonString.KEY_SUPER_FAST_PROCESSOR_COUNTER)));
                    countObj.setU_notch_display_count(dbcursor.getInt(dbcursor.getColumnIndexOrThrow(CommonString.KEY_U_NOTCH_DISPLAY_COUNTER)));
                    countObj.setTurbo_power_charging_count(dbcursor.getInt(dbcursor.getColumnIndexOrThrow(CommonString.KEY_TURBO_POWER_CHARGING_COUNTER)));
                    dbcursor.moveToNext();
                }
                dbcursor.close();
                return countObj;
            }
        } catch (Exception e) {
            return countObj;
        }
        return countObj;
    }

    public boolean updateVisitCountData(String visit_date, String emp_id, int index, int count) {
        boolean flag = false;
        ContentValues values = new ContentValues();
        try {
            if(index == 1) {
                values.put(CommonString.KEY_SUPER_FAST_PROCESSOR_COUNTER, count);
            } else if(index == 2){
                values.put(CommonString.KEY_U_NOTCH_DISPLAY_COUNTER, count);
            }else if(index == 3){
                // values.put(CommonString.KEY_SMART_CAMERA_COUNTER, count);
            } else {
                values.put(CommonString.KEY_TURBO_POWER_CHARGING_COUNTER, count);
            }
            long id = db.update(CommonString.TABLE_TOTAL_VISIT_COUNT, values, CommonString.KEY_EMP_CD + " = '" + emp_id + "' and " +CommonString.KEY_VISIT_DATE+ " = '"+visit_date+"'", null);
            if(id >0){
                flag =  true;
            }
        } catch (Exception ex) {
            Log.e("Exception", "checkOut Journey_Plan" + ex.toString());
            flag  = false;
        }
        return flag;
    }
}