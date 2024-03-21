package com.example.a21111064248_saiminhhieu_lab7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.util.Log;

import java.util.ArrayList;

public class ProductDAO {
    private ProducDBHelper productDBHelper;
    private SQLiteDatabase sqLiteDatabase;
    public ProductDAO(Context context){
        productDBHelper = new ProducDBHelper(context);//Gọi lệnh tạo DB
        sqLiteDatabase = productDBHelper.getWritableDatabase();
    }
    //Hàm Thêm: CREATE (C trong CRUD)
    public long addProdut(Product product){
        ContentValues contentValues = new ContentValues();
        contentValues.put("maSP",product.getMaSP());
        contentValues.put("tenSP",product.getTenSP());
        contentValues.put("soSP",product.getSoSP());
        contentValues.put("giaSP",product.getGiaSP());
        long checkDB=

                sqLiteDatabase.insert("tableProduct",null,contentValues);

        return checkDB;
    }
    //Hàm xóa: DELETE (D trong CRUD)
    public long deleteProduct(int maSP){
        long checkDB=sqLiteDatabase.delete("tableProduct","maSP=?",new

                String[]{String.valueOf(maSP)});

        return checkDB;
    }
    //Hàm sửa: UPDATE (U trong CRUD)
    public long updateProduct(Product product){
        ContentValues contentValues = new ContentValues();
        contentValues.put("maSP",product.getMaSP());
        contentValues.put("tenSP",product.getTenSP());
        contentValues.put("soSP",product.getSoSP());
        contentValues.put("giaSP",product.getGiaSP());

        long

                checkDB=sqLiteDatabase.update("tableProduct",contentValues,"maSP=?",new
                String[]{String.valueOf(product.getMaSP())});

        return checkDB;
    }
    //Hàm đọc dữ liệu:READ (R trong CRUD)
//Có thể dùng List hoặc ArrayList
    public ArrayList<Product> getListProduct(){
        ArrayList<Product> productArrayList = new ArrayList<>();
        sqLiteDatabase = productDBHelper.getReadableDatabase();
        try {
            Cursor cursor=sqLiteDatabase.rawQuery("SELECT * from tableProduct",null);

            if (cursor.getCount()>0){
                cursor.moveToFirst();
                do {
                    productArrayList.add(new Product(cursor.getInt(0),//Mã sản phẩm kiểu int
                                                        cursor.getString(1),//Tên sản phẩm kiểm String
                                                        cursor.getLong(2),//Số lượng sản phẩm kiểu int
                                                        cursor.getInt(3)));//Giá sản phẩm kiểu long

                }while (cursor.moveToNext());
            }
        }catch (Exception e){
            Log.e("TAG",e.getMessage());
        }
        return productArrayList;
    }
}
