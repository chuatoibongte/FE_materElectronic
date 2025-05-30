package com.example.mater_electronic.ui.activity.success;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mater_electronic.MainActivity;
import com.example.mater_electronic.R;
import com.example.mater_electronic.databinding.ActivitySucessBinding;
import com.example.mater_electronic.models.ProductItem;
import com.example.mater_electronic.ui.activity.checkout.ActivityCheckout;
import com.example.mater_electronic.ui.navigation.home.HomeProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class ActivitySuccess extends AppCompatActivity {

    private ActivitySucessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySucessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Kiểm tra đơn hàng thành công hay không
        boolean wantsNotification = getIntent().getBooleanExtra("wants_notification", false);
        boolean success = getIntent().getBooleanExtra("success", false);
        if(success) {
            binding.tvThankYou.setText("Cảm Ơn");
            binding.tvMessage.setText("Đơn Hàng Của Bạn Đã Đặt Thành Công. \nVui lòng kiểm tra trong đơn hàng của bạn");
        }
        else {
            binding.tvThankYou.setText("Đơn Hàng Của Tôi");
            binding.tvMessage.setText("Đơn Hàng Của Bạn Thanh Toán Không Thành Công\nCó Lỗi Trong Quá Trình Thanh Toán\nĐơn Hàng Của Bạn. Hãy Thử Lại!");
        }
//        if (wantsNotification) {
//            binding.tvThankYou.setText("Cảm Ơn");
//            binding.tvMessage.setText("Đơn Hàng Của Bạn Đã Đặt Thành Công");
//        } else {
//            binding.tvThankYou.setText("Đơn Hàng Của Tôi");
//            binding.tvMessage.setText("Đơn Hàng Của Bạn Thanh Toán Không Thành Công\nCó Lỗi Trong Quá Trình Thanh Toán\nĐơn Hàng Của Bạn. Hãy Thử Lại!");
//        }

        // Thiết lập danh sách sản phẩm (luôn luôn hiển thị)
        RecyclerView recyclerView = binding.rvProductList;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        // ...
        binding.btnGoHome.setOnClickListener(v -> {
            Intent intent = new Intent(ActivitySuccess.this, MainActivity.class);
            intent.putExtra("wants_notification", wantsNotification);
            startActivity(intent);
        });


    }
}
