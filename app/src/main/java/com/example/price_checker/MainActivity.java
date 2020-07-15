package com.example.price_checker;

import androidx.appcompat.app.AppCompatActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainSetup();

    }

    protected void mainSetup() {
        final Button button = findViewById(R.id.btnSearch);
        final SearchView textSearch = findViewById(R.id.searchView );
        final WebView searchProduct = (WebView) findViewById(R.id.webView);
                searchProduct.setWebViewClient(new WebViewClient());
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                button.setText(getSearchQuery(textSearch.getQuery().toString()));
                searchProduct.loadUrl(getSearchQuery(textSearch.getQuery().toString()));
                try {

                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    String term = textSearch.getQuery().toString();
                    intent.putExtra(SearchManager.QUERY, term);

                   // startActivity(intent);
                }catch (Exception e) {}
            }
        });
    }
    protected String getSearchQuery(String query) {

        final String productName = "https://www.google.com/search?q="+ query.replace(" ", "+")+"&source=lnms&tbm=shop";

        return productName;
    }


}
