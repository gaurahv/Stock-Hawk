package com.sam_chordas.android.stockhawk.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.data.QuoteColumns;
import com.squareup.picasso.Picasso;

public class StockDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_graph);

        Intent intent = getIntent();
        String symbol = intent.getStringExtra(QuoteColumns.SYMBOL);
        ImageView imageView = (ImageView) findViewById(R.id.graph);

        Uri uri = Uri.parse("http://chart.finance.yahoo.com/z?").buildUpon()
                .appendQueryParameter("s", symbol)
                .appendQueryParameter("t", "1y")
                .appendQueryParameter("z", "l")
                .appendQueryParameter("q", "l")
                .appendQueryParameter("l", "on")
                .appendQueryParameter("p", "m50,m200")
                .build();

        Picasso.with(this)
                .load(uri)
                .into(imageView);
    }
}
