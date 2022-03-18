package com.example.testgithub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testgithub.Adapter.TblopAdapter;
import com.example.testgithub.them.them;

import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity {

    EditText edttenlop, edtnganh;
    themxoasua themxoasua;
    Button btnback;
    TblopAdapter tblopAdapter;
    ListView listViewlop;
    ArrayList<them> arrayList;
    them currentObjLop = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        btnback = findViewById(R.id.btnback);

        edttenlop = findViewById(R.id.edttenlop);
        edtnganh = findViewById(R.id.edtnganh);

        themxoasua = new themxoasua(this);//khởi tạo đối tượng truyền thêm
        themxoasua.open();//gọi hàm mở kết nối csdl

        arrayList = themxoasua.getAll();
        tblopAdapter = new TblopAdapter(arrayList);
        listViewlop = findViewById(R.id.lv_tab_lop);
        listViewlop.setAdapter(tblopAdapter);

        listViewlop.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                currentObjLop = arrayList.get(i);
                edttenlop.setText(currentObjLop.getTen_lop());
                edtnganh.setText(currentObjLop.getNganh());
                return false;
                }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity1.this,coban.class);
                startActivity(it);
            }
        });


//        Sinhvien createdbsinhvien = new Sinhvien(this);
//        createdbsinhvien.getWritableDatabase();
    }
        public void AddRow(View view){
            them tblop = new them();
            tblop.setTen_lop((edttenlop.getText().toString()));
            tblop.setNganh(edtnganh.getText().toString());


            long kq = themxoasua.AddNew(tblop);
            if(kq>0){
                arrayList.clear();
                arrayList.addAll(themxoasua.getAll());
                tblopAdapter.notifyDataSetChanged();
                Toast.makeText(this,"thanhcong" ,Toast.LENGTH_SHORT).show();

            }else
                Toast.makeText(this,"thatbai" ,Toast.LENGTH_SHORT).show();
        }
        public void UpdateRow(View view){

            //lấy tên mới sửa trên giao diện cho vào biến
            String tenlop_new = edttenlop.getText().toString();
            String tennganh_new = edtnganh.getText().toString();

            //so sánh nếu chưa set được biến hoặc không có thay đổi thì không lưu

            if(currentObjLop != null &&
                    (!currentObjLop.getTen_lop().equalsIgnoreCase(tenlop_new)||!currentObjLop.getNganh().equalsIgnoreCase(tennganh_new))){

            //cập nhật lại biến current
            currentObjLop.setTen_lop(tenlop_new);
            currentObjLop.setNganh(tennganh_new);

            //gọi hàm update
            int res = themxoasua.Update(currentObjLop);
            if(res>0){
                edttenlop.setText("");
                edtnganh.setText("");
                //load lại arraylist
                arrayList.clear();
                arrayList.addAll(themxoasua.getAll());
                tblopAdapter.notifyDataSetChanged();
                Toast.makeText(this,"Cập nhật thành công",Toast.LENGTH_SHORT).show();
                currentObjLop = null;
            }else{
                Toast.makeText(this,"Lỗi không thể cập nhật",Toast.LENGTH_SHORT).show();

            }

            }else {
                Toast.makeText(this,"Không có thay đổi để cập nhật",Toast.LENGTH_SHORT).show();
            }



    }
    public void DeleteRow(View view){
        if (currentObjLop != null){
            //nếu đã chọn phần tử để xóa thì xóa
            int res = themxoasua.Delete(currentObjLop);
            if (res>0){
                //cập nhật lại danh sách
                arrayList.clear();
                arrayList.addAll(themxoasua.getAll());
                tblopAdapter.notifyDataSetChanged();
                edttenlop.setText("");
                edtnganh.setText("");

                Toast.makeText(this,"Đã xóa thành công: "+currentObjLop.getTen_lop(),Toast.LENGTH_SHORT).show();
                //Đưa current về null vì ko còn tác dụng
                currentObjLop = null;
            }else{
                Toast.makeText(this,"Lỗi xóa",Toast.LENGTH_SHORT).show();

            }
        }else {
            Toast.makeText(this,"Hãy chọn trước khi bấm xóa",Toast.LENGTH_SHORT).show();

        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        themxoasua.close();
    }
}