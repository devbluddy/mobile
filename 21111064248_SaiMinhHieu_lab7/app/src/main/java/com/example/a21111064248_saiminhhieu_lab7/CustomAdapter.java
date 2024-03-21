package com.example.a21111064248_saiminhhieu_lab7;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Product> mProductList;
    public CustomAdapter(Context context, ArrayList<Product> productList) {
        mContext = context;
        mProductList = productList;
    }
    @Override
    public int getCount() {
        return mProductList.size();
    }
    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view==null){
            LayoutInflater inflater = (LayoutInflater)
                    mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.custom_list_item,null);
    }
    // Ánh xạ các thành phần trong layout của mỗi item trong ListView
        TextView textViewMaSP = view.findViewById(R.id.textViewMaSP);
        TextView textViewTenSP = view.findViewById(R.id.textViewTenSP);
        TextView textViewSoSP = view.findViewById(R.id.textViewSoSP);
        TextView textViewGiaSP = view.findViewById(R.id.textViewGiaSP);
// Lấy đối tượng Product tương ứng với vị trí position
        Product product = mProductList.get(position);
// Thiết lập dữ liệu cho các thành phần trong layout của mỗi item
        textViewMaSP.setText(String.valueOf(product.getMaSP()));

        textViewTenSP.setText(product.getTenSP());

        textViewSoSP.setText(String.valueOf(product.getSoSP()));

        textViewGiaSP.setText(String.valueOf(product.getGiaSP()));
// Tùy chỉnh định dạng các thành phần trong layout tùy chỉnh của mỗi item
// Ví dụ: Thiết lập màu sắc, kích thước, font chữ, v.v.
        textViewMaSP.setTextColor(Color.RED);

        textViewTenSP.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18); // Kích thước chữ là 18sp

// Các tùy chỉnh khác tùy thuộc vào yêu cầu cụ thể của bạn
        return view;
    }
}
