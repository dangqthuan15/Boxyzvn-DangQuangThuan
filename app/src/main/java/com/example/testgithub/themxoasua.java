package com.example.testgithub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.testgithub.SQLiteHelper.Sinhvien;
import com.example.testgithub.them.them;

import java.util.ArrayList;

public class themxoasua {
    SQLiteDatabase database;
    Sinhvien createdbsinhvien;

    public themxoasua(Context context){
        createdbsinhvien = new Sinhvien(context);
    }
    public void open(){
        database = createdbsinhvien.getWritableDatabase();
    }
    public  void close(){
        createdbsinhvien.close();
    }

    public long AddNew(them tblop){
        ContentValues contentValues = new ContentValues();
        contentValues.put(them.COD_NAME_TEN_LOP,tblop.getTen_lop());
        contentValues.put(them.COD_NAME_NGANH,tblop.getNganh());

        long res = database.insert(them.TB_NAME,null,contentValues);

        return res;
    }

    public ArrayList<them> getAll(){
        ArrayList<them> dslop = new ArrayList<them>();
        String [] danh_sach_lay_dl = new String[]{them.COL_NAME_ID,them.COD_NAME_TEN_LOP,them.COD_NAME_NGANH};

        Cursor cursor = database.query(them.TB_NAME,danh_sach_lay_dl,null,null,null,null,null);

        cursor.moveToFirst();//đưa về đầu kết quả
        while (!cursor.isAfterLast()){
            //lấy thông in từng cột cho vào biến
            int id = cursor.getInt(0);
            String ten_lop = cursor.getString(1);
            String nganh = cursor.getString(2);
            //tạo đối tượng thông tin lớp để gán thông tin vào
            them tblop = new them();
            tblop.setId_lop(id);
            tblop.setTen_lop(ten_lop);
            tblop.setNganh(nganh);
            //thêm vào danh sách
            dslop.add(tblop);
            //sau khi thêm vào danh sách thì chuyển con trỏ đoc xuống dòng tiếp theo
            cursor.moveToNext();

        }
        return dslop;//trở lại danh sách

    }
    public int Update(them tblop){
        ContentValues contentValues = new ContentValues();
        contentValues.put(them.COD_NAME_TEN_LOP,tblop.getTen_lop());
        contentValues.put(them.COD_NAME_NGANH,tblop.getNganh());

        int res = database.update(them.TB_NAME,contentValues,"id_lop = "+tblop.getId_lop(),null);

        return res;
    }

    public int Delete(them tblop){
        return database.delete(them.TB_NAME,"id_lop = "+ tblop.getId_lop(),null);
    }

}
