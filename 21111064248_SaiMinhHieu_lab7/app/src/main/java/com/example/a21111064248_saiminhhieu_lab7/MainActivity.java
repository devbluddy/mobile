package com.example.a21111064248_saiminhhieu_lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.a21111064248_saiminhhieu_lab7.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextMaSP, editTextTenSP, editTextSoSP, editTextGiaSP;
    Button buttonThem, buttonSua, buttonXoa;
    ListView listViewDSSP;
    ArrayList<Product> productArrayList = new ArrayList<>();
    ProductDAO produtcDAO;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMaSP = findViewById(R.id.editTextMaSP);
        editTextTenSP = findViewById(R.id.editTextTenSP);
        editTextSoSP = findViewById(R.id.editTextSoSP);
        editTextGiaSP = findViewById(R.id.editTextGiaSP);
        buttonThem = findViewById(R.id.buttonThem);
        buttonSua = findViewById(R.id.buttonSua);
        buttonXoa = findViewById(R.id.buttonXoa);
        listViewDSSP = findViewById(R.id.listViewSanPham);
        produtcDAO = new ProductDAO(context);
        productArrayList = produtcDAO.getListProduct();
// Tạo adapter tùy chỉnh và thiết lập cho ListView
        CustomAdapter customAdapter = new CustomAdapter(context, productArrayList);

        listViewDSSP.setAdapter(customAdapter);
// Chức năng nút Thêm
       buttonThem.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
// Thêm sản phẩm mới vào cơ sở dữ liệu
               Product product = new Product();
               product.setMaSP(Integer.parseInt(editTextMaSP.getText().toString()));
               product.setTenSP(editTextTenSP.getText().toString());
               product.setSoSP(Integer.parseInt(editTextSoSP.getText().toString()));
               product.setGiaSP(Long.parseLong(editTextGiaSP.getText().toString()));
               produtcDAO.addProdut(product);
// Cập nhật danh sách sản phẩm và thông báo cho adapter biết dữ liệu đã thay đổi

               productArrayList.clear();
               productArrayList.addAll(produtcDAO.getListProduct());
               customAdapter.notifyDataSetChanged();
           }
       });
// Chức năng nút Sửa
        buttonSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// Cập nhật thông tin sản phẩm trong cơ sở dữ liệu
                Product product = new Product();
                product.setMaSP(Integer.parseInt(editTextMaSP.getText().toString()));
                product.setTenSP(editTextTenSP.getText().toString());
                product.setSoSP(Integer.parseInt(editTextSoSP.getText().toString()));
                product.setGiaSP(Long.parseLong(editTextGiaSP.getText().toString()));
                produtcDAO.updateProduct(product);
// Cập nhật danh sách sản phẩm và thông báo cho adapter biết dữ liệu đã thay đổi

                productArrayList.clear();
                productArrayList.addAll(produtcDAO.getListProduct());
                customAdapter.notifyDataSetChanged();
            }
        });
// Chức năng nút Xóa
        buttonXoa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
// Xóa sản phẩm khỏi cơ sở dữ liệu
                int maSP = Integer.parseInt(editTextMaSP.getText().toString());
                produtcDAO.deleteProduct(maSP);
// Cập nhật danh sách sản phẩm và thông báo cho adapter biết dữ liệu đã thay đổi

                productArrayList.clear();
                productArrayList.addAll(produtcDAO.getListProduct());
                customAdapter.notifyDataSetChanged();
            }
        });
    }
}