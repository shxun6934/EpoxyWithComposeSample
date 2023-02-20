package com.epoxy.with.compose.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.databinding.DataBindingUtil
import com.airbnb.epoxy.composableInterop
import com.epoxy.with.compose.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // bindingにレイアウトを読み込ませる
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // EpoxyRecyclerViewのバインド
        binding.epoxyRecyclerView.withModels {

            itemTitleText {
                id("hello_text_dataBinding")
                text("Hello, World! (data-binding)")
            }

            // Composeのコンポーネントを呼び出す
            composableInterop("hello_text_compose") {
                HelloText(text = "Hello, World! (Compose)")
            }
        }
    }

    @Composable
    private fun HelloText(text: String) {
        Text(
            text = text,
            color = Color.Red,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
